package View;

import Controller.GroupDAO;
import Controller.GroupLabDAO;
import Model.Group;
import Model.GroupLab;
import Model.Room;
import Model.RoomLab;
import Model.Subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTabling extends javax.swing.JFrame implements ActionListener {

    Room room;
    Subject subject;
    RoomLab roomLab;
    String week;

    public TimeTabling() {
        super("Tạo thời khóa biểu");
        initComponents();
        week = new String("123456789101112131415-");
        panelLab.setVisible(false);

        GroupDAO db = new GroupDAO();
        GroupLabDAO gl = new GroupLabDAO();
        db.listSubject().forEach((i) -> {
            cbListSubject.addItem(i.getName());
        });
        db.listRoom().forEach((i) -> {
            cbListRoom.addItem(i.getNameRoom());
        });
        gl.listRoomLab().forEach((i) -> {
            cbRoomLab.addItem(i.getNameRoomLab());
        });

        cbListSubject.addActionListener((ActionEvent e) -> {
            if (cbListSubject.getSelectedItem().toString().equals("Phát triển ứng dụng cho các thiết bị di động")) {
                panelLab.setVisible(true);
            } else {
                panelLab.setVisible(false);
            }
        });

        cbListSubject.addActionListener((ActionEvent e) -> {
            if (cbListSubject.getSelectedItem().toString().equals("Chuyên đề công nghệ phần mềm")) {
                panelHour2.setVisible(false);
                panelLab.setVisible(false);
//                
                jCheckBox8.setSelected(false);
                jCheckBox9.setSelected(false);
                jCheckBox10.setSelected(false);
                jCheckBox11.setSelected(false);
                jCheckBox12.setSelected(false);
                jCheckBox13.setSelected(false);
                jCheckBox14.setSelected(false);
                jCheckBox15.setSelected(false);
            } else {
                panelHour2.setVisible(true);

            }
        });
        
        cbListSubject.addActionListener((ActionEvent e) -> {
            if (cbListSubject.getSelectedItem().toString().equals("Chuyên đề công nghệ phần mềm") == false) {
                panelHour2.setVisible(true);
                panelLab.setVisible(false);
//                
                jCheckBox8.setSelected(true);
                jCheckBox9.setSelected(true);
                jCheckBox10.setSelected(true);
                jCheckBox11.setSelected(true);
                jCheckBox12.setSelected(true);
                jCheckBox13.setSelected(true);
                jCheckBox14.setSelected(true);
                jCheckBox15.setSelected(true);
            } else {
                panelHour2.setVisible(true);

            }
        });
        
        cbListTime1.addActionListener((ActionEvent e) -> {
            if (cbListTime1.getSelectedItem().toString().equals("7:00-9:00") || cbListTime1.getSelectedItem().toString().equals("14:00-16:00")) {              
                jCheckBox16.setSelected(true);
                jCheckBox17.setSelected(true);
                jCheckBox18.setSelected(true);
                jCheckBox19.setSelected(true);
                jCheckBox20.setSelected(true);
                jCheckBox21.setSelected(true);
                jCheckBox22.setSelected(true);
                jCheckBox24.setSelected(false);
                jCheckBox25.setSelected(false);
                jCheckBox26.setSelected(false);
                jCheckBox27.setSelected(false);
                jCheckBox28.setSelected(false);
                jCheckBox29.setSelected(false);
                jCheckBox30.setSelected(false);
                week = "123456789101112131415-1234567";
            } else {
                jCheckBox16.setSelected(false);
                jCheckBox17.setSelected(false);
                jCheckBox18.setSelected(false);
                jCheckBox19.setSelected(false);
                jCheckBox20.setSelected(false);
                jCheckBox21.setSelected(false);
                jCheckBox22.setSelected(false);
                jCheckBox24.setSelected(true);
                jCheckBox25.setSelected(true);
                jCheckBox26.setSelected(true);
                jCheckBox27.setSelected(true);
                jCheckBox28.setSelected(true);
                jCheckBox29.setSelected(true);
                jCheckBox30.setSelected(true);
                week = "123456789101112131415-9101112131415";
            }
        });
                

        btnSave.addActionListener(this);
        btnShowTimtable.addActionListener(this);
    }

    public Group setGroup() {
        Group group = new Group();
        GroupDAO dao = new GroupDAO();
        group.setGroupID(Integer.parseInt(cbListGroup.getSelectedItem().toString()));
        group.setSubject(dao.searchSubject(cbListSubject.getSelectedItem().toString()));
        group.setRoom(dao.searchroom(cbListRoom.getSelectedItem().toString()));
        group.setDay(cbDay.getSelectedItem().toString());
        group.setHour1(cbListTime1.getSelectedItem().toString());
        group.setHour2(cbListTime2.getSelectedItem().toString());
        group.setWeek(week);
        return group;
    }

    public GroupLab setLab() {
        GroupLab lab = new GroupLab();
        GroupLabDAO dao = new GroupLabDAO();
        lab.setTeam(Integer.parseInt(cbGroupLab.getSelectedItem().toString()));
        lab.setGroupID(Integer.parseInt(cbListGroup.getSelectedItem().toString()));
        lab.setSubject(dao.searchSubject(cbListSubject.getSelectedItem().toString()));
        lab.setRoomLab(dao.searchroomLab(cbRoomLab.getSelectedItem().toString()));
        lab.setDay(cbDayLab.getSelectedItem().toString());
        lab.setHour(cbTimeLab.getSelectedItem().toString());
        return lab;
    }

    public void addSaveListener(ActionListener log) {
        btnSave.addActionListener(log);
    }

    public void addShowTimetable(ActionListener log) {
        btnShowTimtable.addActionListener(log);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbListSubject = new javax.swing.JComboBox<>();
        lbSubject = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbListRoom = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbListGroup = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbDay = new javax.swing.JComboBox<>();
        btnShowTimtable = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbSubject.setText("Tên môn học");

        jLabel4.setText("Phòng");

        jLabel7.setText("Nhóm");

        cbListGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cbListGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListGroupActionPerformed(evt);
            }
        });

        btnSave.setText("Lưu");

        jLabel1.setText("Thứ");

        cbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6" }));

        btnShowTimtable.setText("Xem TKB");

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
                        .addGap(285, 285, 285)
                        .addComponent(jLabel8))
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLabLayout.createSequentialGroup()
                                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addGap(52, 52, 52)
                                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbDayLab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbRoomLab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelLabLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cbGroupLab, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLabLayout.createSequentialGroup()
                                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelLabLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jCheckBox39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLabLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox31)))
                                .addGap(18, 18, 18)
                                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox32)
                                    .addComponent(jCheckBox40)))
                            .addGroup(panelLabLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(30, 30, 30)
                                .addComponent(cbTimeLab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox41)
                            .addComponent(jCheckBox33))))
                .addGap(42, 42, 42)
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox34)
                    .addComponent(jCheckBox42))
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jCheckBox43)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox35)
                        .addGap(18, 18, 18)))
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox36)
                    .addComponent(jCheckBox44))
                .addGap(18, 18, 18)
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addComponent(jCheckBox37)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox38))
                    .addComponent(jCheckBox45))
                .addGap(13, 13, 13))
        );
        panelLabLayout.setVerticalGroup(
            panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbGroupLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cbTimeLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDayLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbRoomLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLabLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox31)
                            .addComponent(jCheckBox32)
                            .addComponent(jLabel12)
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
                            .addComponent(jCheckBox45))))
                .addContainerGap(34, Short.MAX_VALUE))
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
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHour2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(70, 70, 70)
                        .addComponent(cbListTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox17))
                    .addGroup(panelHour2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBox24)))
                .addGap(18, 18, 18)
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox25))
                .addGap(18, 18, 18)
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox26)
                    .addComponent(jCheckBox18))
                .addGap(30, 30, 30)
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox27))
                .addGap(18, 18, 18)
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox28)
                    .addComponent(jCheckBox20))
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHour2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jCheckBox21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHour2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox29)
                        .addGap(18, 18, 18)))
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHour2Layout.createSequentialGroup()
                        .addComponent(jCheckBox22)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox23))
                    .addComponent(jCheckBox30))
                .addGap(21, 21, 21))
        );
        panelHour2Layout.setVerticalGroup(
            panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHour2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbListTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHour2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox20)
                    .addComponent(jCheckBox21)
                    .addComponent(jCheckBox22)
                    .addComponent(jCheckBox23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHour2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox27)
                    .addComponent(jCheckBox26)
                    .addComponent(jCheckBox25)
                    .addComponent(jCheckBox24)
                    .addComponent(jCheckBox28)
                    .addComponent(jCheckBox29)
                    .addComponent(jCheckBox30))
                .addContainerGap())
        );

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
                .addGap(69, 69, 69)
                .addComponent(cbListTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelHour1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(24, 24, 24)
                        .addComponent(jCheckBox2)
                        .addGap(22, 22, 22))
                    .addGroup(panelHour1Layout.createSequentialGroup()
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox10)
                        .addGap(18, 18, 18)))
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox11))
                .addGap(28, 28, 28)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox12))
                .addGap(23, 23, 23)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox13)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox14))
                .addGap(18, 18, 18)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHour1Layout.createSequentialGroup()
                        .addComponent(jCheckBox7)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox8))
                    .addComponent(jCheckBox15))
                .addGap(21, 21, 21))
        );
        panelHour1Layout.setVerticalGroup(
            panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHour1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbListTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
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
                    .addComponent(jCheckBox8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(panelHour1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox13)
                    .addComponent(jCheckBox14)
                    .addComponent(jCheckBox15)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox12))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelHour1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelHour2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(65, 65, 65)
                .addComponent(cbListGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cbListRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnShowTimtable)
                .addGap(108, 108, 108))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSubject)
                        .addGap(29, 29, 29)
                        .addComponent(cbListSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbListSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSubject)
                    .addComponent(jLabel1)
                    .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelHour1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelHour2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbListGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbListRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnShowTimtable))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox29ActionPerformed

    }//GEN-LAST:event_jCheckBox29ActionPerformed

    private void cbListGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListGroupActionPerformed
        
    }//GEN-LAST:event_cbListGroupActionPerformed

    private void cbGroupLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGroupLabActionPerformed

    }//GEN-LAST:event_cbGroupLabActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShowTimtable;
    private javax.swing.JComboBox<String> cbDay;
    private javax.swing.JComboBox<String> cbDayLab;
    private javax.swing.JComboBox<String> cbGroupLab;
    private javax.swing.JComboBox<String> cbListGroup;
    private javax.swing.JComboBox<String> cbListRoom;
    private javax.swing.JComboBox<String> cbListSubject;
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
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
