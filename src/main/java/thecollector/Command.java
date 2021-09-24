package thecollector;

import java.io.IOException;

/**
 * This class handles parsed user input and calls the respective functions from the Logic class in response to
 * this input.
 *
 * @author Ivan Wong
 */
public class Command {
    /**
     * Constructor for a command, which happens to handle the logic of the command itself. This variant handles
     * parsed user input with only an instruction and no other parameter.
     *
     * @param instruction The type of instruction specified by the user
     * @param game The state of the game
     * @throws IOException If the game is unable to write to the save file
     */
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

    /**
     * Constructor for a command, which happens to handle the logic of the command itself. This variant handles
     * parsed user input with an instruction and a parameter.
     *
     * @param instruction The type of instruction specified by the user
     * @param parameter An argument of the instruction which is ignored if the instruction does not require one
     * @param game The state of the game
     * @throws IOException If the game is unable to write to the save file
     */
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
