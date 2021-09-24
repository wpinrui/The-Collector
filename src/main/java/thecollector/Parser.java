package thecollector;

import java.io.IOException;

/**
 * Converts an input string into its constituents.
 */
public class Parser {
    private final String instruction;
    private Integer parameter;
    private final Game game;

    /**
     * Constructor for a parser object. It takes in the raw user input and tries to split it up into an instruction
     * and an integer parameter, if any.
     *
     * @param input The unprocessed user input
     * @param game The state of the game
     */
    public Parser(String input, Game game) {
        this.game = game;
        String[] strings = input.split(" ");
        this.instruction = strings[0];
        if (strings.length > 1) {
            try {
                this.parameter = Integer.parseInt(strings[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument format.");
                this.parameter = null;
            }
        }
    }

    /**
     * Calls the Command constructor of the appropriate method signature.
     *
     * @throws IOException If the game cannot be saved
     */
    public void runParsedInstruction() throws IOException {
        if (parameter == null) {
            new Command(instruction, game);
            return;
        }
        new Command(instruction, parameter, game);
    }

    public String getInstruction() {
        return instruction;
    }

    public int getParameter() {
        return parameter;
    }
}
