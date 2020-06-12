package View;

import Controller.GroupDAO;
import Controller.TimeTableController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.TimeTablingDAO;
import Model.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TimeTable extends javax.swing.JFrame implements ActionListener {

    DefaultListModel list = new DefaultListModel();
    TimeTablingDAO dao = new TimeTablingDAO();
    GroupDAO gdao = new GroupDAO();
    DefaultTableModel model;
    private Group[] lstGroup;
    private ArrayList<Group> listGroup;
    private ArrayList<GroupLab> listGroupLab;

    public TimeTable() {
        super("Timetable");
        initComponents();

        lstGroup = dao.listGroup();
        listGroup = new ArrayList<Group>(Arrays.asList(lstGroup));

        dao.listSubject().forEach((i) -> {
            list.addElement(i.getName());
        });
        lstSubject.setModel(list);

        lstSubject.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblResult.getModel().getRowCount() != 0) {
                    for (int i = tblResult.getModel().getRowCount() - 1; i >= 0; i--) {
                        model.removeRow(i);
                    }
                } else {

                    if (e.getValueIsAdjusting()) {
                        return;
                    }
                    String text = lstSubject.getSelectedValue();

                    TimeTablingDAO dao = new TimeTablingDAO();
                    GroupDAO gdao = new GroupDAO();
                    lstGroup = dao.searchGroupBySubjectID(gdao.searchSubject(text).getSubjectID());

                    if (lstGroup == null) {
                        JOptionPane.showMessageDialog(rootPane, "Môn học chưa được lên lịch thời khóa biểu!");
                    } else {

                        model = (DefaultTableModel) tblResult.getModel();
                        Object[] row = new Object[lstGroup.length];
                        for (int i = 0; i < lstGroup.length; i++) {
                            Object[] obj = {lstGroup[i].getSubject().getSubjectID(), lstGroup[i].getSubject().getName(),
                                lstGroup[i].getGroupID(), lstGroup[i].getDay(), lstGroup[i].getHour1().concat(lstGroup[i].getHour2()),
                                lstGroup[i].getRoom().getNameRoom(), lstGroup[i].getWeek()};
                            model.addRow(obj);
                        }
                    }

                }
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = txtSubjectID.getText().trim();
                if (key == null || key.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Nhập mã môn học");
                }
                if (tblResult.getModel().getRowCount() != 0) {
                    for (int j = tblResult.getModel().getRowCount() - 1; j >= 0; j--) {
                        model.removeRow(j);
                    }
                    TimeTablingDAO dao = new TimeTablingDAO();
                    lstGroup = dao.searchGroupBySubjectID(key);

                    model = (DefaultTableModel) tblResult.getModel();
                    Object[] row = new Object[lstGroup.length];
                    for (int i = 0; i < lstGroup.length; i++) {
                        Object[] obj = {lstGroup[i].getSubject().getSubjectID(), lstGroup[i].getSubject().getName(),
                            lstGroup[i].getGroupID(), lstGroup[i].getDay(), lstGroup[i].getHour1().concat(lstGroup[i].getHour2()),
                            lstGroup[i].getRoom().getNameRoom(), lstGroup[i].getWeek()};
                        model.addRow(obj);
                    }
                    txtSubjectID.setText("");
                } else {
                    TimeTablingDAO dao = new TimeTablingDAO();
//                if (gdao.searchSubjectID(key)) {
//                    JOptionPane.showMessageDialog(rootPane, "Môn học không tồn tại");
//                    txtSubjectID.setText("");
//                } else {
                    lstGroup = dao.searchGroupBySubjectID(key);

                    model = (DefaultTableModel) tblResult.getModel();
                    Object[] row = new Object[lstGroup.length];
                    for (int i = 0; i < lstGroup.length; i++) {
                        Object[] obj = {lstGroup[i].getSubject().getSubjectID(), lstGroup[i].getSubject().getName(),
                            lstGroup[i].getGroupID(), lstGroup[i].getDay(), lstGroup[i].getHour1().concat(lstGroup[i].getHour2()),
                            lstGroup[i].getRoom().getNameRoom(), lstGroup[i].getWeek()};
                        model.addRow(obj);
                    }
                    txtSubjectID.setText("");

                }
            }
        });

        tblResult.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }

                Group group = new Group();
                try {
                    group = dao.searchGroupBySubjectIDAndGroupID((String) tblResult.getValueAt(tblResult.getSelectedRow(), 0), (int) tblResult.getValueAt(tblResult.getSelectedRow(), 2));
                } catch (SQLException ex) {
                    Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
                }

                //System.out.println(group.getRoom().getNameRoom());//index row
                editGroup(group);

            }
        });

        btnExit.addActionListener(this);
        btnExcel.addActionListener(this);

        this.pack();
    }

    private void editGroup(Group group) {
        EditFrm frm = new EditFrm(this, group);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }

    public void addExcelActionListener(ActionListener log) {
        btnExcel.addActionListener(log);
    }

    public void addExitActionListener(ActionListener log) {
        btnExit.addActionListener(log);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSubjectID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSubject = new javax.swing.JList<>();
        btnExcel = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pnTimeTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhập mã môn học");

        btnSearch.setText("Tìm kiếm");

        jLabel2.setText("Môn theo CTĐT");

        jScrollPane1.setViewportView(lstSubject);

        btnExcel.setText("Excel");

        btnExit.setText("Đóng");

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MMH", "Tên môn học", "NMH", "Thứ", "Giờ bắt đầu", "Phòng", "Tuần"
            }
        ));
        jScrollPane2.setViewportView(tblResult);

        javax.swing.GroupLayout pnTimeTableLayout = new javax.swing.GroupLayout(pnTimeTable);
        pnTimeTable.setLayout(pnTimeTableLayout);
        pnTimeTableLayout.setHorizontalGroup(
            pnTimeTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnTimeTableLayout.setVerticalGroup(
            pnTimeTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnMainLayout.createSequentialGroup()
                                .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btnSearch))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 163, Short.MAX_VALUE))
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addContainerGap())
            .addComponent(pnTimeTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2))
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnTimeTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcel)
                    .addComponent(btnExit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public static void main(String[] args) {
//        TimeTable t = new TimeTable();
//        TimeTableController c = new TimeTableController(t);
//        t.setVisible(true);
//        t.setLocationRelativeTo(null);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstSubject;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnTimeTable;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtSubjectID;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
