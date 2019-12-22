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
import model.Environment.Topography.Topography;
import model.Environment.Weather.Weather;
import model.EnumType.EnumTypes.TopographyType;
import model.Environment.Environment;
import myinterface.EnvironmentInfluencable;
import myinterface.Subject;
import myinterface.TimeInfluencable;
import tools.WeatherGenerater;

/**
 *
 * @author Yun_c
 */
public abstract class BusinessPoint implements Subject, TimeInfluencable {

    private static int NOW_ID = 0;
    private final int id;
    protected int x;
    protected int y;
    protected long d;
    protected int pi;
    protected ImageIcon img;
    protected String name;
    protected EnvironmentInfluencable topographys;
    protected EnvironmentInfluencable weather;
    protected String pointLevel;
    protected WeatherGenerater weatherGenerater = new WeatherGenerater();

    public BusinessPoint() {
        this.id = BusinessPoint.NOW_ID;
        BusinessPoint.NOW_ID += 1;
        this.d = Short.MAX_VALUE;
        this.pi = -1;
        this.weatherGenerater.timePassBy();
        this.generateWeather(this.weatherGenerater.getWeather());
    }

    public BusinessPoint(String name) {
        this(name, -1, -1);
    }

    public BusinessPoint(String name, int x, int y) {
        this();
        this.name = name;
        this.x = x;
        this.y = y;

    }

    /**
     * return the array of type, if no any topography, return empty array.
     */
    public TopographyType[] getTopographyType() {
        Set<TopographyType> topo = this.topographys.getEnvironment();
        TopographyType[] envStr = new TopographyType[topo.size()];
        return (TopographyType[]) topo.toArray(envStr);
    }

    /**
     * return the array of specialityType, if no any Speciality, return empty
     * array.
     */
    public GoodsType[] getStoreSpecialityType() {
        Set<GoodsType> spe = this.topographys.getSpeciality();
        GoodsType[] envStr = new GoodsType[spe.size()];
        return (GoodsType[]) spe.toArray(envStr);
    }

    public void generateTopography(Topography env) {
        if (this.topographys != null && this.topographys.getOri() instanceof Store) {
            env.setTarget((Store) this.topographys.getOri());
            this.topographys = env;
            ((Store) this.topographys.getOri()).stageInfluence((Environment) this.topographys);
        } else {
            this.topographys = env;
        }
    }

    private void generateWeather(Weather wth) {
        if (this.weather != null && this.weather.getOri() instanceof Path) {
            wth.setTarget((Path) this.weather.getOri());
        }
        this.weather = wth;
    }

    /**
     * return the current weather of this BusinessPoint, if no weather exists,
     * return null.
     */
    public Weather getWeather() {
        if (!(this.weather instanceof Weather)) {
            return null;
        }
        return (Weather) this.weather;
    }

    /**
     * return the Store of this BusinessPoint, if no Store exists, return null.
     */
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getD() {
        return this.d;
    }

    public int getPi() {
        return this.pi;
    }

    public int getId() {
        return id;
    }

    public void setD(Long d) {
        this.d = d;
    }

    public void setPi(int pi) {
        this.pi = pi;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void timePassBy() {
        this.weatherGenerater.timePassBy();
        this.generateWeather(this.weatherGenerater.getWeather());
        this.notifyObserver();
    }
}
