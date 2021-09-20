package thecollector;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    public void getCarListingsTest_notNull() {
        assertNotEquals(
                new Dealer("Dealer", 1).getCarListings(),
                null
        );
    }
}
