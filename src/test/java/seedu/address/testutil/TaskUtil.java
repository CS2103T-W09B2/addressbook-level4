package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIORITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.task.ReadOnlyTask;

/**
 * Utility class for Tasks
 */
public class TaskUtil {

    /**
     * Returns an add command string for adding the {@code task}.
     */
    public static String getAddCommand(ReadOnlyTask task) {
        return AddCommand.COMMAND_WORD + " " + PREFIX_TASK + " " + getTaskDetails(task);
    }

    /**
     * Returns the part of command string for the given {@code task}'s details.
     */
    public static String getTaskDetails(ReadOnlyTask task) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + task.getTaskName().taskName + " ");
        sb.append(PREFIX_DESCRIPTION + task.getDescription().value + " ");
        sb.append(PREFIX_DEADLINE + task.getDeadline().value + " ");
        sb.append(PREFIX_PRIORITY + task.getPriority().value + " ");
        return sb.toString();
    }
}