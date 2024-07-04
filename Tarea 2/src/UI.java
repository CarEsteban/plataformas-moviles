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

    // Método Main
    public static void main(String[] args) {
        UI ui = new UI();
        System.out.println("Suma: " + ui.suma(5, 3));
        System.out.println("Resta: " + ui.resta(5, 3));
        System.out.println("Multiplicacion: " + ui.multiplicacion(5, 3));
    }

}
