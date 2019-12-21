/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment;

import model.Goods.Goods;
import java.util.HashMap;
import model.EnumType.Couple;
import myinterface.EnvironmentInfluencable;
import model.EnumType.EnumTypes.GoodsType;
import model.EnumType.EnumTypes.TopographyType;

/**
 *
 * @author Yun_c
 */
public class Plain extends Topography<GoodsType> {

    public Plain() {
        super();
    }

    public Plain(EnvironmentInfluencable s) {
        super(s,TopographyType.PLAIN);
    }

    public void init() {
        this.addInfluence(
                new Couple(GoodsType.CROP, 0.9),
                new Couple(GoodsType.GRAIN, 0.9),
                new Couple(GoodsType.FRUIT, 0.9)
        );
    }
}
