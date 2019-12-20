/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BusinessPoint;

import javax.swing.ImageIcon;
import model.BusinessPoint.BusinessPoint;

/**
 *
 * @author Yun_c
 */
public class Town extends BusinessPoint {
    public Town(String name){
        this.name = name;
        this.store = new Store(70,2);
        this.pointLevel = "Town";
                this.img = new ImageIcon(this.getClass().getClassLoader().getResource("img/town.jpg"));
    } 
}