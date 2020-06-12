package Controller;

import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TimeTableController {
    private TimeTable tb;

    public TimeTableController(TimeTable tb) {
        this.tb = tb;
        tb.addExitActionListener(new ExitListener());
        tb.addExcelActionListener(new ExcelListener());
    }
    
    class ExitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           tb.dispose();
        }        
    }
    
    class ExcelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(tb, "Đội dev đang hoàn thiện!");
        }
        
    }
        
}
