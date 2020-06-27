package Controller;

import Model.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginDAOTest {
    
    public LoginDAOTest() {
    }

    @Test
    public void testCheckUser1() {
        String username = "PM1015";
        String pass = "123456";
        User user = new User(username, pass);
        LoginDAO instance = new LoginDAO();
        boolean expResult = true;
        boolean result = instance.checkUser(user);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckUser2() {
        String username = "B16DCCN033";
        String pass = "123456";
        User user = new User(username, pass);
        LoginDAO instance = new LoginDAO();
        boolean expResult = true;
        boolean result = instance.checkUser(user);
        assertNotEquals(expResult, result);
    }   
}
