package Model;

import Model.Room;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class RoomTest {

    @Test
    public void EqualFuntionTest0() {
        Room r = new Room(1, "101");
        assertTrue(r.equals(r));
    }

    @Test
    public void EqualFuntionTest1() {
        Room r1 = new Room(1, "101");
        Room r2 = new Room(1, "101");
        assertTrue(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest2() {
        Room r1 = new Room(1, "101");
        Room r2 = new Room(2, "101");
        assertFalse(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest3() {
        Room r1 = new Room(1, "101");
        Room r2 = new Room(1, "102");
        assertFalse(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest4() {
        Room r1 = new Room(1, "101");
        Room r2 = new Room();
        assertFalse(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest5() {
        Room r1 = new Room(1, "101");
        Room r2 = new Room(2, "102");
        assertFalse(r1.equals(r2));
    }

    @Test
    public void EqualFuntionTest6() {
        Room r1 = new Room();
        Object s = new Object();
        assertFalse(r1.equals(s));
    }
//    @Test
//    public void EqualFuntionTest7(){
//        Room r1= new Room();
//        Room r2= new Room();
//        assertEquals(true, r1.equals(r2));
//    }
}
