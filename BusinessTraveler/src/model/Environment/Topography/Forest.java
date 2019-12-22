/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment.Topography;

import java.util.HashMap;
import model.BusinessPoint.Store;
import model.EnumType.EnumTypes.GoodsType;
import model.EnumType.Couple;
import model.EnumType.EnumTypes.TopographyType;

import myinterface.EnvironmentInfluencable;

/**
 *
 * @author Yun_c
 */
public class Forest extends Topography<GoodsType> {

    public Forest(EnvironmentInfluencable s) {
        super(s, TopographyType.FOREST);
    }

    public Forest() {
        super(TopographyType.FOREST);
    }

    public void init() {
        this.addInfluence(
                new Couple<GoodsType, Double>(GoodsType.WOOD, 0.95),
                new Couple<GoodsType, Double>(GoodsType.FRUIT, 0.9)
        );
    }
}
