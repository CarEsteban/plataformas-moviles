package com.example.lab11.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.tasks.await

@Composable
fun CreatePostScreen() {
    var text by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Write your post") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { imagePickerLauncher.launch("image/*") }) {
                Text("Select Image")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                coroutineScope.launch {
                    val result = savePost(text, imageUri)
                    if (result) {
                        snackbarHostState.showSnackbar("Publicación guardada exitosamente")
                    } else {
                        snackbarHostState.showSnackbar("Error al guardar la publicación")
                    }
                }
            }) {
                Text("Post")
            }
        }
    }
}

// Modificación en savePost para que devuelva un booleano
suspend fun savePost(text: String, imageUri: Uri?): Boolean {
    if (text.isEmpty() || imageUri == null) {
        return false
    }

    return try {
        val storageRef = FirebaseStorage.getInstance().reference.child("images/${imageUri.lastPathSegment}")
        val databaseRef = FirebaseDatabase.getInstance().getReference("posts")

        val uploadTask = storageRef.putFile(imageUri).await()
        val downloadUri = uploadTask.storage.downloadUrl.await()
        val postId = databaseRef.push().key ?: return false
        val post = mapOf(
            "text" to text,
            "imageUrl" to downloadUri.toString(),
            "timestamp" to System.currentTimeMillis()
        )
        databaseRef.child(postId).setValue(post).await()
        true
    } catch (e: Exception) {
        false
    }
}
