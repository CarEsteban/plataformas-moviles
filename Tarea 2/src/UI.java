public class UI {
    private final Calc calc;

    public UI() {
        this.calc = new Calc();
    }

    public int suma(int n1, int n2) {
        return calc.suma(n1, n2);
    }

    public int resta(int n1, int n2) {
        return calc.resta(n1, n2);
    }

    public int multiplicacion(int n1, int n2) {
        return calc.multiplicacion(n1, n2);
    }

    // Método Main
    public static void main(String[] args) {
        UI ui = new UI();
        ui.displayResults(5, 3);
    }

    private void displayResults(int n1, int n2) {
        System.out.println("Suma: " + suma(n1, n2));
        System.out.println("Resta: " + resta(n1, n2));
        System.out.println("Multiplicación: " + multiplicacion(n1, n2));
    }
}
