package thecollector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UtilitiesTest {
    @Test
    public void formatMoneyTest_positive() {
        assertEquals("$12,345.67", Utilities.formatMoney(1234567));
    }
    @Test
    public void formatMoneyTest_negative() {
        assertEquals("-$1,234,567.89", Utilities.formatMoney(-123456789));
    }
    @Test
    public void formatMoneyTest_small() {
        assertEquals("$0.03", Utilities.formatMoney(3));
    }
    @Test
    public void addCommasTest_unaffected() {
        assertEquals("1", Utilities.addCommas("1"));
    }
    @Test
    public void addCommasTest_lengthFour() {
        assertEquals("1,234", Utilities.addCommas("1234"));
    }
    @Test
    public void addCommasTest_lengthFive() {
        assertEquals("12,345", Utilities.addCommas("12345"));
    }
    @Test
    public void addCommasTest_lengthSix() {
        assertEquals("123,456", Utilities.addCommas("123456"));
    }
    @Test
    public void addCommasTest_lengthSeven() {
        assertEquals("1,234,567", Utilities.addCommas("1234567"));
    }
}
