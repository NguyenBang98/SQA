package View;

import Controller.GroupDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.TimeTableController.*;
import Controller.TimeTablingDAO;
import Model.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TimeTable extends javax.swing.JFrame implements ActionListener {

    DefaultListModel list = new DefaultListModel();
    TimeTablingDAO dao = new TimeTablingDAO();
    GroupDAO gdao = new GroupDAO();
    private JTable tblResult;
    private ArrayList<Group> listGroup;
    private ArrayList<GroupLab> listGroupLab;
    private ArrayList<JButton> listEdit;
    private ArrayList<JButton> listDelete;

    public TimeTable() {
        super("Timetable");
        initComponents();

        listGroup = new ArrayList<Group>();
        listGroupLab = new ArrayList<GroupLab>();
        listEdit = new ArrayList<JButton>();
        listDelete = new ArrayList<JButton>();
        tblResult = new JTable(new SubjectTableModel());

        dao.listSubject().forEach((i) -> {
            list.addElement(i.getName());
        });
        lstSubject.setModel(list);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = txtSubjectID.getText().trim();
                if (key == null || key.length() == 0) {
                    return;
                }
                TimeTablingDAO dao = new TimeTablingDAO();
                listGroup = dao.searchGroupBySubjectID(key);
                listGroupLab = dao.searchGroupLab(key);
                for (int i = 0; i < (listGroup.size() + listGroupLab.size()); i++) {
                    JButton btn = new JButton("Edit");
                    btn.addActionListener(this);
                    listEdit.add(btn);
                    btn = new JButton("Delete");
                    btn.addActionListener(this);
                    listDelete.add(btn);
                }
                ((DefaultTableModel)tblResult.getModel()).fireTableDataChanged();
            }
        });
        btnExit.addActionListener(this);
        btnExcel.addActionListener(this);

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        tblResult.getColumn("Edit").setCellRenderer(buttonRenderer);
        tblResult.getColumn("Delete").setCellRenderer(buttonRenderer);
        tblResult.addMouseListener(new JTableButtonMouseListener(tblResult));
    }

    class SubjectTableModel extends DefaultTableModel {

        private String[] columnNames = {"MMH", "Tên môn học", "NMH", "TTH",
            "TH", "Thứ", "Giờ BĐ", "Tuần", "Giờ TH", "Tuần TH", "Edit", "Delete"};
        private final Class<?>[] columnTypes = new Class<?>[]{String.class, String.class, Integer.class, Integer.class,
            String.class, String.class, String.class, String.class, String.class, String.class, JButton.class, JButton.class};

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return listGroup.size() + listGroupLab.size();
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }

        @Override
        public Object getValueAt(final int rowIndex, final int columnIndex) {

            switch (columnIndex) {
                case 0:
                    return listGroup.get(rowIndex).getSubject().getSubjectID();
                case 1:
                    return listGroup.get(rowIndex).getSubject().getName();
                case 2:
                    return listGroup.get(rowIndex).getGroupID();
                case 3:
                    return listGroupLab.get(rowIndex).getTeam();
                case 4:
                    return " ";
                case 5:
                    return listGroup.get(rowIndex).getDay();
                case 6:
                    return listGroup.get(rowIndex).getHour1()
                            .concat("\n").concat(listGroup.get(rowIndex).getHour2());
                case 7:
                    return listGroup.get(rowIndex).getWeek();
                case 8:
                    return listGroupLab.get(rowIndex).getHour();
                case 9:
                    return listGroupLab.get(rowIndex).getWeek();
                case 10:
                    return listEdit.get(rowIndex);
                case 11:
                    return listDelete.get(rowIndex);
                default:
                    return "Error";
            }
        }
    }

    class JTableButtonMouseListener extends MouseAdapter {

        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY() / table.getRowHeight();

            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {

                    ((JButton) value).doClick();
                }
            }
        }
    }

    class JTableButtonRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            JButton button = (JButton) value;
            return button;
        }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSubjectID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSubject = new javax.swing.JList<>();
        btnExcel = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pnTimeTable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhập mã môn học");

        btnSearch.setText("Tìm kiếm");

        jLabel2.setText("Môn theo CTĐT");

        jScrollPane1.setViewportView(lstSubject);

        btnExcel.setText("Excel");

        btnExit.setText("Đóng");

        javax.swing.GroupLayout pnTimeTableLayout = new javax.swing.GroupLayout(pnTimeTable);
        pnTimeTable.setLayout(pnTimeTableLayout);
        pnTimeTableLayout.setHorizontalGroup(
            pnTimeTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnTimeTableLayout.setVerticalGroup(
            pnTimeTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTimeTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnSearch))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(pnTimeTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstSubject;
    private javax.swing.JPanel pnTimeTable;
    private javax.swing.JTextField txtSubjectID;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
