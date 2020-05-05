package Controller;

import Model.User;
import View.MainFrame;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LogInController {

    private Login login;
    private User user;

    public LogInController(Login login) {
        this.login = login;
        login.addLoginListener(new LoginListener());
    }
    
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                user = login.getUser();
                if(checkUser(user)){
                    MainFrame mf = new MainFrame();
                    mf.setVisible(true);
                    mf.setLocationRelativeTo(null);
                    login.dispose();
                }else{
                    login.showMessage("Invalid username and/or password!");
                }                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean checkUser(User user) throws Exception {

        String query = "Select * FROM users WHERE code ='" + user.getCode()
                + "' AND pass ='" + user.getPass() + "'";
        try {
            Class.forName(Utils.Parameters.dbClass);
            try (Connection con = DriverManager.getConnection(Utils.Parameters.dbUrl, Utils.Parameters.userName, Utils.Parameters.password)) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return false;
    }
}
