package thecollector;

import java.io.IOException;

public class Logic {
    public static void handleCash(Game game) {
        int money = game.getPlayer().getMoney();
        Ui.display(Ui.formatCashMessage(money));
    }

    public static void handleShop(Game game) throws IOException {
        if (game.getPlayer().getLocation() instanceof Dealer) {
            Ui.display(Ui.alreadyInShopMessage);
            return;
        }
        game.getPlayer().setLocation(game.getDealer());
        Ui.display(Ui.movedToShopMessage);
        Storage.writeSave(game);

    }

    public static void handleGarage(Game game) throws IOException {
        if (game.getPlayer().getLocation() instanceof Garage) {
            Ui.display(Ui.alreadyInGarageMessage);
            return;
        }
        game.getPlayer().setLocation(game.getGarage());
        Ui.display(Ui.movedToGarageMessage);
        Storage.writeSave(game);

    }

    public static void handleAdvance(Game game) throws IOException {
        game.advanceTime();
        Ui.display(Ui.formatSummary(game));
        Storage.writeSave(game);
    }

    public static void handleView(int index, Game game) {
        Car car = game.getPlayer().getLocation().getCars().get(index);
        Ui.display(car.toString());

    }

    public static void handleBuy(int index, Game game) throws IOException {
        if (game.getPlayer().getLocation() instanceof Garage) {
            Ui.display(Ui.mustBeInDealerMessage);
            return;
        }
        Dealer dealer = game.getDealer();
        Car car = dealer.removeFromListings(index);
        if (game.getPlayer().getMoney() < car.getValue()) {
            Ui.display(Ui.insufficientFundsMessage);
            dealer.addToListings(car);
            return;
        }
        game.getGarage().addCar(car);
        game.getPlayer().addMoney(car.getValue() * -1);
        Ui.display(Ui.formatCarBoughtMessage(car));
        Storage.writeSave(game);

    }

    public static void handleSell(int index, Game game) throws IOException {
        if (game.getPlayer().getLocation() instanceof Dealer) {
            Ui.display(Ui.mustBeInGarageMessage);
            return;
        }
        Car car = game.getGarage().removeCar(index);
        game.getPlayer().addMoney(car.getValue());
        Ui.display(Ui.formatCarSoldMessage(car));
        Storage.writeSave(game);
    }
}
