/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Yun_c
 */
public abstract class Goods {

    private GoodsType type;
    private int pricePerKg;
    private int level;
    private String name;

    public Goods() {
    }

    public Goods(Goods g) {
        this.type = g.getType();
        this.pricePerKg = g.getPricePerKg();
        this.level = g.getLevel();
        this.name = new String(g.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public GoodsType getType() {
        return type;
    }

    public void setType(GoodsType type) {
        this.type = type;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public void setPrice(int price) {
        this.pricePerKg = price;
    }

    public abstract String getWeightInfo();
    public abstract double calculatePrice();
}


enum GoodsType {
    CROP, ANIMAL, WOOD, MINERAL
}
