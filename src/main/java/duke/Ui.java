package duke;

import java.util.Scanner;

import duke.task.Task;

/**
 * Represents the part of Duke that deals with user interaction.
 */
public class Ui {
    /** A line divider */
    private static final String DIVIDER =
            "______________________________________________________________________";
    /** The scanner used for user interaction */
    private final Scanner sc;

    /**
     * Creates a new Ui for user interaction.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Reads user input.
     *
     * @return the user input.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Generates Duke's response with dividers (to improve readability).
     *
     * @param output Duke's response.
     * @return the specified output with dividers.
     */
    public String generateDividers(String output) {
        return DIVIDER + "\n" + output + "\n" + DIVIDER;
    }

    /**
     * Generates a welcome message.
     *
     * @return the welcome message.
     */
    public String generateWelcomeMessage() {
        return "Hello! I'm Duke\n" + "What can I do for you?";
    }

    /**
     * Generates a farewell message.
     *
     * @return the farewell message.
     */
    public String generateExitMessage() {
        return "Bye. I hope to see you again soon!";
    }

    /**
     * Generates a message with all the tasks in the list.
     *
     * @param tasks the task list.
     * @return the generated message.
     */
    public String generateAllTasks(TaskList tasks) {
        if (tasks.getNumOfTasks() == 0) {
            return "You currently have no tasks in your list.";
        } else {
            return "Here are the tasks in your list:\n" + tasks;
        }
    }

    /**
     * Generates a message with a list of tasks
     * from the task list that contain a common keyword.
     *
     * @param keyword the specified keyword.
     * @param tasks the task list.
     * @return the generated message.
     */
    public String generateFindMessage(String keyword, TaskList tasks) {
        return "Here are the matching tasks in your list:\n"
                + tasks.getMatchingTasks(keyword);
    }

    /**
     * Generates a message that a task has been successfully added into the task list.
     * The new total number of tasks will be recalculated and included in the message.
     *
     * @param task the task that has been added into the task list.
     * @param tasks the task list.
     * @return the generated message.
     */
    public String generateAddedMessage(Task task, TaskList tasks) {
        return "Task added successfully!\n\t"
                + task + generateNumOfTasksMessage(tasks);
    }

    /**
     * Generates a message that a task has been successfully marked as done.
     *
     * @param task the task that has been marked as done.
     * @return the generated message.
     */
    public String generateDoneMessage(Task task) {
        return "Task completed successfully!\n\t" + task;
    }

    /**
     * Generates a message that a task has been successfully deleted from the task list.
     * The new total number of tasks will be recalculated and included in the message.
     *
     * @param task the task that has been deleted from the task list.
     * @param tasks the task list.
     * @return the generated message.
     */
    public String generateDeletedMessage(Task task, TaskList tasks) {
        return "Task deleted successfully!\n\t"
                + task + generateNumOfTasksMessage(tasks);
    }

    /**
     * Generates a message that shows how many tasks are in the task list.
     *
     * @param tasks the task list.
     * @return the generated message.
     */
    public String generateNumOfTasksMessage(TaskList tasks) {
        return String.format("\nNow you have %d task(s) in the list.",
                tasks.getNumOfTasks());
    }

    /**
     * Generates an error message as and when an exception is thrown.
     *
     * @param e the exception thrown.
     * @return the error message.
     */
    public String generateErrorMessage(Exception e) {
        return e.getMessage();
    }
}
