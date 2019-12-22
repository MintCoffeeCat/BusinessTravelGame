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
public class HeavyRainy extends Weather<PathType> {

    public HeavyRainy() {
        super(WeatherType.HEAVY_RAINY, "heavyrainy.png");
        this.init();
    }

    @Override
    public void init() {
        this.addInfluence(
                new Couple(PathType.DIRT, 27.0),
                new Couple(PathType.GRASS, 20.0),
                new Couple(PathType.ROCK, 38.0),
                new Couple(PathType.ROAD, 10.0)
        );
    }

}
