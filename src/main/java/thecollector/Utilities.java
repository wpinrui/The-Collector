package thecollector;

/**
 * This is a collection of utilities used throughout the program.
 *
 * @author Ivan Wong
 */
public class Utilities {
    /**
     * Takes an integer number of cents and converts it to a readable currency string.
     * Example: -1000000 cents becomes "-$10,000.00".
     *
     * @param cents Integer number of cents
     * @return Formatted currency string
     */
    public static String formatMoney(int cents) {
        int positiveCents = Math.abs(cents);
        String decimals = positiveCents % 100 >= 10
                ? String.format("%d", positiveCents % 100)
                : String.format("0%d", positiveCents % 100);
        String dollars = addCommas(String.format("%d", positiveCents / 100));
        return cents > 0
                ? String.format("$%s.%s", dollars, decimals)
                : String.format("-$%s.%s", dollars, decimals);
    }

    /**
     * Takes a string containing an integer and inserts commas for each block of 3 digits,
     * starting from the back.
     * Example: "12345" becomes "12,345"
     *
     * @param dollars String containing integer
     * @return String with commas
     */
    public static String addCommas(String dollars) {
        int inputIndex = dollars.length() - 1;
        int digitCount = 0;
        StringBuilder output = new StringBuilder();
        while (inputIndex >= 0) {
            output.insert(0, dollars.charAt(inputIndex));
            digitCount++;
            inputIndex--;
            if (digitCount % 3 == 0 && inputIndex >= 0) {
                output.insert(0, ",");
            }
        }
        return output.toString();
    }
}
