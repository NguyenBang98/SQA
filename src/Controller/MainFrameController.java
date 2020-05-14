package Controller;

import View.TimeTabling;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController implements ActionListener {

    private MainFrame mainF;

    public MainFrameController(MainFrame mainF) {
        this.mainF = mainF;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            TimeTabling timeTabling = new TimeTabling();
            TimeTablingController tbc = new TimeTablingController(timeTabling);
            timeTabling.setVisible(true);
            timeTabling.setLocationRelativeTo(null);
            mainF.dispose();

        } catch (Exception ex) {
        }
    }

}
