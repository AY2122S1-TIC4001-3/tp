package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import seedu.duke.project.GTDThought;
import seedu.duke.project.Stat;
import seedu.duke.storage.GTDList;

class NextTest {
   private GTDThought p1 = new GTDThought("This is my very first task");
   private GTDThought p2 = new GTDThought("Second level 0 task");

   private GTDThought sub1 = new GTDThought("sub task a");
   private GTDThought sub2 = new GTDThought("sub task b");
   private GTDThought subsub1 = new GTDThought("sub sub task a.1");

   private GTDList proj = new GTDList();

   public NextTest() {
       p1.addSub(sub1);
       p1.addSub(sub2);
       sub1.addSub(subsub1);

       subsub1.setStatus(Stat.NEXT);

       proj.add(p1);
       proj.add(p2);
   }

   @Test
   public void testgetTextRec() {
       String actual = p1.getTextRec();

       String expected = "[PROJ] This is my very first task\n"
                       + "  [PROJ] sub task a\n"
                       + "    [NEXT] sub sub task a.1\n"
                       + "  [TODO] sub task b\n";

       assertEquals(expected, actual);
   }

   @Test
   public void testgetWithString() {
       String actual1 = proj.get("2").toString();
       String expected1 = "Second level 0 task";

       String actual2 = proj.get("1-2").toString();
       String expected2 = "[TODO] sub task b";

       String actual3 = proj.get("1-1-1").toString();
       String expected3 = "[NEXT] sub sub task a.1";

       assertEquals(expected1, actual1);
       assertEquals(expected2, actual2);
       assertEquals(expected3, actual3);

   }

}