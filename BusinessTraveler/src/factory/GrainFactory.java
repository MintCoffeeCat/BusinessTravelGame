/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Crop;
import model.Grain;

/**
 *
 * @author Yun_c
 */
public class GrainFactory extends CropFactory {

    private static final double MIN_WEIGHT = 0.05;
    private static final double MAX_WEIGHT = 0.30;

    private static final ArrayList<Map<String, Grain>> TABLE = new ArrayList<Map<String, Grain>>() {
        {
            add(
                    new HashMap<String, Grain>() {
                {
                    put("wheat", new Grain("wheat", 20, 1));
                    put("rice", new Grain("rice", 25, 1));
                }
            }
            );

            add(
                    new HashMap<String, Grain>() {
                {
                    put("wheat", new Grain("black wheat", 22, 2));
                    put("rice", new Grain("black rice", 30, 2));
                }
            }
            );
        }
    };

    public Crop getCrop(String name, int level) {
        Map<String, Grain> innerTable = GrainFactory.TABLE.get(level - 1);
        if (innerTable == null) {
            return null;
        }
        Grain g = new Grain(innerTable.get(name));
        if (g == null) {
            return null;
        }
        double ran = (Math.random() * (GrainFactory.MAX_WEIGHT - GrainFactory.MIN_WEIGHT) + GrainFactory.MIN_WEIGHT);
        g.setWeight(ran);
        return g;
    }

    @Override
    public Crop getCrop(int level) {
        Map<String, Grain> innerTable = GrainFactory.TABLE.get(level - 1);
        if (innerTable == null) {
            return null;
        }
        String[] keyset = (String[])innerTable.keySet().toArray();
        int ran_key = (int)(Math.random() * keyset.length);
        Grain g = new Grain(innerTable.get(keyset[ran_key]));
        if (g == null) {
            return null;
        }
        double ran = (Math.random() * (GrainFactory.MAX_WEIGHT - GrainFactory.MIN_WEIGHT) + GrainFactory.MIN_WEIGHT);
        g.setWeight(ran);
        return g;
    }
}