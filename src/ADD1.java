import static org.junit.Assert.*;

import org.junit.Test;

public class ADD1 {

    @Test
    public void testAddTwoPositiveNumbers() {
        Model d = new Model();
        d.add(5, 5);
        double result = d.returnresult();
        assertEquals("Expected 5 + 5 = 10", 10, result, 0);
    }

    @Test
    public void testAddPositiveAndNegative() {
        Model d = new Model();
        d.add(10, -3);
        double result = d.returnresult();
        assertEquals("Expected 10 + (-3) = 7", 7, result, 0);
    }
}
