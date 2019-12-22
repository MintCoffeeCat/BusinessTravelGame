/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment.Weather;

import java.util.HashMap;
import javax.swing.ImageIcon;
import model.EnumType.Couple;
import model.Path.Path;
import model.EnumType.EnumTypes.WeatherType;
import model.Environment.Environment;
import myinterface.EnvironmentInfluencable;

/**
 *
 * @author Yun_c
 */
public abstract class Weather<K> extends Environment<K, WeatherType> {

    protected WeatherType weatherType;
    protected ImageIcon img;
    protected double keepRatio;
    
    public Weather(WeatherType type, String icon) {
        this.weatherType = type;
        this.img = new ImageIcon(this.getClass().getClassLoader().getResource("img/" + icon));
    }

    public Weather(EnvironmentInfluencable t, WeatherType type, String icon) {
        super(t);
        this.weatherType = type;
        this.img = new ImageIcon(this.getClass().getClassLoader().getResource("img/" + icon));
    }
    
    public int getAlertLevel(){
        return this.weatherType.getAlertLevel();
    }
    public ImageIcon getImg(){
        return img;
    }
    @Override
    public WeatherType getEnvironmentType() {
        return this.weatherType;
    }
}
