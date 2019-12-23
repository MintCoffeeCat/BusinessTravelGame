/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import component.BusinessPointOnMap;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.BusinessPoint.BusinessPoint;
import model.User.User;
import model.WorldMap.WorldMap;

/**
 *
 * @author Yun_c
 */
public class ChoosePointController implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        BusinessPointOnMap bpm = (BusinessPointOnMap) e.getSource();
        WorldMap wMap = WorldMap.getInstance();
        BusinessPoint bp = wMap.getPoint(bpm.getId());
        wMap.setLocked(bp);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        BusinessPointOnMap bpm = (BusinessPointOnMap) e.getSource();
        WorldMap wMap = WorldMap.getInstance();
        BusinessPoint bp = wMap.getPoint(bpm.getId());
        System.out.println("mouse enter " + bp.getName());
        wMap.setChosen(bp);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
