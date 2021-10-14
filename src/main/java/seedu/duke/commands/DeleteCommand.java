package seedu.duke.commands;


import java.util.Arrays;
import seedu.duke.storage.GTDList;

/**
 * delete a task from the taskList based on the index.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    private int[] targetIndex;

    public DeleteCommand(int[] targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public void execute() {
        GTDList gtdList = GTDLists.get("inbox");
        for (int i : targetIndex) {
            String gtdThoughtName = gtdList.get(i).getTextRec();
            gtdList.remove(i);
            System.out.println("This is a delete command, the deleted task is:" + System.lineSeparator() + gtdThoughtName);
        }
    }
}
