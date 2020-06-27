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
    
    @Test
    public void testDeleteGroupLab() {
        int team = 0;
        int GroupID = 0;
        GroupLabDAO instance = new GroupLabDAO();
        instance.deleteGroupLab(team, GroupID);
        
    }

    @Test
    public void testUpdateGroupLab() {
       
        GroupLabDAO instance = new GroupLabDAO();
        instance.updateGroupLab();
       
    }

    @Test
    public void testListSubject() {
        
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<Subject> expResult = null;
        ArrayList<Subject> result = instance.listSubject();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSearchSubject() {
       
        String key = "";
        GroupLabDAO instance = new GroupLabDAO();
        Subject expResult = null;
        Subject result = instance.searchSubject(key);
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSearchSubjectID() {
      
        String key = "";
        GroupLabDAO instance = new GroupLabDAO();
        Subject expResult = null;
        Subject result = instance.searchSubjectID(key);
        assertEquals(expResult, result);
    }

   
    @Test
    public void testListRoomLab() {
        
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<RoomLab> expResult = null;
        ArrayList<RoomLab> result = instance.listRoomLab();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testListGroupLab() {
        
        String key = "";
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<GroupLab> expResult = null;
        ArrayList<GroupLab> result = instance.listGroupLab(key);
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testSearchGroupLab() {
        
        GroupLabDAO instance = new GroupLabDAO();
        ArrayList<GroupLab> expResult = null;
        ArrayList<GroupLab> result = instance.searchGroupLab();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testSaveGroupLab() {
        
        GroupLab lab = null;
        GroupLabDAO instance = new GroupLabDAO();
        instance.saveGroupLab(lab);
        
    }

    /**
     * Test of searchroomLab method, of class GroupLabDAO.
     */
    @Test
    public void testSearchroomLab() {
        
        String key = "";
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab expResult = null;
        RoomLab result = instance.searchroomLab(key);
        assertEquals(expResult, result);
        
    }

   
    @Test
    public void testSearchroomLabID() {
        
        int key = 0;
        GroupLabDAO instance = new GroupLabDAO();
        RoomLab expResult = null;
        RoomLab result = instance.searchroomLabID(key);
        assertEquals(expResult, result);
        
    }
    
}
