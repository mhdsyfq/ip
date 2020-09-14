package duke;

import java.util.ArrayList;
import java.util.List;

import duke.task.Task;

/**
 * Represents the part of Duke that stores the list of tasks.
 * Tasks can be added into, marked as done, or deleted from the list.
 */
public class TaskList {
    private final List<Task> tasks;

    /**
     * Creates an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates a task list containing tasks from a specified list.
     *
     * @param tasks the list whose tasks are to be placed into this list.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    /**
     * Adds a task into the task list.
     *
     * @param task the task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the task list.
     *
     * @param taskNum the number of the task to be deleted.
     * @return the deleted task.
     */
    public Task deleteTask(int taskNum) {
        assert (taskNum > 0 && taskNum <= tasks.size()) : "taskNum should be more than 0, and less than or "
                + "equal to size of list";
        int index = taskNum - 1;
        return tasks.remove(index);
    }

    /**
     * Retrieves the task list.
     *
     * @return the list of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Retrieves the number of tasks in the task list.
     *
     * @return the number of tasks in the task list.
     */
    public int getNumOfTasks() {
        return tasks.size();
    }

    /**
     * Retrieves a task from the task list.
     *
     * @param taskNum the number of the task to be retrieved.
     * @return the retrieved task.
     */
    public Task getTask(int taskNum) {
        assert (taskNum > 0 && taskNum <= tasks.size()) : "taskNum should be more than 0, and less than or "
                + "equal to size of list";
        int index = taskNum - 1;
        return tasks.get(index);
    }

    /**
     * Marks a task as done.
     *
     * @param taskNum the number of the task to be marked as done.
     */
    public void markAsDone(int taskNum) {
        assert (taskNum > 0 && taskNum <= tasks.size()) : "taskNum should be more than 0, and less than or "
                + "equal to size of list";
        int index = taskNum - 1;
        tasks.get(index).markAsDone();
    }

    /**
     * Retrieves a list of tasks in the task list which contain a specified keyword.
     *
     * @param keyword the keyword used to find the matching tasks.
     * @return the list of matching tasks.
     */
    public TaskList getMatchingTasks(String keyword) {
        TaskList matchingTasks = new TaskList();
        for (Task task : tasks) {
            if (task.toString().contains(keyword)) {
                matchingTasks.addTask(task);
            }
        }
        return matchingTasks;
    }

    /**
     * Returns a string representation of the task list.
     *
     * @return a string representation of the task list.
     */
    @Override
    public String toString() {
        StringBuilder allTasks = new StringBuilder();
        for (int i = 1; i <= tasks.size(); i++) {
            int index = i - 1;
            allTasks.append("\n").append(i).append(".").append(tasks.get(index));
        }
        return allTasks.toString();
    }
}
