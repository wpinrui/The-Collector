package thecollector;

import static thecollector.Ui.display;

public class Logic {
    public static void handleCash(Game game) {
        int money = game.getPlayer().getMoney();
        display(formatCashMessage(money));
    }
}
