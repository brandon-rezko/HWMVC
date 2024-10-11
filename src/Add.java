import static org.junit.Assert.assertEquals;
import org.junit.*;

public class Add {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void testPositiveAddition() {
        model.add(5, 5);
        assertEquals("Expected 5 + 5 = 10", 10, model.returnresult(), 0);
    }

    @Test
    public void testNegativeAddition() {
        model.add(-3, -7);
        assertEquals("Expected -3 + -7 = -10", -10, model.returnresult(), 0);
    }

    @Test
    public void testZeroAddition() {
        model.add(0, 0);
        assertEquals("Expected 0 + 0 = 0", 0, model.returnresult(), 0);
    }

    @Test
    public void testPositiveAndZeroAddition() {
        model.add(15, 0);
        assertEquals("Expected 15 + 0 = 15", 15, model.returnresult(), 0);
    }

    @Test
    public void testLargeAddition() {
        model.add(Long.MAX_VALUE, 1);
        // Expected behavior depends on implementation — assuming overflow is handled manually
        assertEquals("Expected overflow handling for Long.MAX_VALUE + 1", Long.MAX_VALUE + 1.0, model.returnresult(), 0);
    }
}
