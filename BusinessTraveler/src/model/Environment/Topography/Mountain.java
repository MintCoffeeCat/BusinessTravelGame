/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment.Topography;

import java.util.HashMap;
import model.BusinessPoint.Store;
import model.EnumType.Couple;
import model.EnumType.EnumTypes;
import model.EnumType.EnumTypes.GoodsType;
import model.EnumType.EnumTypes.TopographyType;
import myinterface.EnvironmentInfluencable;

/**
 *
 * @author Yun_c
 */
public class Mountain extends Topography<GoodsType> {
    
    public Mountain(EnvironmentInfluencable s) {
        super(s, TopographyType.MOUNTAIN);
    }

    public Mountain() {
        super(TopographyType.MOUNTAIN);
    }

    public void init() {
        this.addInfluence(
                new Couple(GoodsType.MINERAL, 0.95),
                new Couple(GoodsType.STONE, 0.8),
                new Couple(GoodsType.CRYSTAL, 0.9)
        );
    }
}
