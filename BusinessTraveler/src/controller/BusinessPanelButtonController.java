/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import component.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.User.User;

/**
 *
 * @author Yun_c
 */
public class BusinessPanelButtonController implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = e.getSource();
        if (o instanceof Button) {
            Button bt = (Button) o;
            String type = bt.getText();
            if (type.equals("Travel")) {
                User.getInstance().travel();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
