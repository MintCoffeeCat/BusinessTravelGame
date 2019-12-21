/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment;

import java.util.HashMap;
import javax.swing.ImageIcon;
import model.EnumType.Couple;
import model.Path.Path;
import model.EnumType.EnumTypes.WeatherType;
import myinterface.EnvironmentInfluencable;

/**
 *
 * @author Yun_c
 */
public class Weather<K> extends Environment<K, WeatherType> {

    protected WeatherType weatherType;
    protected ImageIcon img;

    public Weather(EnvironmentInfluencable t, WeatherType type, ImageIcon icon) {
        super(t);
        this.weatherType = type;
        this.img = icon;
    }

    public void init() {
    }

    @Override
    public WeatherType getEnvironmentType() {
        return this.weatherType;
    }
}
