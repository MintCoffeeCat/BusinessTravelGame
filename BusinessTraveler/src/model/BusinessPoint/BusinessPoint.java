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
import model.Environment.Environment;
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
    protected EnvironmentInfluencable topographys;
    protected EnvironmentInfluencable weather;
    protected String pointLevel;

    public int getId() {
        return id;
    }

    public BusinessPoint() {
        this.id = BusinessPoint.NOW_ID;
        BusinessPoint.NOW_ID += 1;
    }

    public BusinessPoint(String name) {
        this.id = BusinessPoint.NOW_ID;
        BusinessPoint.NOW_ID += 1;
        this.name = name;
        this.x = -1;
        this.y = -1;
    }

    public BusinessPoint(String name, int x, int y) {
        this.id = BusinessPoint.NOW_ID;
        BusinessPoint.NOW_ID += 1;
        this.name = name;
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
        Set<TopographyType> topo = this.topographys.getEnvironment();
        TopographyType[] envStr = new TopographyType[topo.size()];
        return (TopographyType[]) topo.toArray(envStr);
    }

    public GoodsType[] getStoreSpeciality() {
        Set<GoodsType> spe = this.topographys.getSpeciality();
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
        if (topographys == null) {
            return null;
        }
        if (topographys.getOri() instanceof Environment) {
            return null;
        }
        return (Store) topographys.getOri();
    }

    public void setStore(Store store) {
        if (this.topographys == null || this.topographys instanceof Store) {
            this.topographys = store;
        } else if (this.topographys instanceof Topography) {
            ((Environment) this.topographys).setTarget(store);
        }

    }

    public Path getPath() {
        if (weather == null) {
            return null;
        }
        if (weather.getOri() instanceof Environment) {
            return null;
        }
        return (Path) weather.getOri();
    }

    public Weather getWeather() {
        return (Weather)this.weather;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void generateTopography(Topography env) {
        this.topographys = env;
        if (this.topographys.getOri() instanceof Store) {
            ((Store) this.topographys.getOri()).stageInfluence((Environment) this.topographys);
        }
    }

    public void generateWeather(Weather wth) {
        this.weather = wth;
    }
}
