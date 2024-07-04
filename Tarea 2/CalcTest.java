import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {
    @Test
    public void testMultiplicacion() {

    }

    @Test
    public void testResta() {

    }

    @Test
    public void testSuma() {
        Calc calc = new Calc();
        assertEquals(5, calc.suma(2, 3));
        assertEquals(0, calc.suma(-1, 1));
        assertEquals(-3, calc.suma(-1, -2));
    }
}
