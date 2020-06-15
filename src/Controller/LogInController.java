package Controller;

import Model.User;
import View.MainFrame;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

public class LogInController {

    private Login login;
    private User user;

    public LogInController(Login login) {
        this.login = login;
        login.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                user = login.getUser();
                if (checkUser(user)) {
                    MainFrame mf = new MainFrame();
                    MainFrameController mfc = new MainFrameController(mf);
                    mf.setVisible(true);
                    mf.setLocationRelativeTo(null);
                    login.dispose();
                } else {
                    login.showMessage("Vui lòng nhập chính xác tên đăng nhập/mật khẩu");
                }
            } catch (Exception ex) {
            }
        }
    }

    public boolean checkUser(User user) throws Exception {

        String query = "Select * FROM users WHERE code = ? AND pass = ?";
        try {
            Class.forName(Utils.Parameters.dbClass);
            try (Connection con = DriverManager.getConnection(Utils.Parameters.dbUrl, Utils.Parameters.userName, Utils.Parameters.password)) {
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, user.getCode());
                stmt.setString(2, user.getPass());
                ResultSet rs = stmt.executeQuery();
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
