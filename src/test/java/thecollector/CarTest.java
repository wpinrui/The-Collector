package thecollector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void toStringTest() {
        assertEquals(new Car("Faroli", "459 Francais", 250000_00).toString(),
                "Faroli 459 Francais (Est. value: $250,000.00)");
    }
}
