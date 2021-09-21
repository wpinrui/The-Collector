package thecollector;

import java.io.IOException;

/**
 * Converts an input string into its constituents.
 */
public class Parser {
    private final String instruction;
    private Integer parameter;
    private Game game;

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

    public Command parseInput() throws IOException {
        if (parameter == null) {
            return new Command(instruction, game);
        }
        return new Command(instruction, parameter);
    }

    public String getInstruction() {
        return instruction;
    }

    public int getParameter() {
        return parameter;
    }
}
