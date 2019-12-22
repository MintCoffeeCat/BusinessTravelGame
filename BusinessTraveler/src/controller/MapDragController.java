/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import model.WorldMap.WorldMap;

/**
 *
 * @author Yun_c
 */
public class MapDragController implements MouseMotionListener, MouseListener {

    private static int memoX = -1;
    private static int memoY = -1;
    private static int biasX = 0;
    private static int biasY = 0;

    @Override
    public void mouseDragged(MouseEvent e) {
        JScrollPane jsp = (JScrollPane) e.getSource();
        int nowX = e.getX();
        int nowY = e.getY();
        this.biasX = nowX - this.memoX;
        this.biasY = nowY - this.memoY;
        this.memoX = nowX;
        this.memoY = nowY;
        JScrollBar jsH = jsp.getHorizontalScrollBar();
        JScrollBar jsV = jsp.getVerticalScrollBar();
        
        jsH.setValue(jsH.getValue() - biasX);
        jsV.setValue(jsV.getValue() - biasY);
    }
    

    @Override
    public void mouseMoved(MouseEvent e) {
        int nowX = e.getX();
        int nowY = e.getY();
        this.biasX = nowX - this.memoX;
        this.biasY = nowY - this.memoY;
        this.memoX = nowX;
        this.memoY = nowY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        WorldMap.getInstance().setLocked(null);
        WorldMap.getInstance().setChosen(null);
        WorldMap.getInstance().clearAllPathColor();
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
