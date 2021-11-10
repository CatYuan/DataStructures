import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BasicTest {
    @Test
    public void basicTest() {
        Main m = new Main();
        assertEquals(m.a, 0);
    }
}
