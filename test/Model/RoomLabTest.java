package Model;

import Model.RoomLab;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class RoomLabTest {

    @Test
    public void EqualFuntionTest0() {
        RoomLab r = new RoomLab(1, "101");
        assertTrue(r.equals(r));
    }

    @Test
    public void EqualFuntionTest1() {
        RoomLab r1 = new RoomLab(1, "101");
        RoomLab r2 = new RoomLab(1, "101");
        assertTrue(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest2() {
        RoomLab r1 = new RoomLab(1, "101");
        RoomLab r2 = new RoomLab(2, "101");
        assertFalse(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest3() {
        RoomLab r1 = new RoomLab(1, "101");
        RoomLab r2 = new RoomLab(1, "102");
        assertFalse(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest4() {
        RoomLab r1 = new RoomLab(1, "101");
        RoomLab r2 = new RoomLab();
        assertFalse(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest5() {
        RoomLab r1 = new RoomLab(1, "101");
        RoomLab r2 = new RoomLab(2, "102");
        assertFalse(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest6() {
        RoomLab r1 = new RoomLab();
        Object s = new Object();
        assertFalse(r1.equals(s));
    }
}
