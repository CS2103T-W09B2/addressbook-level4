package seedu.address.model.task;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Represents a task object in the address book.
 */
public class Task implements ReadOnlyTask {

    private ObjectProperty<TaskName> taskName;
    private ObjectProperty<Description> description;
    private ObjectProperty<Deadline> deadline;
    private ObjectProperty<Priority> priority;

    public Task(TaskName taskName, Description description, Deadline deadline, Priority priority) {
        this.taskName = new SimpleObjectProperty<>(taskName);
        this.description = new SimpleObjectProperty<>(description);
        this.deadline = new SimpleObjectProperty<>(deadline);
        this.priority = new SimpleObjectProperty<>(priority);
    }

    public Task(ReadOnlyTask task) {
        this(task.getTaskName(), task.getDescription(), task.getDeadline(), task.getPriority());
    }

    public TaskName getTaskName() {
        return taskName.get();
    }

    @Override
    public Description getDescription() {
        return description.get();
    }

    @Override
    public Deadline getDeadline() {
        return deadline.get();
    }

    @Override
    public Priority getPriority() {
        return priority.get();
    }

    @Override
    public String toString() {
        return getAsText();
    }

    // Setters for TaskBuilder testing

    public void setTaskName(TaskName taskName) {
        this.taskName.set(taskName);
    }

    public void setDeadline(Deadline deadline) {
        this.deadline.set(deadline);
    }

    public void setDescription(Description description) {
        this.description.set(description);
    }

    public void setPriority(Priority priority) {
        this.priority.set(priority);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ReadOnlyTask // instanceof handles nulls
            && this.isSameStateAs((ReadOnlyTask) other));
    }
}