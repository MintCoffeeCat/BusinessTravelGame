/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Yun_c
 */
public class MountainEnvironment extends StoreEnvironmentHandler {
    
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

    public String toString() {
        return "Mountain";
    }
    
}
