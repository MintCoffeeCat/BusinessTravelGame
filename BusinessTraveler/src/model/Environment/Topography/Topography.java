/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment.Topography;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import model.EnumType.EnumTypes.TopographyType;
import model.EnumType.Couple;
import model.Environment.Environment;
import myinterface.EnvironmentInfluencable;

/**
 *
 * @author Yun_c
 */
public abstract class Topography<K> extends Environment<K, TopographyType> {

    protected TopographyType type;

    public Topography(EnvironmentInfluencable s, TopographyType tp) {
        super(s);
        this.type = tp;
    }

    public Topography(TopographyType tp) {
        super();
        this.type = tp;
    }

    @Override
    public TopographyType getEnvironmentType() {
        return this.type;
    }

}
