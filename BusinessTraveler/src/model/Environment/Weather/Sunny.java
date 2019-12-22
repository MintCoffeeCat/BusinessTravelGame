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
public class Sunny extends Weather<PathType>{

    public Sunny() {
        super(WeatherType.SUNNY, "sunny.png");
    }

    @Override
    public void init() {
        this.addInfluence(
                new Couple(PathType.DIRT, -8.0),
                new Couple(PathType.GRASS, -10.0),
                new Couple(PathType.ROCK, 10.0),
                new Couple(PathType.ROAD, 0.0)
        );
    }
}
