/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment.Weather;

import model.EnumType.Couple;
import model.EnumType.EnumTypes;
import model.EnumType.EnumTypes.PathType;
import model.EnumType.EnumTypes.WeatherType;

/**
 *
 * @author Yun_c
 */
public class Snowy extends Weather<PathType>{
    
    public Snowy(){
        super(WeatherType.RAINY,"snowy.png");
    }
    @Override
    public void init() {
        this.addInfluence(
                new Couple(PathType.DIRT,40.0),
                new Couple(PathType.GRASS, 35.0),
                new Couple(PathType.ROCK, 55.0),
                new Couple(PathType.ROAD, 20.0)
        );
    }
    
}