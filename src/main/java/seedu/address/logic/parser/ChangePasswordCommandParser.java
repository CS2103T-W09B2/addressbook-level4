package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONFIRM_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NEW_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.ChangePasswordCommand;
import seedu.address.logic.parser.exceptions.ParseException;

//@@author charlesgoh
/**
 * Parses input arguments and creates a new ChangePassword object
 */
public class ChangePasswordCommandParser implements Parser<ChangePasswordCommand> {

    public static final int OLD_PASSWORD_POSITION = 0;
    public static final int NEW_PASSWORD_POSITION = 1;
    public static final int CONFIRM_PASSWORD_POSITION = 2;
    public static final int SIZE_OF_ARG_ARRAY = 4;

    private final Logger logger = LogsCenter.getLogger(this.getClass());

    /**
     * Parses the given {@code String} of arguments in the context of the ChangePasswordCommand
     * and returns a ChangePasswordCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ChangePasswordCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer
                .tokenize(args, PREFIX_PASSWORD, PREFIX_NEW_PASSWORD, PREFIX_CONFIRM_PASSWORD);

        // Check and split arguments before passing them to ChangePasswordCommand
        if (!argMultimap.getValue(PREFIX_PASSWORD).isPresent()
                || !argMultimap.getValue(PREFIX_NEW_PASSWORD).isPresent()
                || !argMultimap.getValue(PREFIX_CONFIRM_PASSWORD).isPresent()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ChangePasswordCommand.MESSAGE_USAGE));
        } else {
            String password = argMultimap.getValue(PREFIX_PASSWORD).get();
            String newPassword = argMultimap.getValue(PREFIX_NEW_PASSWORD).get();
            String confirmPassword = argMultimap.getValue(PREFIX_CONFIRM_PASSWORD).get();
            return new ChangePasswordCommand(password, newPassword, confirmPassword);
        }
    }
}