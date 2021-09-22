package thecollector;

public class Logic {
    public static void handleCash(Game game) {
        int money = game.getPlayer().getMoney();
        Ui.display(Ui.formatCashMessage(money));
    }
    public static void handleShop(Game game) {
        if (game.getPlayer().getLocation() instanceof Dealer) {
            Ui.display(Ui.alreadyInShopMessage);
        }
        game.getPlayer().setLocation(game.getDealer());
        Ui.display(Ui.movedToShopMessage);
    }
    public static void handleGarage(Game game) {
        if (game.getPlayer().getLocation() instanceof Garage) {
            Ui.display(Ui.alreadyInGarageMessage);
        }
        game.getPlayer().setLocation(game.getGarage());
        Ui.display(Ui.movedToGarageMessage);
    }

    public static void handleAdvance(Game game) {
        game.advanceTime();
        Ui.display(Ui.formatMonthMessage(game.getMonth()));
    }

    public static void handleView(int index, Game game) {
        Car car = game.getPlayer().getLocation().getCars().get(index);
        Ui.display(car.toString());
    }

    public static void handleBuy(int index, Game game) {
        if (game.getPlayer().getLocation() instanceof Garage) {
            Ui.display(Ui.mustBeInDealerMessage);
        }
        Dealer dealer = game.getDealer();
        Car car = dealer.removeFromListings(index);
        if (game.getPlayer().getMoney() < car.getValue()) {
            Ui.display(Ui.insufficientFundsMessage);
            dealer.addToListings(car);
        }
        game.getGarage().addCar(car);
        game.getPlayer().addMoney(car.getValue() * -1);
        Ui.display(Ui.formatCarBoughtMessage(car));
    }

    public static void handleSell(int index, Game game) {
        if (game.getPlayer().getLocation() instanceof Dealer) {
            Ui.display(Ui.mustBeInGarageMessage);
        }
        Car car = game.getGarage().getCars().get(index);
    }
}
