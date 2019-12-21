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
import model.EnumType.EnumTypes.GoodsType;
import model.Environment.Topography;
import model.Environment.Weather;
import model.EnumType.EnumTypes.TopographyType;
import myinterface.EnvironmentInfluencable;
import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public abstract class BusinessPoint implements Subject {

    private static int NOW_ID = 0;
    private final int id;
    protected int x;
    protected int y;
    protected ImageIcon img;
    protected String name;
    protected EnvironmentInfluencable store;
    protected EnvironmentInfluencable path;
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
        this.x = -1;
        this.y = -1;
    }

    public BusinessPoint(String name, Store s, int x, int y) {
        this.id = BusinessPoint.NOW_ID;
        BusinessPoint.NOW_ID += 1;
        this.name = name;
        this.store = s;
        this.path = null;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TopographyType[] getTopography() {
        Set<TopographyType> topo = this.store.getEnvironment();
        TopographyType[] envStr = new TopographyType[topo.size()];
        return (TopographyType[]) topo.toArray(envStr);
    }

    public GoodsType[] getStoreSpeciality() {
        Set<GoodsType> spe = this.store.getSpeciality();
        GoodsType[] envStr = new GoodsType[spe.size()];
        return (GoodsType[]) spe.toArray(envStr);
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
        return (Path) path.getOri();
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void generateTopography(Topography env) {
        this.store = env;
    }

    public void generateWeather(Weather wth) {
        this.path = wth;
    }
}
