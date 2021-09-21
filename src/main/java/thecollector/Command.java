package thecollector;

import java.io.IOException;

public class Command {
    public Command(String instruction, Game game) throws IOException {
        switch (instruction) {
        case "cash":
            Logic.handleCash(game);
        case "shop":
            Logic.handleShop(game);
        case "view":
            throw new IllegalArgumentException(Ui.ARGS_VIEW);
        case "buy":
            throw new IllegalArgumentException(Ui.ARGS_BUY);
        case "garage":
            Logic.handleGarage(game);
        case "sell":
            throw new IllegalArgumentException(Ui.ARGS_SELL);
        case "advance":
            Logic.handleAdvance(game);
        case "quit":
            Storage.writeSave(game);
            System.exit(0);
        }
    }
    public Command(String instruction, int parameter, Game game) throws IOException {
        switch (instruction) {
        case "cash":
            Logic.handleCash(game);
        case "shop":
            Logic.handleShop(game);
        case "view":
            Logic.handleView(parameter, game);
        case "buy":
            Logic.handleBuy(parameter, game);
        case "garage":
            Logic.handleGarage(game);
        case "sell":
            Logic.handleSell(parameter, game);
        case "advance":
            Logic.handleAdvance(game);
        case "quit":
            Storage.writeSave(game);
            System.exit(0);
        }
    }
}
