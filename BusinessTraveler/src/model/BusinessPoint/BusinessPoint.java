/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BusinessPoint;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.ImageIcon;
import model.Store;
import myinterface.EnvironmentInfluencable;
import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public abstract class BusinessPoint implements Subject {
    protected ImageIcon img;
    protected String name;
    protected EnvironmentInfluencable store;
    protected Path path;
    protected String pointLevel;
    
    public BusinessPoint(){}
    public BusinessPoint(String name, Store s) {
        this.name = name;
        this.store = s;
        this.path = null;
    }
    public String[] getEnvironment(){
        Set<String> envs = this.store.getEnvironment();
        String[] envStr = new String[envs.size()];
        return (String[])envs.toArray(envStr);
    }
    public String[] getStoreSpeciality(){
        Set<String> spe = this.store.getSpeciality();
        String[] envStr = new String[spe.size()];
        return (String[])spe.toArray(envStr);
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
        return (Store)store.getOri();
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

    public void generateEnvironment(EnvironmentInfluencable env) {
        this.store = env;
    }
}



