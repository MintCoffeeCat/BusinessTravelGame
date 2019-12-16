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
import model.Fruit;

/**
 *
 * @author Yun_c
 */
class FruitFactory extends CropFactory {

    private static final double MIN_EAT_WEIGHT = 0.15;
    private static final double MAX_EAT_WEIGHT = 0.30;
    private static final double MIN_PIT_WEIGHT = 0.05;
    private static final double MAX_PIT_WEIGHT = 0.15;

    private static final ArrayList<Map<String, Fruit>> TABLE = new ArrayList<Map<String, Fruit>>() {
        {
            add(
                    new HashMap<String, Fruit>() {
                {
                    put("apple", new Fruit("apple", 5, 1));
                    put("orange", new Fruit("orange", 7, 1));
                }
            }
            );

            add(
                    new HashMap<String, Fruit>() {
                {
                    put("apple", new Fruit("juicy apple", 4, 2));
                    put("orange", new Fruit("sweet orange", 6, 2));
                }
            }
            );
        }
    };

    public Crop getCrop(String name, int level) {
        Map<String, Fruit> innerTable = FruitFactory.TABLE.get(level - 1);
        if (innerTable == null) {
            return null;
        }
        Fruit f = new Fruit(innerTable.get(name));
        if (f == null) {
            return null;
        }

        double ran_eat = (Math.random() * (FruitFactory.MAX_EAT_WEIGHT - FruitFactory.MIN_EAT_WEIGHT) + FruitFactory.MIN_EAT_WEIGHT);
        double ran_pit = (Math.random() * (FruitFactory.MAX_PIT_WEIGHT - FruitFactory.MIN_PIT_WEIGHT) + FruitFactory.MIN_PIT_WEIGHT);
        f.setEatableWeight(ran_eat);
        f.setPitWeight(ran_pit);
        return f;
    }

    @Override
    public Crop getCrop(int level) {
        Map<String, Fruit> innerTable = FruitFactory.TABLE.get(level - 1);
        if (innerTable == null) {
            return null;
        }
        String[] keyset = (String[]) innerTable.keySet().toArray();
        int ran_key = (int) (Math.random() * keyset.length);
        Fruit f = new Fruit(innerTable.get(keyset[ran_key]));
        if (f == null) {
            return null;
        }
        double ran_eat = (Math.random() * (FruitFactory.MAX_EAT_WEIGHT - FruitFactory.MIN_EAT_WEIGHT) + FruitFactory.MIN_EAT_WEIGHT);
        double ran_pit = (Math.random() * (FruitFactory.MAX_PIT_WEIGHT - FruitFactory.MIN_PIT_WEIGHT) + FruitFactory.MIN_PIT_WEIGHT);
        f.setEatableWeight(ran_eat);
        f.setPitWeight(ran_pit);
        return f;
    }
}
