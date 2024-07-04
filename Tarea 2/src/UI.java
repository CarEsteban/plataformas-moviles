public class UI {
    private Calc calc;
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

    // Método Principal
    public static void main(String[] args) {
        UI ui = new UI();
        ui.displayResults(2, 5);
    }

    private void showResults(int number1, int number2) {
        System.out.println("Addition: " + add(number1, number2));
        System.out.println("Subtraction: " + subtract(number1, number2));
        System.out.println("Multiplication: " + multiply(number1, number2));
    }

}
