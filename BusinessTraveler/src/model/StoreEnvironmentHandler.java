/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;
import myinterface.Tradable;

/**
 *
 * @author Yun_c
 */
public class StoreEnvironmentHandler extends Store {

    private Store store;
    protected Map<String, Double> priceAdjust;

    public StoreEnvironmentHandler(Store s) {
        this.store = s;
    }

    public StoreEnvironmentHandler() {

    }

    public void setStore(Store s) {
        this.store = s;
    }

    public int getAdditionalLevel() {
        return store.getAdditionalLevel();
    }

    public void setAdditionalLevel(int additionalLevel) {
        store.setAdditionalLevel(additionalLevel);
    }

    public int getMAX_GOODS_NUM() {
        return store.getMAX_GOODS_NUM();
    }

    public int getMAX_GOODS_LEVEL() {
        return store.getMAX_GOODS_LEVEL();
    }

    public void addGoods(Goods g, int num) {
        store.addGoods(g, num);
    }

    public double sell(Goods g, int num) {
        return store.sell(g, num);
    }

    public double buy(Goods g, int num) {
        return store.buy(g, num);
    }

    protected double calculateFinalPrice(double price, TypeNode tn) {
        double final_factor = 1;
        do {
            Double factor = this.priceAdjust.get(tn.getTypeName());
            if (factor != null) {
                final_factor *= factor;
            }
        } while ((tn = tn.getFather()) != null);
        return price * final_factor;
    }

}

class PlainEnvironment extends StoreEnvironmentHandler {

    public PlainEnvironment() {
        super();
        this.init();

    }

    public PlainEnvironment(Store s) {
        super(s);
        this.init();
    }

    public void init() {
        this.priceAdjust = new HashMap<String, Double>();
        this.priceAdjust.put("crop", 0.9);
        this.priceAdjust.put("Grain", 0.9);
        this.priceAdjust.put("fruit", 0.9);
    }

    public double sell(Goods g, int num) {
        double price = super.sell(g, num);
        return this.calculateFinalPrice(price, g.getType());
    }

    public double buy(Goods g, int num) {
        double price = super.buy(g, num);
        return this.calculateFinalPrice(price, g.getType());
    }
}

class MountainEnvironment extends StoreEnvironmentHandler {

    public MountainEnvironment(Store s) {
        super(s);
        this.init();
    }

    public MountainEnvironment() {
        super();
        this.init();

    }

    public void init() {
        this.priceAdjust = new HashMap<String, Double>();
        this.priceAdjust.put("mineral", 0.95);
        this.priceAdjust.put("stone", 0.8);
        this.priceAdjust.put("crystal", 0.9);
    }

    public double sell(Goods g, int num) {
        double price = super.sell(g, num);
        return this.calculateFinalPrice(price, g.getType());
    }

    public double buy(Goods g, int num) {
        double price = super.buy(g, num);
        return this.calculateFinalPrice(price, g.getType());
    }
}

class ForestEnvironment extends StoreEnvironmentHandler {

    public ForestEnvironment(Store s) {
        super(s);
        this.init();
    }
    public ForestEnvironment(){
        super();
        this.init();
    }
    public void init() {
        this.priceAdjust = new HashMap<String, Double>();
        this.priceAdjust.put("wood", 0.95);
        this.priceAdjust.put("fruit", 0.9);
    }

    public double sell(Goods g, int num) {
        double price = super.sell(g, num);
        return this.calculateFinalPrice(price, g.getType());
    }

    public double buy(Goods g, int num) {
        double price = super.buy(g, num);
        return this.calculateFinalPrice(price, g.getType());
    }
}
