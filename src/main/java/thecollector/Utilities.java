package thecollector;

/**
 * This is a collection of utilities used throughout the program.
 *
 * @author Ivan Wong
 */
public class Utilities {
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

    public static String addCommas(String dollars) {
        int inputIndex = dollars.length() - 1;
        int digit_count = 0;
        StringBuilder output = new StringBuilder();
        while (inputIndex >= 0) {
            output.insert(0, dollars.charAt(inputIndex));
            digit_count++;
            inputIndex--;
            if (digit_count % 3 == 0 && inputIndex >= 0) {
                output.insert(0, ",");
            }
        }
        return output.toString();
    }
}
