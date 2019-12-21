/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Goods;

import model.Goods.Crop;
import model.EnumType.EnumTypes.GoodsType;

/**
 *
 * @author Yun_c
 */
public class Grain extends Crop {

    private double weight;

    public Grain(String name, int rotTime, int level, double weight) {
        super(name, rotTime, level);
        super.setType(GoodsType.GRAIN);
        this.weight = weight;
    }

    public Grain(String name, int rotTime, int level) {
        super(name, rotTime, level);
        super.setType(GoodsType.GRAIN);
        this.weight = 0;
    }

    public Grain(Grain g) {
        super(g);
        this.weight = g.getWeight();
    }

    public String getWeightInfo() {
        return "weight: " + this.weight + " kg.";
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculatePrice() {
        return this.getPricePerKg();
    }
}
