package Controller;

import Model.Group;
import Model.Room;
import Model.Subject;
import View.TimeTabling;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimeTablingController implements ActionListener{

    private Group group;
    private TimeTabling tb;

    public TimeTablingController(TimeTabling tb) {
        this.tb = tb;
        tb.addSaveListener(new SaveListener());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            group = new Group();
        }

    }

}
