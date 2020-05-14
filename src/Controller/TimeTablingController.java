package Controller;

import Model.Group;
import View.TimeTable;
import View.TimeTabling;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTablingController {

    private Group group;
    private TimeTabling tb;

    public TimeTablingController(TimeTabling tb) {
        this.tb = tb;
        tb.addSaveListener(new SaveListener());
        tb.addShowTimetable(new ShowListerner());
        
    }

    class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }

    class ShowListerner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            TimeTable time = new TimeTable();
            time.setVisible(true);
            time.setLocationRelativeTo(null);
            tb.dispose();
        }
        
    }

}
