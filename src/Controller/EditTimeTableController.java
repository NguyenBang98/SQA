package Controller;

import Model.Group;
import View.EditFrm;
import View.TimeTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EditTimeTableController {

    private EditFrm frm;
    Group[] lstGroup;
    boolean tick = false;

    public EditTimeTableController(EditFrm frm) {
        this.frm = frm;
        frm.addExitActionListener(new ExitTimeTable());
        frm.addDeleteActionListener(new DeleteTimeTable());
        frm.addUpdateActionListener(new EditTimeTable());
    }

    class EditTimeTable implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateGroup();
        }

    }

    class DeleteTimeTable implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteGroup();
        }

    }

    class ExitTimeTable implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TimeTable t = new TimeTable();
            TimeTableController tr = new TimeTableController(t);
            t.setVisible(true);
            t.setLocationRelativeTo(null);
            frm.dispose();
        }
    }

    public void updateGroup() {
        Group group = new Group();
        GroupDAO dao = new GroupDAO();
        group.setGroupID(frm.setGroup().getGroupID());
        group.setSubject(frm.setGroup().getSubject());
        group.setRoom(frm.setGroup().getRoom());
        group.setDay(frm.setGroup().getDay());
        group.setHour1(frm.setGroup().getHour1());
        group.setHour2(frm.setGroup().getHour2());
        group.setWeek(frm.setGroup().getWeek());

        lstGroup = dao.searchGroupBySubjectID(frm.setGroup().getSubject().getSubjectID());
        for (int i = 0; i < lstGroup.length; i++) {
            if (lstGroup[i].getRoom().equals(frm.setGroup().getRoom())
                    && lstGroup[i].getHour1().equals(frm.setGroup().getHour1())
                    && lstGroup[i].getHour2().equals(frm.setGroup().getHour2())) {
                JOptionPane.showMessageDialog(frm, "Nhóm môn học đã tồn tại. Vui lòng chỉnh sửa thông tin!");
                tick = true;
                break;
            }
        }
        if (tick == false) {
            GroupDAO daog = new GroupDAO();
            daog.updateGroup(frm.setGroup());
            JOptionPane.showMessageDialog(frm, "Đã chỉnh sửa thành công");
        }
    }

    public void deleteGroup() {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(frm, "Bạn có chắc muốn xóa nhóm môn học?", "Cảnh báo", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {

            GroupDAO dao = new GroupDAO();
            int GroupID = frm.setGroup().getGroupID();
            String SubjectID = frm.setGroup().getSubject().getSubjectID();
            dao.deleteGroup(GroupID, SubjectID);
            TimeTable t = new TimeTable();
            TimeTableController tr = new TimeTableController(t);
            t.setVisible(true);
            t.setLocationRelativeTo(null);
            frm.dispose();
        }
    }
}
