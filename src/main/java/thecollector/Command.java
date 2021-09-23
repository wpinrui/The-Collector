package thecollector;

import java.io.IOException;

public class Command {
    public Command(String instruction, Game game) throws IOException {
        switch (instruction) {
        case "cash":
            Logic.handleCash(game);
            break;
        case "shop":
            Logic.handleShop(game);
            break;
        case "view":
            throw new IllegalArgumentException(Ui.ARGS_VIEW);
        case "buy":
            throw new IllegalArgumentException(Ui.ARGS_BUY);
        case "garage":
            Logic.handleGarage(game);
            break;
        case "sell":
            throw new IllegalArgumentException(Ui.ARGS_SELL);
        case "advance":
            Logic.handleAdvance(game);
            break;
        case "quit":
            Storage.writeSave(game);
            System.exit(0);
            break;
        default:
            throw new IllegalArgumentException(Ui.ARGS_UNRECOGNISED);
        }
    }
    public Command(String instruction, int parameter, Game game) throws IOException {
        switch (instruction) {
        case "cash":
            Logic.handleCash(game);
            break;
        case "shop":
            Logic.handleShop(game);
            break;
        case "view":
            Logic.handleView(parameter, game);
            break;
        case "buy":
            Logic.handleBuy(parameter, game);
            break;
        case "garage":
            Logic.handleGarage(game);
            break;
        case "sell":
            Logic.handleSell(parameter, game);
            break;
        case "advance":
            Logic.handleAdvance(game);
            break;
        case "quit":
            Storage.writeSave(game);
            System.exit(0);
            break;
        default:
            throw new IllegalArgumentException(Ui.ARGS_UNRECOGNISED);
        }
    }
}
