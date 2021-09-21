package thecollector;

public class Logic {
    public static void handleCash(Game game) {
        int money = game.getPlayer().getMoney();
        Ui.display(Ui.formatCashMessage(money));
    }
    public static void handleShop(Game game) {
        game.getPlayer().setLocation(game.getDealers()[0]);
    }
}
