/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

/**
 *
 * @author Yun_c
 */
public class PathPanel extends javax.swing.JPanel {

    /**
     * Creates new form PathPanel
     */
    public PathPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        arrivalWeatherPic = new component.BackgroundPanel();
        arrivalWeather = new javax.swing.JLabel();
        DestWeatherPic = new component.BackgroundPanel();
        DestWeather = new javax.swing.JLabel();
        arrivalWeatherCost = new javax.swing.JLabel();
        pathCost = new javax.swing.JLabel();
        DestWeatherCost = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(400, 72));

        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        arrivalWeatherPic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout arrivalWeatherPicLayout = new javax.swing.GroupLayout(arrivalWeatherPic);
        arrivalWeatherPic.setLayout(arrivalWeatherPicLayout);
        arrivalWeatherPicLayout.setHorizontalGroup(
            arrivalWeatherPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        arrivalWeatherPicLayout.setVerticalGroup(
            arrivalWeatherPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        arrivalWeather.setText("weather");

        DestWeatherPic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout DestWeatherPicLayout = new javax.swing.GroupLayout(DestWeatherPic);
        DestWeatherPic.setLayout(DestWeatherPicLayout);
        DestWeatherPicLayout.setHorizontalGroup(
            DestWeatherPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        DestWeatherPicLayout.setVerticalGroup(
            DestWeatherPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        DestWeather.setText("weather");

        arrivalWeatherCost.setText("0");

        pathCost.setText("0");

        DestWeatherCost.setText("0");

        jLabel1.setText("+");

        jLabel2.setText("+");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(arrivalWeatherPic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(arrivalWeather)
                        .addGap(173, 173, 173)
                        .addComponent(arrivalWeatherCost)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addComponent(pathCost)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(DestWeatherCost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addComponent(DestWeather))
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DestWeatherPic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arrivalWeather)
                    .addComponent(DestWeather)
                    .addComponent(arrivalWeatherCost)
                    .addComponent(pathCost)
                    .addComponent(DestWeatherCost)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(arrivalWeatherPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DestWeatherPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DestWeather;
    private javax.swing.JLabel DestWeatherCost;
    private component.BackgroundPanel DestWeatherPic;
    private javax.swing.JLabel arrivalWeather;
    private javax.swing.JLabel arrivalWeatherCost;
    private component.BackgroundPanel arrivalWeatherPic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel pathCost;
    // End of variables declaration//GEN-END:variables
}