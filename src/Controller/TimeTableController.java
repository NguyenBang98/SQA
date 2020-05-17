package Controller;

import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTableController {
    private TimeTable tb;

    public TimeTableController(TimeTable tb) {
        this.tb = tb;
        tb.addExitActionListener(new ExitListener());
    }
    
    class ExitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           tb.dispose();
        }
        
    }
        
}
