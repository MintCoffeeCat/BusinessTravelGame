/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import javax.swing.ImageIcon;
import model.BusinessPoint.BusinessPoint;
import model.BusinessPoint.Store;
import model.User.User;
import myinterface.Observer;
import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public class BusinessPointPanel extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form BusinessPointPanel
     */
    public BusinessPointPanel(boolean isArrive) {
        this.isArrive = isArrive;
        initComponents();
    }

    public BusinessPointPanel() {
        this.isArrive = true;
        initComponents();
        stateSetting();
    }

    public void setArrive(boolean b) {
        this.isArrive = b;
        stateSetting();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel2 = new component.BackgroundPanel();
        name = new javax.swing.JPanel();
        townName = new java.awt.Label();
        townLevel_pre = new javax.swing.JLabel();
        townLevel = new javax.swing.JLabel();
        speciality_pre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        environmentList = new component.ScrollPanel();
        specialityList = new component.ScrollPanel();
        pointLevel_pre = new javax.swing.JLabel();
        pointLevel = new javax.swing.JLabel();
        TradeButton = new javax.swing.JButton();
        SleepButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        backgroundPanel3 = new component.BackgroundPanel();
        BusinessPointPic = new component.BackgroundPanel();
        weatherPic = new component.BackgroundPanel();
        travelButton = new javax.swing.JButton();

        javax.swing.GroupLayout backgroundPanel2Layout = new javax.swing.GroupLayout(backgroundPanel2);
        backgroundPanel2.setLayout(backgroundPanel2Layout);
        backgroundPanel2Layout.setHorizontalGroup(
            backgroundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        backgroundPanel2Layout.setVerticalGroup(
            backgroundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));

        name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        townName.setAlignment(java.awt.Label.CENTER);
        townName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        townName.setText("Field");

        townLevel_pre.setText("Goods Level");

        townLevel.setText("0");

        speciality_pre.setText("speciality");

        jLabel1.setText("Environment");

        environmentList.setBackground(new java.awt.Color(255, 255, 255));
        environmentList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        specialityList.setBackground(new java.awt.Color(255, 255, 255));
        specialityList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        pointLevel_pre.setText("Point Level");
        pointLevel_pre.setToolTipText("");

        pointLevel.setText("0");

        javax.swing.GroupLayout nameLayout = new javax.swing.GroupLayout(name);
        name.setLayout(nameLayout);
        nameLayout.setHorizontalGroup(
            nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(townName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(nameLayout.createSequentialGroup()
                .addGroup(nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(speciality_pre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nameLayout.createSequentialGroup()
                        .addGroup(nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(townLevel_pre)
                            .addComponent(pointLevel_pre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(townLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pointLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(specialityList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(environmentList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nameLayout.setVerticalGroup(
            nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nameLayout.createSequentialGroup()
                .addComponent(townName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(townLevel_pre)
                    .addComponent(townLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pointLevel_pre)
                    .addComponent(pointLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(environmentList, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(speciality_pre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialityList, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        townName.getAccessibleContext().setAccessibleDescription("");

        TradeButton.setText("Trade");

        SleepButton.setText("Sleep");
        SleepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SleepButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BusinessPointPic.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        BusinessPointPic.setPreferredSize(new java.awt.Dimension(184, 67));

        javax.swing.GroupLayout BusinessPointPicLayout = new javax.swing.GroupLayout(BusinessPointPic);
        BusinessPointPic.setLayout(BusinessPointPicLayout);
        BusinessPointPicLayout.setHorizontalGroup(
            BusinessPointPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        BusinessPointPicLayout.setVerticalGroup(
            BusinessPointPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        weatherPic.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        weatherPic.setPreferredSize(new java.awt.Dimension(67, 67));

        javax.swing.GroupLayout weatherPicLayout = new javax.swing.GroupLayout(weatherPic);
        weatherPic.setLayout(weatherPicLayout);
        weatherPicLayout.setHorizontalGroup(
            weatherPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );
        weatherPicLayout.setVerticalGroup(
            weatherPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundPanel3Layout = new javax.swing.GroupLayout(backgroundPanel3);
        backgroundPanel3.setLayout(backgroundPanel3Layout);
        backgroundPanel3Layout.setHorizontalGroup(
            backgroundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel3Layout.createSequentialGroup()
                .addComponent(BusinessPointPic, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(weatherPic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        backgroundPanel3Layout.setVerticalGroup(
            backgroundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(backgroundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BusinessPointPic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weatherPic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        travelButton.setText("Travel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(travelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SleepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(TradeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SleepButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(travelButton)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SleepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SleepButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SleepButtonActionPerformed

    private void stateSetting() {
        if (this.isArrive) {
            this.travelButton.setEnabled(false);
            this.SleepButton.setEnabled(true);
            this.TradeButton.setEnabled(true);
        } else {
            this.travelButton.setEnabled(true);
            this.SleepButton.setEnabled(false);
            this.TradeButton.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.BackgroundPanel BusinessPointPic;
    private javax.swing.JButton SleepButton;
    private javax.swing.JButton TradeButton;
    private component.BackgroundPanel backgroundPanel2;
    private component.BackgroundPanel backgroundPanel3;
    private component.ScrollPanel environmentList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel name;
    private javax.swing.JLabel pointLevel;
    private javax.swing.JLabel pointLevel_pre;
    private component.ScrollPanel specialityList;
    private javax.swing.JLabel speciality_pre;
    private javax.swing.JLabel townLevel;
    private javax.swing.JLabel townLevel_pre;
    private java.awt.Label townName;
    private javax.swing.JButton travelButton;
    private component.BackgroundPanel weatherPic;
    // End of variables declaration//GEN-END:variables
    private boolean isArrive;

    @Override
    public void update(Subject s) {
        if (s instanceof User) {
            User u = (User) s;
            BusinessPoint newBP = null;
            String tName = "";
            String tLevel = "0";
            String pLevel = "None";
            String[] env = {};
            String[] spe = {};
            ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("img/default.png"));
            if (this.isArrive) {
                newBP = u.getArrive();
            } else {
                newBP = u.getWantTo();
            }
            if (newBP != null) {
                tName = newBP.getName();
                tLevel = newBP.getStore().getMAX_GOODS_LEVEL() + "";
                pLevel = newBP.getPointLevel();
                env = newBP.getEnvironment();
                spe = newBP.getStoreSpeciality();
                icon = newBP.getImg();
            }
            this.townName.setText(tName);
            this.townLevel.setText(tLevel);
            this.pointLevel.setText(pLevel);

            this.environmentList.clearItem();
            this.specialityList.clearItem();
            this.environmentList.addItem(env);
            this.specialityList.addItem(spe);
            this.BusinessPointPic.setImage(icon);
            //this.weatherPic.setImage();
        }
        this.repaint();
        this.revalidate();
    }
}
