package View;

import Controller.GroupDAO;
import Controller.TimeTableController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.TimeTablingDAO;
import Model.*;
import Model.Subject;
import java.awt.Component;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TimeTable extends javax.swing.JFrame implements ActionListener {

    DefaultListModel list = new DefaultListModel();
    TimeTablingDAO dao = new TimeTablingDAO();
    GroupDAO gdao = new GroupDAO();
    DefaultTableModel model;
    private Group[] lstGroup;
    private ArrayList<Group> listGroup;
    private ArrayList<GroupLab> listGroupLab;
    private ArrayList<JButton> listEdit;
    private ArrayList<JButton> listDelete;

    public TimeTable() {
        super("Timetable");
        initComponents();

        lstGroup = dao.listGroup();
        listGroup = new ArrayList<Group>(Arrays.asList(lstGroup));
        listEdit = new ArrayList<JButton>();
        listDelete = new ArrayList<JButton>();

        dao.listSubject().forEach((i) -> {
            list.addElement(i.getName());
        });
        lstSubject.setModel(list);

        lstSubject.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String text = lstSubject.getSelectedValue();

                TimeTablingDAO dao = new TimeTablingDAO();
                GroupDAO gdao = new GroupDAO();
                lstGroup = dao.searchGroupBySubjectID(gdao.searchSubject(text).getSubjectID());
                listGroup = new ArrayList<Group>(Arrays.asList(lstGroup));

            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = txtSubjectID.getText().trim();
                if (key == null || key.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Nhập mã môn học");
                }
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
                    pnTimeTable.setVisible(true);
//                }

            }
        });

        btnExit.addActionListener(this);
        btnExcel.addActionListener(this);

        this.pack();
    }

    private void deleteGroup(int index) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa?", "Cảnh báo!", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            GroupDAO dao = new GroupDAO();
            dao.deleteGroup(listGroup.get(index).getGroupID());
            dao.deleteGroupLab(listGroupLab.get(index).getTeam(), listGroupLab.get(index).getGroupID());
        }
    }

    private void editGroup(int index) {
        new EditFrm(this, (Group) listGroup.get(index), listGroupLab.get(index), index);
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
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

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

        btnEdit.setText("Edit");

        btnDelete.setText("Delete");

        javax.swing.GroupLayout pnTimeTableLayout = new javax.swing.GroupLayout(pnTimeTable);
        pnTimeTable.setLayout(pnTimeTableLayout);
        pnTimeTableLayout.setHorizontalGroup(
            pnTimeTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimeTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnTimeTableLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(148, 148, 148))
        );
        pnTimeTableLayout.setVerticalGroup(
            pnTimeTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimeTableLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pnTimeTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTimeTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addContainerGap())
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

    public static void main(String[] args) {
        TimeTable t = new TimeTable();
        TimeTableController c = new TimeTableController(t);
        t.setVisible(true);
        t.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
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
