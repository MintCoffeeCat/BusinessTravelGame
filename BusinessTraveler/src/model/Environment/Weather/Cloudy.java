/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment.Weather;

import model.EnumType.Couple;
import model.EnumType.EnumTypes.PathType;
import model.EnumType.EnumTypes.WeatherType;

/**
 *
 * @author Yun_c
 */
public class Cloudy extends Weather<PathType> {

    public Cloudy(){
        super(WeatherType.CLOUDY,"cloudy.png");
        this.init();
    }
    @Override
    public void init() {
        this.addInfluence(
                new Couple(PathType.DIRT, 20.0),
                new Couple(PathType.GRASS, 15.0),
                new Couple(PathType.ROCK, 25.0),
                new Couple(PathType.ROAD, 5.0)
        );
    }
}
