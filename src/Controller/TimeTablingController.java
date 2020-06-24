package Controller;

import Model.Group;
import View.TimeTable;
import View.TimeTabling;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TimeTablingController {

    private TimeTabling tb;
    Group[] lstGroup;
    boolean tick = false;

    public TimeTablingController(TimeTabling tb) {
        this.tb = tb;
        tb.addSaveListener(new SaveListener());
        tb.addShowTimetable(new ShowListerner());
    }

    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            saveGroup();
        }

    }

    public void saveGroup() {
        GroupDAO dao = new GroupDAO();
        lstGroup = dao.searchGroupBySubjectID(tb.setGroup().getSubject().getSubjectID());
        if (lstGroup == null) {
            GroupDAO daog = new GroupDAO();
            daog.saveGroup(tb.setGroup());
            JOptionPane.showMessageDialog(tb, "Đã lưu thành công");
        } else {
            for (int i = 0; i < lstGroup.length; i++) {
                if (lstGroup[i].equals(tb.setGroup())) {
                    JOptionPane.showMessageDialog(tb, "Nhóm môn học đã tồn tại. Vui lòng chỉnh sửa thông tin!");
                    tick = true;
                    break;
                }
            }
            if (tick == false) {
                GroupDAO daog = new GroupDAO();
                daog.saveGroup(tb.setGroup());
                JOptionPane.showMessageDialog(tb, "Đã lưu thành công");
            }
        }
    }

    class ShowListerner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TimeTable time = new TimeTable();
            TimeTableController c = new TimeTableController(time);
            time.setVisible(true);
            time.setLocationRelativeTo(null);
            tb.dispose();
        }

    }

}
