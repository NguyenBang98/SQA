package Controller;

import Model.User;
import View.MainFrame;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                loginUser();
            } catch (Exception ex) {
            }
        }
    }

    public void loginUser() {
        user = login.getUser();
        LoginDAO dao = new LoginDAO();
        if (dao.checkUser(user)) {
            MainFrame mf = new MainFrame();
            MainFrameController mfc = new MainFrameController(mf);
            mf.setVisible(true);
            mf.setLocationRelativeTo(null);
            login.dispose();
        } else {
            login.showMessage("Vui lòng nhập chính xác tên đăng nhập/mật khẩu");
        }
    }
}
