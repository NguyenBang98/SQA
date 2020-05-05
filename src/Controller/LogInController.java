package Controller;

import Model.User;
import View.MainFrame;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LogInController {

    private User user;
    private Login login;

    public LogInController(Login login) {
        this.login = login;

        login.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                user = login.getUser();
                if (checkUser(user)) {
                    MainFrame mainF = new MainFrame();
                    mainF.setVisible(true);
                    mainF.setLocationRelativeTo(null);

                } else {
                    login.showMessage("Invalid username and/or password!");
                }
            } catch (Exception ex) {
                login.showMessage(ex.getStackTrace().toString());
            }
        }
    }

    public boolean checkUser(User user) throws Exception {

        String query = "Select * FROM users WHERE name ='" + user.getCode()
                + "' AND pass ='" + user.getPass() + "'";
        try {
            Class.forName(Utils.Parameters.dbClass);
            Connection con = DriverManager.getConnection(Utils.Parameters.dbUrl);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return true;
            }
            con.close();
        } catch (Exception e) {
            throw e;
        }
        return false;
    }
}
