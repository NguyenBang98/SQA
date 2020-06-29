package Controller;

import Model.GroupLab;
import Model.RoomLab;
import Model.Subject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class GroupLabDAOTest {

    public GroupLabDAOTest() {
    }

    @Test
    public void testDeleteGroupLab() {
        int team = 1;
        int GroupID = 1;
        String SubjectID = "INT1449";
        GroupLabDAO instance = new GroupLabDAO();
        Connection con = instance.conn;
        try {
            con.setAutoCommit(false);
            instance.deleteGroupLab(team, GroupID, SubjectID);
            GroupLab[] test = instance.listGroupLabID(SubjectID, team, GroupID);
            assertNull(test);
        } catch (Exception e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(GroupLabDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//Update thanh cong

    @Test
    public void testUpdateGroupLab1() {
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab lab = new RoomLab(2, "407-A3");
        Subject subject = new Subject("INT1449", "Phát triển ứng dụng cho các thiết bị di động", 3);
        GroupLab glab = new GroupLab(1, 1, lab, subject, "Thứ 4", "12:00-16:00", "4812");
        Connection con = instance.conn;
        try {
            con.setAutoCommit(false);
            instance.updateGroupLab(glab);
            GroupLab[] result = instance.listGroupLab("INT1449");
            assertEquals(2, result.length);
            
            GroupLab[] test = instance.listGroupLabID("INT1449", 1, 1);
            assertEquals(1, test[0].getTeam());
            assertEquals(1, test[0].getGroupID());
            assertEquals("INT1449", test[0].getSubject().getSubjectID());
            assertEquals(2, test[0].getRoomLab().getRoomLabID());
            assertEquals("Thứ 4", test[0].getDay());
            assertEquals("12:00-16:00", test[0].getHour());
            assertEquals("4812", test[0].getWeek());

        } catch (Exception e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }

    }
//Update trung thoi gian hoc    
    @Test
    public void testUpdateGroupLab2() {
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab lab = new RoomLab(3, "409-A3");
        Subject subject = new Subject("INT1449", "Phát triển ứng dụng cho các thiết bị di động", 3);
        GroupLab glab = new GroupLab(1, 1, lab, subject, "Thứ 2", "12:00-16:00", "4812");
        Connection con = instance.conn;
        try {
            con.setAutoCommit(false);
            instance.updateGroupLab(glab);
            GroupLab[] result = instance.listGroupLab("INT1449");
            assertEquals(2, result.length);
            
            GroupLab[] test = instance.listGroupLabID("INT1449", 1, 1);
            assertEquals(1, test[0].getTeam());
            assertEquals(1, test[0].getGroupID());
            assertEquals("INT1449", test[0].getSubject().getSubjectID());
            assertEquals(2, test[0].getRoomLab().getRoomLabID());
            assertNotEquals("Thứ 2", test[0].getDay());
            assertEquals("12:00-16:00", test[0].getHour());
            assertEquals("4812", test[0].getWeek());

        } catch (Exception e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }

    }
//Update trung to th    
    @Test
    public void testUpdateGroupLab3() {
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab lab = new RoomLab(3, "409-A3");
        Subject subject = new Subject("INT1449", "Phát triển ứng dụng cho các thiết bị di động", 3);
        GroupLab glab = new GroupLab(1, 1, lab, subject, "Thứ 4", "12:00-16:00", "4812");
        Connection con = instance.conn;
        try {
            con.setAutoCommit(false);
            instance.updateGroupLab(glab);
            GroupLab[] result = instance.listGroupLab("INT1449");
            assertEquals(2, result.length);
            
            GroupLab[] test = instance.listGroupLabID("INT1449", 1, 1);
            assertEquals(1, test[0].getTeam());
            assertEquals(1, test[0].getGroupID());
            assertEquals("INT1449", test[0].getSubject().getSubjectID());
            assertEquals(2, test[0].getRoomLab().getRoomLabID());
            assertNotEquals("Thứ 2", test[0].getDay());
            assertEquals("12:00-16:00", test[0].getHour());
            assertEquals("4812", test[0].getWeek());

        } catch (Exception e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }

    }

    @Test
    public void testListSubject() {
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<Subject> result = instance.listSubject();
        assertNotNull(result);
        assertEquals(6, result.size());
        assertEquals("INT1416", result.get(1).getSubjectID());
        assertEquals("Đảm bảo chất lượng phần mềm", result.get(1).getName());
        assertEquals(3, result.get(1).getCredits());

    }

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
        assertNull(result);
    }

    @Test
    public void testSearchSubject3() {
        String key = "";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubject(key);
        assertNull(result);
    }

    @Test
    public void testSearchSubject4() {
        String key = "a' or 't'='t";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubject(key);
        assertNull(result);
    }

    @Test
    public void testSearchSubjectID1() {
        String key = "INT1416";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubjectID(key);
        assertEquals("Đảm bảo chất lượng phần mềm", result.getName());
        assertEquals(key, result.getSubjectID());
        assertEquals(3, result.getCredits());

    }

    @Test
    public void testSearchSubjectID2() {
        String key = "123455";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubjectID(key);
        assertNull(result);

    }

    @Test
    public void testSearchSubjectID3() {
        String key = "";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubjectID(key);
        assertNull(result);

    }

    @Test
    public void testSearchSubjectID4() {
        String key = "a' or 't'='t";
        GroupDAO instance = new GroupDAO();
        Subject result = instance.searchSubjectID(key);
        assertNull(result);

    }

    @Test
    public void testListRoomLab() {
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<RoomLab> result = instance.listRoomLab();
        assertNotNull(result);
        assertEquals(14, result.size());
        assertEquals(2, result.get(1).getRoomLabID());
        assertEquals("407 - A3", result.get(1).getNameRoomLab());
    }

    @Test
    public void testListGroupLab() {

        String key = "INT1449";
        GroupLabDAO instance = new GroupLabDAO();
        GroupLab[] result = instance.listGroupLab(key);
        assertEquals(2, result.length);
        assertEquals(1, result[0].getTeam());
        assertEquals(1, result[0].getGroupID());
        assertEquals("INT1449", result[0].getSubject().getSubjectID());
        assertEquals(3, result[0].getRoomLab().getRoomLabID());
        assertEquals("Thứ 4", result[0].getDay());
        assertEquals("8:00-12:00", result[0].getHour());
        assertEquals("4812", result[0].getWeek());
    }

    @Test
    public void testSearchGroupLab() {

        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<GroupLab> expResult = null;
        //ArrayList<GroupLab> result = instance.searchGroupLab();
        //assertEquals(expResult, result);

    }
//Luu nhom da ton tai

    @Test
    public void testSaveGroupLab1() {
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab lab = new RoomLab(3, "409-A3");
        Subject subject = new Subject("INT1449", "Phát triển ứng dụng cho các thiết bị di động", 3);
        GroupLab glab = new GroupLab(1, 1, lab, subject, "Thứ 4", "12:00-16:00", "4812");
        Connection con = instance.conn;
        try {
            con.setAutoCommit(false);
            instance.saveGroupLab(glab);
            GroupLab[] result = instance.listGroupLab("INT1449");
            assertEquals(2, result.length);

        } catch (Exception e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }
    }
//Luu nhom thuc hanh khi nhom mon hoc chua duoc tao    

    @Test
    public void testSaveGroupLab2() {
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab lab = new RoomLab(3, "409-A3");
        Subject subject = new Subject("INT1449", "Phát triển ứng dụng cho các thiết bị di động", 3);
        GroupLab glab = new GroupLab(1, 3, lab, subject, "Thứ 3", "12:00-16:00", "4812");
        Connection con = instance.conn;
        try {
            con.setAutoCommit(false);
            instance.saveGroupLab(glab);
            GroupLab[] result = instance.listGroupLab("INT1449");
            assertEquals(2, result.length);

        } catch (Exception e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }
    }
//Luu nhom moi    

    @Test
    public void testSaveGroupLab3() {
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab lab = new RoomLab(3, "409-A3");
        Subject subject = new Subject("INT1449", "Phát triển ứng dụng cho các thiết bị di động", 3);
        GroupLab glab = new GroupLab(1, 2, lab, subject, "Thứ 3", "12:00-16:00", "4812");
        Connection con = instance.conn;
        try {
            con.setAutoCommit(false);
            instance.saveGroupLab(glab);
            GroupLab[] result = instance.listGroupLab("INT1449");
            assertEquals(2, result.length);

        } catch (Exception e) {
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception e) {
            }
        }
    }

    /**
     * Test of searchroomLab method, of class GroupLabDAO.
     */
    @Test
    public void testSearchroomLab1() {
        String key = "409 - A3";
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab result = instance.searchroomLab(key);
        assertNotNull(result);
        assertEquals(3, result.getRoomLabID());
        assertEquals("409 - A3", result.getNameRoomLab());
    }

    @Test
    public void testSearchroomLab2() {
        String key = "409 - A2";
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab result = instance.searchroomLab(key);
        assertNull(result);
    }

    @Test
    public void testSearchroomLabID1() {
        int key = 3;
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab result = instance.searchroomLabID(key);
        assertNotNull(result);
        assertEquals(3, result.getRoomLabID());
        assertEquals("409 - A3", result.getNameRoomLab());

    }

    @Test
    public void testSearchroomLabID2() {
        int key = 50;
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab result = instance.searchroomLabID(key);
        assertNull(result);

    }

}
