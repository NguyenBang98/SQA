package View;

import Controller.MainFrameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends javax.swing.JFrame implements ActionListener {

    public MainFrame() {
        initComponents();
        MainFrameController con = new MainFrameController(this);
        btnTimeTabling.addActionListener(con);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTimeTabling = new javax.swing.JButton();
        btnStatics = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTimeTabling.setText("Tạo thời khóa biểu");

        btnStatics.setText("Xem thống kê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnTimeTabling)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                .addComponent(btnStatics)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimeTabling)
                    .addComponent(btnStatics))
                .addContainerGap(243, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatics;
    private javax.swing.JButton btnTimeTabling;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
