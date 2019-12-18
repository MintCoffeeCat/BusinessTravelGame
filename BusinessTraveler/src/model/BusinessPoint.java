/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public abstract class BusinessPoint implements Subject {
    protected ImageIcon img;
    protected String name;
    protected Store store;
    protected Path path;
    protected String pointLevel;
    
    public BusinessPoint(){}
    public BusinessPoint(String name, Store s) {
        this.name = name;
        this.store = s;
        this.path = null;
    }
    public String[] getEnvironment(){
        return this.store.getEnvironment();
    }
    public String getPointLevel() {
        return pointLevel;
    }

    public ImageIcon getImg() {
        return img;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void generateEnvironment(Store env) {
        this.store = env;
    }
}



