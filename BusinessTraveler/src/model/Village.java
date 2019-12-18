/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author Yun_c
 */
public class Village extends BusinessPoint {
    public Village(String name){
        this.name = name;
        this.store = new Store(30,1);
        this.pointLevel = "Village";
        this.img = new ImageIcon(this.getClass().getClassLoader().getResource("img/village.png"));
    }
}