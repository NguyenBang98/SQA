package Model;

import Model.GroupLab;
import Model.RoomLab;
import Model.Subject;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class GroupLabTest {

    @Test
    public void EqualsFuntionTest0() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        assertTrue(gr.equals(gr));
    }

    @Test
    public void EqualsFuntionTest1() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        GroupLab gr2 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        assertTrue(gr1.equals(gr2));
    }

    @Test
    public void EqualsFuntionTest2() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        RoomLab r2 = new RoomLab(1, "101");
        Subject s2 = new Subject("1", "SQA", 3);
        GroupLab gr2 = new GroupLab(1, 0, r2, s2, "1", "1", "1");
        assertFalse(gr1.equals(gr2));
    }

    @Test
    public void EqualsFuntionTest3() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        RoomLab r2 = new RoomLab(1, "101");
        Subject s2 = new Subject("1", "SQA", 3);
        GroupLab gr2 = new GroupLab(0, 1, r2, s2, "1", "1", "1");
        assertFalse(gr1.equals(gr2));
    }

    @Test
    public void EqualsFuntionTest4() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        RoomLab r2 = new RoomLab(2, "101");
        Subject s2 = new Subject("1", "SQA", 3);
        GroupLab gr2 = new GroupLab(0, 0, r2, s2, "1", "1", "1");
        assertFalse(gr1.equals(gr2));
    }

    @Test
    public void EqualsFuntionTest5() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        RoomLab r2 = new RoomLab(1, "101");
        Subject s2 = new Subject("2", "SQA", 3);
        GroupLab gr2 = new GroupLab(0, 0, r2, s2, "1", "1", "1");
        assertFalse(gr1.equals(gr2));
    }

    @Test
    public void EqualsFuntionTest6() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        RoomLab r2 = new RoomLab(1, "101");
        Subject s2 = new Subject("1", "SQA", 3);
        GroupLab gr2 = new GroupLab(0, 0, r2, s2, "2", "1", "1");
        assertFalse(gr1.equals(gr2));
    }

    @Test
    public void EqualsFuntionTest7() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        RoomLab r2 = new RoomLab(1, "101");
        Subject s2 = new Subject("1", "SQA", 3);
        GroupLab gr2 = new GroupLab(0, 0, r2, s2, "1", "2", "1");
        assertFalse(gr1.equals(gr2));
    }

    @Test
    public void EqualsFuntionTest8() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        RoomLab r2 = new RoomLab(1, "101");
        Subject s2 = new Subject("1", "SQA", 3);
        GroupLab gr2 = new GroupLab(0, 0, r2, s2, "1", "1", "2");
        assertFalse(gr1.equals(gr2));
    }

    @Test
    public void EqualsFuntionTest9() {
        RoomLab r1 = new RoomLab(1, "101");
        Subject s1 = new Subject("1", "SQA", 3);
        GroupLab gr1 = new GroupLab(0, 0, r1, s1, "1", "1", "1");
        Object s = new Object();
        assertFalse(gr1.equals(s));
    }
}
