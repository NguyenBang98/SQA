package Model;

import Model.Group;
import Model.Room;
import Model.Subject;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class GroupTest {

    @Test
    public void EqualsFuntionTest0() {
        Room r = new Room(1, "101A2");
        Subject s = new Subject("1", "SQA", 3);
        Group g = new Group(1, r, s, "Monday", "1", "1", "2");
        assertTrue(g.equals(g));
    }

    @Test
    public void EqualsFuntionTest1() {
        Room r1 = new Room(1, "101A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Group g2 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        assertTrue(g1.equals(g2));
    }

    @Test
    public void EqualsFuntionTest2() {
        Room r1 = new Room(1, "101A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Room r2 = new Room(2, "102A2");
        Group g2 = new Group(1, r2, s1, "Tuesday", "1", "1", "2");
        assertTrue(g1.equals(g2));
    }

    @Test
    public void EqualsFuntionTest3() {
        Room r1 = new Room(1, "101A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Room r2 = new Room(2, "102A2");
        Group g2 = new Group(2, r2, s1, "Tuesday", "1", "1", "2");
        assertFalse(g1.equals(g2));
    }

    @Test
    public void EqualsFuntionTest4() {
        Room r1 = new Room(1, "101A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Subject s2 = new Subject("2", "PTTK", 3);
        Room r2 = new Room(2, "102A2");
        Group g2 = new Group(1, r2, s2, "Tuesday", "1", "1", "2");
        assertFalse(g1.equals(g2));
    }

    @Test
    public void EqualsFuntionTest5() {
        Room r1 = new Room(1, "101A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Subject s2 = new Subject("2", "PTTK", 3);
        Group g2 = new Group(2, r1, s2, "Monday", "1", "1", "2");
        assertTrue(g1.equals(g2));
    }

    @Test
    public void EqualsFuntionTest6() {
        Room r1 = new Room(1, "101A2");
        Room r2 = new Room(2, "102A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("2", "PTTK", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Group g2 = new Group(2, r2, s2, "Monday", "1", "1", "2");
        assertFalse(g1.equals(g2));
    }

    @Test
    public void EqualsFuntionTest7() {
        Room r1 = new Room(1, "101A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("2", "PTTK", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Group g2 = new Group(2, r1, s2, "Tuesday", "1", "1", "2");
        assertFalse(g1.equals(g2));
    }

    @Test
    public void EqualsFuntionTest8() {
        Room r1 = new Room(1, "101A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("2", "PTTK", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Group g2 = new Group(2, r1, s2, "Monday", "2", "1", "2");
        assertFalse(g1.equals(g2));
    }

    @Test
    public void EqualsFuntionTest9() {
        Room r1 = new Room(1, "101A2");
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("2", "PTTK", 3);
        Group g1 = new Group(1, r1, s1, "Monday", "1", "1", "2");
        Group g2 = new Group(2, r1, s2, "Monday", "1", "2", "2");
        assertFalse(g1.equals(g2));
    }
}
