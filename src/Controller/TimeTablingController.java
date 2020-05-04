package Controller;

import Model.Group;
import Model.Room;
import Model.Subject;
import View.TimeTabling;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TimeTablingController {

    private Group group;
    private TimeTabling tb;

    public TimeTablingController(TimeTabling tb) {
        this.tb = tb;
        tb.addSaveListener(new SaveListener());
    }

    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            group = new Group();
        }

    }

}
