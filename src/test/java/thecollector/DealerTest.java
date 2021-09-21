package thecollector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;
import java.util.function.Supplier;

public class DealerTest {
    @Test
    public void getCarListingsTest_notNull() {
        assertNotEquals(
                new Dealer("Dealer", 1).getCarListings(),
                null
        );
    }

    @Test
    public void removeFromListingsTest() {
        Dealer d = new Dealer("Dealer", 2);
        d.removeFromListings(1);
        TreeMap<Integer, Car> t = new TreeMap<Integer, Car>();
        t.put(0, new Car("Nissom", "Moony", 20000_00));
        assertEquals(d.getCarListings(), t);
    }

    @Test
    public void getNameTest() {
        Dealer d = new Dealer("NiceName!", 2);
        assertEquals(d.getName(), "NiceName!");
    }

    @Test
    public void toStringTest() {
        Dealer d = new Dealer("Dealer ABC", 3);
        assertEquals(d.toString(),
                "Dealer ABC's listings:" +
                        "\nNissom Moony (Est. value: $20,000.00)" +
                        "\nNissom Moony (Est. value: $20,000.00)" +
                        "\nNissom Moony (Est. value: $20,000.00)\n");
    }
}
