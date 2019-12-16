/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import model.Crop;


/**
 *
 * @author Yun_c
 */
public abstract class CropFactory {

    public CropFactory getFactory(String type) {
        CropFactory cf = null;
        if (type.equals("Grain")) {
            cf = new GrainFactory();
        } else if (type.equals("Fruit")) {
            cf = new FruitFactory();
        }
        return cf;
    }

    public abstract Crop getCrop(String name, int level);
    public abstract Crop getCrop(int level);
}


