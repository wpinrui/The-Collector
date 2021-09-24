package thecollector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

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
        ArrayList<Car> t = new ArrayList<>();
        t.add(new Car("Nissom", "Moony", 20000_00));
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
                "=================================================="
                        + "\nCars: "
                        + "\nNissom Moony (Est. value: $20,000.00)"
                        + "\nNissom Moony (Est. value: $20,000.00)"
                        + "\nNissom Moony (Est. value: $20,000.00)\n");
    }
}
