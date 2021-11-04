package happybit.parser;

import happybit.command.Command;
import happybit.command.DoneHabitCommand;
import happybit.exception.HaBitParserException;

public class DoneParser extends Parser {

    /**
     * Parses user input to mark a habit associated with a goal as completed.
     *
     * @param input User input containing command parameters.
     * @return Command to mark a specified habit as completed.
     * @throws HaBitParserException If command parameters are not defined, or defined improperly.
     */
    public static Command parseDoneHabitCommand(String input) throws HaBitParserException {
        checkNoDescription(input);
        String[] parameters = splitInput(input);
        int goalIndex = getNumber(parameters, FLAG_GOAL_INDEX) - 1;
        int habitIndex = getNumber(parameters, FLAG_HABIT_INDEX) - 1;
        return new DoneHabitCommand(goalIndex, habitIndex);
    }

}
