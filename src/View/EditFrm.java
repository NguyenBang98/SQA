package View;

import Controller.*;
import Controller.TimeTableController;
import Controller.TimeTablingDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;
import javax.swing.JButton;

public class EditFrm extends javax.swing.JFrame implements ActionListener {

    private TimeTable timetable;
    private Group group;
    private GroupLab lab;
    private int index;
    private GroupDAO dao;
    private TimeTablingDAO tdao;

    public EditFrm(TimeTable time, Group group, GroupLab lab, int index) {
        super("Edit TimeTable");
        initComponents();
        this.timetable = time;
        this.group = group;
        this.lab = lab;
        this.index = index;

        btnUpdate.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
        
        TimeTablingDAO db = new TimeTablingDAO();
        db.listRoom().forEach((i) -> {
            cbListRoom.addItem(i.getNameRoom());
        });
        db.listRoomLab().forEach((i) -> {
            cbRoomLab.addItem(i.getNameRoomLab());
        });
        
        initForm();
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lbSubject = new javax.swing.JLabel();
        txtSubject = new javax.swing.JTextField();
        panelHour1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbListTime1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        txtTime1 = new javax.swing.JTextField();
        panelHour2 = new javax.swing.JPanel();
        cbListTime2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jCheckBox29 = new javax.swing.JCheckBox();
        jCheckBox30 = new javax.swing.JCheckBox();
        txtTime2 = new javax.swing.JTextField();
        panelLab = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbGroupLab = new javax.swing.JComboBox<>();
        cbDayLab = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbRoomLab = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbTimeLab = new javax.swing.JComboBox<>();
        jCheckBox31 = new javax.swing.JCheckBox();
        jCheckBox32 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox33 = new javax.swing.JCheckBox();
        jCheckBox34 = new javax.swing.JCheckBox();
        jCheckBox35 = new javax.swing.JCheckBox();
        jCheckBox36 = new javax.swing.JCheckBox();
        jCheckBox37 = new javax.swing.JCheckBox();
        jCheckBox38 = new javax.swing.JCheckBox();
        jCheckBox39 = new javax.swing.JCheckBox();
        jCheckBox40 = new javax.swing.JCheckBox();
        jCheckBox41 = new javax.swing.JCheckBox();
        jCheckBox42 = new javax.swing.JCheckBox();
        jCheckBox43 = new javax.swing.JCheckBox();
        jCheckBox44 = new javax.swing.JCheckBox();
        jCheckBox45 = new javax.swing.JCheckBox();
        txtTimeLab = new javax.swing.JTextField();
        txtTeam = new javax.swing.JTextField();
        txtDayLab = new javax.swing.JTextField();
        txtRoomLab = new javax.swing.JTextField();
        pnDay = new javax.swing.JPanel();
        cbDay = new javax.swing.JComboBox<>();
        txtDay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnRoom = new javax.swing.JPanel();
        cbListRoom = new javax.swing.JComboBox<>();
        txtRoom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGroupID = new javax.swing.JTextField();
        cbListGroup = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnUpdate.setText("Cập nhật");

        btnReset.setText("Hủy cập nhật");

        btnExit.setText("Đóng");

        lbSubject.setText("Tên môn học");

        jLabel2.setText("Kíp 1");

        cbListTime1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00-9:00", "9:00-11:00", "14:00-16:00", "16:00-18:00" }));

        jLabel5.setText("Tuần");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("1");

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("2");

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("3");

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("4");

        jCheckBox5.setSelected(true);
        jCheckBox5.setText("5");

        jCheckBox6.setSelected(true);
        jCheckBox6.setText("6");

        jCheckBox7.setSelected(true);
        jCheckBox7.setText("7");

        jCheckBox8.setSelected(true);
        jCheckBox8.setText("8");

        jCheckBox9.setSelected(true);
        jCheckBox9.setText("9");

        jCheckBox10.setSelected(true);
        jCheckBox10.setText("10");

        jCheckBox11.setSelected(true);
        jCheckBox11.setText("11");

        jCheckBox12.setSelected(true);
        jCheckBox12.setText("12");

        jCheckBox13.setSelected(true);
        jCheckBox13.setText("13");

        jCheckBox14.setSelected(true);
        jCheckBox14.setText("14");

        jCheckBox15.setSelected(true);
        jCheckBox15.setText("15");

        javax.swing.GroupLayout panelHour1Layout = new javax.swing.GroupLayout(panelHour1);
        panelHour1.setLayout(panelHour1Layout);
        panelHour1Layout.setHorizontalGroup(
            panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHour1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbListTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHour1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox11))
                    .addGroup(panelHour1Layout.createSequentialGroup()
                        .addComponent(jCheckBox12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox15)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelHour1Layout.setVerticalGroup(
            panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHour1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbListTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(panelHour1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox12)
                    .addComponent(jCheckBox13)
                    .addComponent(jCheckBox14)
                    .addComponent(jCheckBox15))
                .addContainerGap())
        );

        cbListTime2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12:00-14:00", "18:00-20:00" }));

        jLabel3.setText("Kíp 2");

        jLabel6.setText("Tuần");

        jCheckBox17.setText("1");

        jCheckBox16.setText("2");

        jCheckBox18.setText("3");

        jCheckBox19.setText("4");

        jCheckBox20.setText("5");

        jCheckBox21.setText("6");

        jCheckBox22.setText("7");

        jCheckBox23.setText("8");

        jCheckBox24.setText("9");

        jCheckBox25.setText("10");

        jCheckBox26.setText("11");

        jCheckBox27.setText("12");

        jCheckBox28.setText("13");

        jCheckBox29.setText("14");
        jCheckBox29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox29ActionPerformed(evt);
            }
        });

        jCheckBox30.setText("15");

        javax.swing.GroupLayout panelHour2Layout = new javax.swing.GroupLayout(panelHour2);
        panelHour2.setLayout(panelHour2Layout);
        panelHour2Layout.setHorizontalGroup(
            panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHour2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbListTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHour2Layout.createSequentialGroup()
                        .addComponent(jCheckBox17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox26))
                    .addGroup(panelHour2Layout.createSequentialGroup()
                        .addComponent(jCheckBox27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHour2Layout.setVerticalGroup(
            panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHour2Layout.createSequentialGroup()
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbListTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelHour2Layout.createSequentialGroup()
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox18)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox20)
                    .addComponent(jCheckBox21)
                    .addComponent(jCheckBox22)
                    .addComponent(jCheckBox23)
                    .addComponent(jCheckBox24)
                    .addComponent(jCheckBox25)
                    .addComponent(jCheckBox26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox27)
                    .addComponent(jCheckBox28)
                    .addComponent(jCheckBox29)
                    .addComponent(jCheckBox30))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel8.setText("Thực hành");

        jLabel9.setText("Tổ thực hành");

        cbGroupLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cbGroupLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGroupLabActionPerformed(evt);
            }
        });

        cbDayLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7" }));

        jLabel10.setText("Phòng");

        jLabel11.setText("Thứ");

        jLabel13.setText("Kíp");

        cbTimeLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00-12:00", "12:00-16:00", "16:00-18:00" }));

        jCheckBox31.setText("1");

        jCheckBox32.setText("2");

        jLabel12.setText("Tuần");

        jCheckBox33.setText("3");

        jCheckBox34.setText("4");

        jCheckBox35.setText("5");

        jCheckBox36.setText("6");

        jCheckBox37.setText("7");

        jCheckBox38.setText("8");

        jCheckBox39.setText("9");

        jCheckBox40.setText("10");

        jCheckBox41.setText("11");

        jCheckBox42.setText("12");

        jCheckBox43.setText("13");

        jCheckBox44.setText("14");

        jCheckBox45.setText("15");

        javax.swing.GroupLayout panelLabLayout = new javax.swing.GroupLayout(panelLab);
        panelLab.setLayout(panelLabLayout);
        panelLabLayout.setHorizontalGroup(
            panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLabLayout.createSequentialGroup()
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(txtRoomLab)
                            .addComponent(txtDayLab))
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLabLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbDayLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRoomLab, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLabLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox39))
                                    .addComponent(jCheckBox31, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(12, 12, 12))
                            .addGroup(panelLabLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(cbGroupLab, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel13)
                                .addGap(6, 6, 6))))
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel8)))
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox40))
                        .addGap(18, 18, 18)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox41)
                            .addComponent(jCheckBox33))
                        .addGap(2, 2, 2)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox34)
                            .addComponent(jCheckBox42))
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLabLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox44)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox45))
                            .addGroup(panelLabLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox35)
                                .addGap(6, 6, 6)
                                .addComponent(jCheckBox36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox38))))
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtTimeLab, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(cbTimeLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        panelLabLayout.setVerticalGroup(
            panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbGroupLab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel13)
                        .addComponent(cbTimeLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimeLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbDayLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDayLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox31)
                            .addComponent(jCheckBox32)
                            .addComponent(jCheckBox33)
                            .addComponent(jCheckBox34)
                            .addComponent(jCheckBox35)
                            .addComponent(jCheckBox36)
                            .addComponent(jCheckBox37)
                            .addComponent(jCheckBox38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox39)
                            .addComponent(jCheckBox40)
                            .addComponent(jCheckBox41)
                            .addComponent(jCheckBox42)
                            .addComponent(jCheckBox43)
                            .addComponent(jCheckBox44)
                            .addComponent(jCheckBox45)))
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)))
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbRoomLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRoomLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        cbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6" }));

        jLabel1.setText("Thứ");

        javax.swing.GroupLayout pnDayLayout = new javax.swing.GroupLayout(pnDay);
        pnDay.setLayout(pnDayLayout);
        pnDayLayout.setHorizontalGroup(
            pnDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDayLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnDayLayout.setVerticalGroup(
            pnDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDayLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Phòng");

        jLabel7.setText("Nhóm");

        cbListGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        javax.swing.GroupLayout pnRoomLayout = new javax.swing.GroupLayout(pnRoom);
        pnRoom.setLayout(pnRoomLayout);
        pnRoomLayout.setHorizontalGroup(
            pnRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbListRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtGroupID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbListGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnRoomLayout.setVerticalGroup(
            pnRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRoomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbListRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtGroupID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbListGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnUpdate)
                .addGap(175, 175, 175)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(37, 37, 37))
            .addComponent(panelHour1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelHour2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSubject)
                .addGap(18, 18, 18)
                .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(pnDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnMainLayout.createSequentialGroup()
                .addComponent(pnRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSubject)
                            .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(panelHour1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelHour2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(panelLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnReset)
                    .addComponent(btnExit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox29ActionPerformed

    }//GEN-LAST:event_jCheckBox29ActionPerformed

    private void cbGroupLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGroupLabActionPerformed

    }//GEN-LAST:event_cbGroupLabActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton) e.getSource();
        if (btnClicked.equals(btnReset)) {
            initForm();
            return;
        }
        if (btnClicked.equals(btnUpdate)) {
            btnUpdateClick();
        }
        if(btnClicked.equals(btnExit)){
            btnExitClick();
        }
    }

    private void btnUpdateClick() {
        if(lab != null && group == null){
            lab.setTeam(Integer.parseInt(txtTeam.getText()));
            lab.setDay(txtDayLab.getText());
            lab.setHour(txtTimeLab.getText());
            //lab.setRoomLab(txt);
        }
        if(group != null && lab == null){
            
        }
    }

    private void initForm() {
        if(lab != null && group == null){
            txtSubject.setText(lab.getSubject().getName());
            pnDay.setVisible(false);
            panelHour1.setVisible(false);
            panelHour2.setVisible(false);
            pnRoom.setVisible(false);
            panelLab.setVisible(true);
            txtTeam.setText(String.valueOf(lab.getTeam()));
            txtTimeLab.setText(lab.getHour());
            txtDayLab.setText(lab.getDay());
            txtRoomLab.setText(lab.getRoomLab().getNameRoomLab());
        }
        if(group != null && lab == null){
            txtSubject.setText(group.getSubject().getName());
            pnDay.setVisible(true);
            panelHour1.setVisible(true);
            panelHour2.setVisible(true);
            pnRoom.setVisible(true);
            panelLab.setVisible(false);
            txtDay.setText(group.getDay());
            txtTime1.setText(group.getHour1());
            txtTime2.setText(group.getHour2());
            txtRoom.setText(group.getRoom().getNameRoom());
            txtGroupID.setText(String.valueOf(group.getGroupID()));
            if(group.getHour1().equals("7:00-9:00") || group.getHour1().equals("14:00-16:00")){
                jCheckBox16.setSelected(true);
                jCheckBox17.setSelected(true);
                jCheckBox18.setSelected(true);
                jCheckBox19.setSelected(true);
                jCheckBox20.setSelected(true);
                jCheckBox21.setSelected(true);
                jCheckBox22.setSelected(true);
            }
            if(group.getHour1().equals("9:00-11:00") || group.getHour1().equals("16:00-18:00")){
                jCheckBox24.setSelected(true);
                jCheckBox25.setSelected(true);
                jCheckBox26.setSelected(true);
                jCheckBox27.setSelected(true);
                jCheckBox28.setSelected(true);
                jCheckBox29.setSelected(true);
                jCheckBox30.setSelected(true);
            }
        }       
    }
    
    private void btnExitClick(){
        TimeTable t = new TimeTable();
        TimeTableController tr = new TimeTableController(t);
        t.setVisible(true);
        t.setLocationRelativeTo(null);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbDay;
    private javax.swing.JComboBox<String> cbDayLab;
    private javax.swing.JComboBox<String> cbGroupLab;
    private javax.swing.JComboBox<String> cbListGroup;
    private javax.swing.JComboBox<String> cbListRoom;
    private javax.swing.JComboBox<String> cbListTime1;
    private javax.swing.JComboBox<String> cbListTime2;
    private javax.swing.JComboBox<String> cbRoomLab;
    private javax.swing.JComboBox<String> cbTimeLab;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbSubject;
    private javax.swing.JPanel panelHour1;
    private javax.swing.JPanel panelHour2;
    private javax.swing.JPanel panelLab;
    private javax.swing.JPanel pnDay;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnRoom;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtDayLab;
    private javax.swing.JTextField txtGroupID;
    private javax.swing.JTextField txtRoom;
    private javax.swing.JTextField txtRoomLab;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTeam;
    private javax.swing.JTextField txtTime1;
    private javax.swing.JTextField txtTime2;
    private javax.swing.JTextField txtTimeLab;
    // End of variables declaration//GEN-END:variables
}
