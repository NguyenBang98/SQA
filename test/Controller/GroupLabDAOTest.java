package Controller;

import Model.GroupLab;
import Model.RoomLab;
import Model.Subject;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class GroupLabDAOTest {
    
    public GroupLabDAOTest() {
    }
    
    /**
     * Test of deleteGroupLab method, of class GroupLabDAO.
     */
    @Test
    public void testDeleteGroupLab() {
        System.out.println("deleteGroupLab");
        int team = 0;
        int GroupID = 0;
        GroupLabDAO instance = new GroupLabDAO();
        instance.deleteGroupLab(team, GroupID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateGroupLab method, of class GroupLabDAO.
     */
    @Test
    public void testUpdateGroupLab() {
        System.out.println("updateGroupLab");
        GroupLabDAO instance = new GroupLabDAO();
        instance.updateGroupLab();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listSubject method, of class GroupLabDAO.
     */
    @Test
    public void testListSubject() {
        System.out.println("listSubject");
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<Subject> expResult = null;
        ArrayList<Subject> result = instance.listSubject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchSubject method, of class GroupLabDAO.
     */
    @Test
    public void testSearchSubject() {
        System.out.println("searchSubject");
        String key = "";
        GroupLabDAO instance = new GroupLabDAO();
        Subject expResult = null;
        Subject result = instance.searchSubject(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchSubjectID method, of class GroupLabDAO.
     */
    @Test
    public void testSearchSubjectID() {
        System.out.println("searchSubjectID");
        String key = "";
        GroupLabDAO instance = new GroupLabDAO();
        Subject expResult = null;
        Subject result = instance.searchSubjectID(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listRoomLab method, of class GroupLabDAO.
     */
    @Test
    public void testListRoomLab() {
        System.out.println("listRoomLab");
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<RoomLab> expResult = null;
        ArrayList<RoomLab> result = instance.listRoomLab();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listGroupLab method, of class GroupLabDAO.
     */
    @Test
    public void testListGroupLab() {
        System.out.println("listGroupLab");
        String key = "";
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<GroupLab> expResult = null;
        ArrayList<GroupLab> result = instance.listGroupLab(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchGroupLab method, of class GroupLabDAO.
     */
    @Test
    public void testSearchGroupLab() {
        System.out.println("searchGroupLab");
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<GroupLab> expResult = null;
        ArrayList<GroupLab> result = instance.searchGroupLab();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveGroupLab method, of class GroupLabDAO.
     */
    @Test
    public void testSaveGroupLab() {
        System.out.println("saveGroupLab");
        GroupLab lab = null;
        GroupLabDAO instance = new GroupLabDAO();
        instance.saveGroupLab(lab);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchroomLab method, of class GroupLabDAO.
     */
    @Test
    public void testSearchroomLab() {
        System.out.println("searchroomLab");
        String key = "";
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab expResult = null;
        RoomLab result = instance.searchroomLab(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchroomLabID method, of class GroupLabDAO.
     */
    @Test
    public void testSearchroomLabID() {
        System.out.println("searchroomLabID");
        int key = 0;
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab expResult = null;
        RoomLab result = instance.searchroomLabID(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
