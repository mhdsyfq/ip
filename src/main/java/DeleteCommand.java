public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int taskNum) {
        index = taskNum - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            Task task = tasks.deleteTask(index);
            ui.showDeleted(task, tasks);
            storage.save(tasks.getTasks());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Uh-oh! Looks like you have entered an invalid task number.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}