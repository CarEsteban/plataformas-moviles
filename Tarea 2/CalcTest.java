import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {
    @Test
    public void testMultiplicacion() {
        Calc calc = new Calc();
        assertEquals(6, calc.multiplicacion(2, 3));
        assertEquals(0, calc.multiplicacion(0, 3));
        assertEquals(-6, calc.multiplicacion(2, -3));

    }

    @Test
    public void testResta() {
        Calc calc = new Calc();
        assertEquals(1, calc.resta(3, 2));
        assertEquals(0, calc.resta(1, 1));
        assertEquals(-1, calc.resta(1, 2));
        
    }

    @Test
    public void testSuma() {
        Calc calc = new Calc();
        assertEquals(5, calc.suma(2, 3));
        assertEquals(0, calc.suma(-1, 1));
        assertEquals(-3, calc.suma(-1, -2));
    }
}
