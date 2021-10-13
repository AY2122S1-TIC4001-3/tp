package seedu.duke;

import seedu.duke.storage.GTDList;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.parser.Parser;
import seedu.duke.project.GTDThought;
import seedu.duke.project.Stat;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class Next {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo =
                          " _   _           _   \n"
                        + "| \\ | | _____  _| |_ \n"
                        + "|  \\| |/ _ \\ \\/ / __|\n"
                        + "| |\\  |  __/>  <| |_ \n"
                        + "|_| \\_|\\___/_/\\_\\\\__|\n";

        System.out.println("PROJECT\n" + logo);

        GTDList inbox = new GTDList();
        GTDList proj = new GTDList();
        GTDList next = new GTDList();
        GTDList wait = new GTDList();
        GTDList some = new GTDList();



        Ui ui = new Ui();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().parse(fullCommand);
                c.execute();
                isExit = ExitCommand.isExit(c);
            } catch (Exception e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
      
      
      
      
        String title = "This is my very first task";
        GTDThought p1 = new GTDThought(title);
        GTDThought p2 = new GTDThought("Second level 0 task");

        p1.print();

        GTDThought sub1 = new GTDThought("sub task a");
        GTDThought sub2 = new GTDThought("sub task b");
        GTDThought subsub1 = new GTDThought("sub sub task a.1");

        p1.addSub(sub1);
        p1.addSub(sub2);
        sub1.addSub(subsub1);

        subsub1.setStatus(Stat.NEXT);

        p1.printRec();

        next.add(p1);
        next.add(p2);
        inbox.add(p1);
        p1.setStatus(Stat.NEXT);
        next.get(0).print();
        inbox.get(0).print();

        System.out.println(System.lineSeparator());

        next.print();

        next.get("1-1-1").print();


    }
}