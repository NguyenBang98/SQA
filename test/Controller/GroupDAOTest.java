package Controller;

import Model.Group;
import Model.Room;
import Model.Subject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class GroupDAOTest {

    public GroupDAOTest() {
    }

    /**
     * Test of saveGroup method, of class GroupDAO.
     */
    @Test
    public void testSaveGroup1() {
        GroupDAO instance = new GroupDAO();
        Group group = new Group();
        Subject subject = new Subject("INT1461", "Xây dựng các hệ thống nhúng", 3);
        Room room = new Room(2, "201 - A2");
        group.setGroupID(1);
        group.setRoom(room);
        group.setSubject(subject);
        group.setDay("Thứ 5");
        group.setHour1("14:00-16:00");
        group.setHour2("18:00-20:00");
        group.setWeek("123456789101112131415-1234567");
        Connection con = instance.con;
        try {
            con.setAutoCommit(false);
            instance.saveGroup(group);
            assertNotNull(group);
            assertEquals(5, instance.listGroup().length);

            Group test;
            test = instance.searchGroupBySubjectIDAndGroupID(group.getSubject().getSubjectID(), group.getGroupID());
            assertEquals(group.getGroupID(), test.getGroupID());
            assertEquals(group.getSubject(), test.getSubject());
            assertEquals(group.getRoom(), test.getRoom());
            assertEquals(group.getDay(), test.getDay());
            assertEquals(group.getHour1(), test.getHour1());
            assertEquals(group.getHour2(), test.getHour2());
            assertEquals(group.getWeek(), test.getWeek());

        } catch (SQLException ex) {
            Logger.getLogger(GroupDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(GroupDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Test
    public void testSaveGroup2() {
        GroupDAO instance = new GroupDAO();
        Group group = new Group();
        Subject subject = new Subject("INT1416", "Đảm bảo lượng phần mềm", 3);
        Room room = new Room(2, "201 - A2");
        group.setGroupID(1);
        group.setRoom(room);
        group.setSubject(subject);
        group.setDay("Thứ 3");
        group.setHour1("14:00-16:00");
        group.setHour2("18:00-20:00");
        group.setWeek("123456789101112131415-1234567");
        Connection con = instance.con;
        try {
            con.setAutoCommit(false);
            instance.saveGroup(group);
            assertNotNull(group);
            assertEquals(4, instance.listGroup().length);

            Group test;
            test = instance.searchGroupBySubjectIDAndGroupID(group.getSubject().getSubjectID(), group.getGroupID());
            assertEquals(group.getGroupID(), test.getGroupID());
            assertNotEquals(group.getSubject(), test.getSubject());
            assertNotEquals(group.getRoom(), test.getRoom());
            assertNotEquals(group.getDay(), test.getDay());
            assertNotEquals(group.getHour1(), test.getHour1());
            assertNotEquals(group.getHour2(), test.getHour2());
            assertEquals(group.getWeek(), test.getWeek());

        } catch (SQLException ex) {
            Logger.getLogger(GroupDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(GroupDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Test
    public void testSaveGroup3() {
        GroupDAO instance = new GroupDAO();
        Group group = new Group();
        Subject subject = new Subject("INT1461", "Xây dựng các hệ thống nhúng", 3);
        Room room = new Room(3, "202 - A2");
        group.setGroupID(1);
        group.setRoom(room);
        group.setSubject(subject);
        group.setDay("Thứ 2");
        group.setHour1("7:00-9:00");
        group.setHour2("12:00-14:00");
        group.setWeek("123456789101112131415-1234567");
        Connection con = instance.con;
        try {
            con.setAutoCommit(false);
            instance.saveGroup(group);
            assertNotNull(group);
            assertEquals(5, instance.listGroup().length);

            Group test;
            test = instance.searchGroupBySubjectIDAndGroupID(group.getSubject().getSubjectID(), group.getGroupID());
            assertEquals(group.getGroupID(), test.getGroupID());
            assertEquals(group.getSubject(), test.getSubject());
            assertEquals(group.getRoom(), test.getRoom());
            assertEquals(group.getDay(), test.getDay());
            assertEquals(group.getHour1(), test.getHour1());
            assertEquals(group.getHour2(), test.getHour2());
            assertEquals(group.getWeek(), test.getWeek());

        } catch (SQLException ex) {
            Logger.getLogger(GroupDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(GroupDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * Test of listSubject method, of class GroupDAO.
     */
    @Test
    public void testListSubject() {
        GroupDAO instance = new GroupDAO();

        ArrayList<Subject> result = instance.listSubject();
        assertNotNull(result);
        assertEquals(6, result.size());
        assertEquals("INT1416", result.get(1).getSubjectID());
        assertEquals("Đảm bảo chất lượng phần mềm", result.get(1).getName());
        assertEquals(3, result.get(1).getCredits());
        return;
    }

    /**
     * Test of listRoom method, of class GroupDAO.
     */
    @Test
    public void testListRoom() {
        GroupDAO instance = new GroupDAO();

        ArrayList<Room> result = instance.listRoom();
        assertNotNull(result);
        assertEquals(31, result.size());
        assertEquals(2, result.get(1).getRoomID());
        assertEquals("201 - A2", result.get(1).getNameRoom());
        return;
    }

    /**
     * Test of listGroup method, of class GroupDAO.
     */
    @Test
    public void testListGroup() {
        GroupDAO instance = new GroupDAO();
        Group[] result = instance.listGroup();
        assertEquals(4, result.length);
        assertEquals(1, result[0].getGroupID());
        assertEquals("INT1416", result[0].getSubject().getSubjectID());
        assertEquals(3, result[0].getRoom().getRoomID());
        assertEquals("Thứ 2", result[0].getDay());
        assertEquals("7:00-9:00", result[0].getHour1());
        assertEquals("12:00-14:00", result[0].getHour2());
        assertEquals("123456789101112131415-1234567", result[0].getWeek());
        return;
    }

    @Test
    public void testSearchGroupBySubjectID1() {
        //test key 
        String key = "int1416";
        GroupDAO instance = new GroupDAO();
        Group[] result = instance.searchGroupBySubjectID(key);
        assertEquals(2, result.length);
        assertNotNull(result);
        for (int i = 0; i < result.length; i++) {
            assertTrue(result[i].getSubject().getSubjectID().toLowerCase().equals(key));
        }
    }

    @Test
    public void testSearchGroupBySubjectID2() {
        //test key 
        String key = "INT1416";
        GroupDAO instance = new GroupDAO();
        Group[] result = instance.searchGroupBySubjectID(key);
        assertEquals(2, result.length);
        assertNotNull(result);
        for (int i = 0; i < result.length; i++) {
            assertTrue(result[i].getSubject().getSubjectID().equals(key));
        }
    }

    @Test
    public void testSearchGroupBySubjectID3() {
        //test key 
        String key = "chung";
        GroupDAO instance = new GroupDAO();
        Group[] result = instance.searchGroupBySubjectID(key);
        assertNull(result);
    }

    @Test
    public void testSearchGroupBySubjectID4() {
        //test key 
        String key = "INT";
        GroupDAO instance = new GroupDAO();
        Group[] result = instance.searchGroupBySubjectID(key);
        assertEquals(4, result.length);
        assertNotNull(result);
        for (int i = 0; i < result.length; i++) {
            assertTrue(result[i].getSubject().getSubjectID().equals(key));
        }
    }

    @Test
    public void testSearchGroupBySubjectID5() {
        //test key 
        String key = "int";
        GroupDAO instance = new GroupDAO();
        Group[] result = instance.searchGroupBySubjectID(key);
        assertEquals(4, result.length);
        assertNotNull(result);
        for (int i = 0; i < result.length; i++) {
            assertTrue(result[i].getSubject().getSubjectID().toLowerCase().equals(key));
        }
    }

    /**
     * Test of searchGroupBySubjectIDAndGroupID method, of class GroupDAO.
     */
    @Test
    public void testSearchGroupBySubjectIDAndGroupID1() throws SQLException {
        String key1 = "INT1416";
        int key2 = 1;
        GroupDAO instance = new GroupDAO();
        Group result = instance.searchGroupBySubjectIDAndGroupID(key1, key2);
        assertEquals(1, result.getGroupID());
        assertEquals("INT1416", result.getSubject().getSubjectID());
        assertEquals(3, result.getRoom().getRoomID());
        assertEquals("Thứ 2", result.getDay());
        assertEquals("7:00-9:00", result.getHour1());
        assertEquals("12:00-14:00", result.getHour2());
        assertEquals("123456789101112131415-1234567", result.getWeek());
    }

    /**
     * Test of searchSubject method, of class GroupDAO.
     */
    @Test
    public void testSearchSubject1() {
        String key = "Đảm bảo chất lượng phần mềm";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubject(key);
        assertEquals(key, result.getName());
        assertEquals("INT1416", result.getSubjectID());
        assertEquals(3, result.getCredits());
    }

    @Test
    public void testSearchSubject2() {
        String key = "Đảm bảo";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubject(key);
        assertNotNull(result);
    }

    /**
     * Test of searchSubjectID method, of class GroupDAO.
     */
    @Test
    public void testSearchSubjectID() {
        String key = "INT1416";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubjectID(key);
        assertEquals("Đảm bảo chất lượng phần mềm", result.getName());
        assertEquals(key, result.getSubjectID());
        assertEquals(3, result.getCredits());

    }

    /**
     * Test of searchroom method, of class GroupDAO.
     */
    @Test
    public void testSearchroom() {
        String key = "201 - A2";
        GroupDAO instance = new GroupDAO();
        Room result = instance.searchroom(key);
        assertNotNull(result);
        assertEquals(2, result.getRoomID());
        assertEquals("201 - A2", result.getNameRoom());
    }

    /**
     * Test of searchroomID method, of class GroupDAO.
     */
    @Test
    public void testSearchroomID() {
        int key = 2;
        GroupDAO instance = new GroupDAO();
        Room result = instance.searchroomID(key);
        assertEquals(2, result.getRoomID());
        assertEquals("201 - A2", result.getNameRoom());
    }

    /**
     * Test of deleteGroup method, of class GroupDAO.
     */
    @Test
    public void testDeleteGroup() {
        GroupDAO instance = new GroupDAO();
        Group group = new Group();
        Subject subject = new Subject("INT1461", "Xây dựng các hệ thống nhúng", 3);
        Room room = new Room(2, "201 - A2");
        group.setGroupID(1);
        group.setRoom(room);
        group.setSubject(subject);
        group.setDay("Thứ 5");
        group.setHour1("14:00-16:00");
        group.setHour2("18:00-20:00");
        group.setWeek("123456789101112131415-1234567");
        Connection con = instance.con;
        try {
            con.setAutoCommit(false);
            instance.saveGroup(group);
            instance.deleteGroup(group.getGroupID(), group.getSubject().getSubjectID());

            Group group1 = instance.searchGroupBySubjectIDAndGroupID(group.getSubject().getSubjectID(), group.getGroupID());
            assertNull(group1);

        } catch (SQLException e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }
    }

    /**
     * Test of updateGroup method, of class GroupDAO.
     */
    @Test
    public void testUpdateGroup() {
        GroupDAO instance = new GroupDAO();
        Group group = new Group();
        Connection con = instance.con;
        try {
            con.setAutoCommit(false);
            instance.saveGroup(group);

            Subject subject = new Subject("INT1461", "Xây dựng các hệ thống nhúng", 3);
            Room room = new Room(2, "201 - A2");
            group.setGroupID(1);
            group.setRoom(room);
            group.setSubject(subject);
            group.setDay("Thứ 5");
            group.setHour1("14:00-16:00");
            group.setHour2("18:00-20:00");
            group.setWeek("123456789101112131415-1234567");
            instance.updateGroup(group);

            Group result = instance.searchGroupBySubjectIDAndGroupID(group.getSubject().getSubjectID(), group.getGroupID());
            assertEquals(group.getGroupID(), result.getGroupID());
            assertEquals(group.getSubject(), result.getSubject());
            assertEquals(group.getRoom(), result.getRoom());
            assertEquals(group.getDay(), result.getDay());
            assertEquals(group.getHour1(), result.getHour1());
            assertEquals(group.getHour2(), result.getHour2());
            assertEquals(group.getWeek(), result.getWeek());
        } catch (Exception e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }

    }

}
