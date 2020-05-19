package Controller;

import View.TimeTabling;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MainFrameController {

    private MainFrame mainF;

    public MainFrameController(MainFrame mainF) {
        this.mainF = mainF;
        mainF.addCreateTimeTable(new CreateTimeTable());
        mainF.addStatic(new Static());
    }

    class CreateTimeTable implements ActionListener {

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
    
    class Static implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(mainF, "Dev đang hoàn thiện! Chúc bạn một ngày vui vẻ.");
        }
        
    }
}
