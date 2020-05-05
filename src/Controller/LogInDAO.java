package Controller;

import Model.User;
import View.MainFrame;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LogInDAO {

    public LogInDAO() {
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
