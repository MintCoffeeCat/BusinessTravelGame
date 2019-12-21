/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import controller.ChoosePointController;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import model.BusinessPoint.BusinessPoint;
import model.WorldMap.WorldMap;
import myinterface.Observer;
import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public class BusinessPointOnMap extends BackgroundPanel implements Observer {

    private int id;
    private boolean chosen = false;
    private boolean arrival = false;
    private boolean locked = false;

    public BusinessPointOnMap(BusinessPoint bp) {
        super();
        String pointLevel = bp.getPointLevel();
        this.id = bp.getId();
        if (pointLevel.equals("Village")) {
            this.setImage(new ImageIcon(this.getClass().getClassLoader().getResource("img/village.jpg")));
        } else if (pointLevel.equals("Town")) {
            this.setImage(new ImageIcon(this.getClass().getClassLoader().getResource("img/town.jpg")));
        } else if (pointLevel.equals("City")) {
            this.setImage(new ImageIcon(this.getClass().getClassLoader().getResource("img/city.jpg")));
        }
        this.addMouseListener(new ChoosePointController());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.chosen || this.arrival || this.locked) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            BasicStroke bs1 = new BasicStroke(5);
            g2d.setStroke(bs1);
            if (this.arrival) {
                g2d.setColor(Color.GREEN);
            } else if (this.locked) {
                g2d.setColor(Color.YELLOW);
            } else {
                g2d.setColor(Color.RED);
            }

            g2d.drawLine(0, 0, 0, this.getHeight());
            g2d.drawLine(0, 0, this.getWidth(), 0);
            g2d.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
            g2d.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
        }

    }

    public int getId() {
        return this.id;
    }

    @Override
    public void update(Subject s) {
        if (s instanceof WorldMap) {
            WorldMap wMap = WorldMap.getInstance();
            BusinessPoint cho = wMap.getChosen();
            BusinessPoint loc = wMap.getLocked();
            BusinessPoint arr = wMap.getNowArrive();
            if (arr != null && arr.getId() == this.id) {
                this.arrival = true;
                this.chosen = false;
                this.locked = false;
            } else {
                this.arrival = false;
            }

            if (!this.arrival && loc != null && loc.getId() == this.id) {
                this.locked = true;
                this.chosen = false;
            } else {
                this.locked = false;
            }

            if (!this.arrival && !this.locked && cho != null && cho.getId() == this.id) {
                this.chosen = true;
            } else {
                this.chosen = false;
            }

        }
        this.repaint();
        this.revalidate();
    }
}


