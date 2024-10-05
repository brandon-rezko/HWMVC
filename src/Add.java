import static org.junit.Assert.assertEquals;
import org.junit.*;

public class Add {

    @Test
    public void testPositiveAddition() {
        Model model = new Model();
        model.add(5, 5);
        double result = model.returnresult();
        assertEquals("Expected 5 + 5 to equal 10", 10, result, 0);
    }

    @Test
    public void testNegativeAddition() {
        Model model = new Model();
        model.add(-3, -7);
        double result = model.returnresult();
        assertEquals("Expected -3 + -7 to equal -10", -10, result, 0);
    }
}
