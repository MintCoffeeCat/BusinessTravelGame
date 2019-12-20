/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BusinessPoint;

import model.Path.Path;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.ImageIcon;
import myinterface.EnvironmentInfluencable;
import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public abstract class BusinessPoint implements Subject {

    private static int NOW_ID = 0;
    private final int id;
    protected ImageIcon img;
    protected String name;
    protected EnvironmentInfluencable store;
    protected Path path;
    protected String pointLevel;

    public int getId() {
        return id;
    }

    public BusinessPoint() {
        this.id = BusinessPoint.NOW_ID;
        BusinessPoint.NOW_ID += 1;
    }

    public BusinessPoint(String name, Store s) {
        this.id = BusinessPoint.NOW_ID;
        BusinessPoint.NOW_ID += 1;
        this.name = name;
        this.store = s;
        this.path = null;
    }

    public String[] getEnvironment() {
        Set<String> envs = this.store.getEnvironment();
        String[] envStr = new String[envs.size()];
        return (String[]) envs.toArray(envStr);
    }

    public String[] getStoreSpeciality() {
        Set<String> spe = this.store.getSpeciality();
        String[] envStr = new String[spe.size()];
        return (String[]) spe.toArray(envStr);
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
        return (Store) store.getOri();
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
