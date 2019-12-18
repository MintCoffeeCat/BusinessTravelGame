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
public class ForestEnvironment extends StoreEnvironmentHandler {
    
    public ForestEnvironment(Store s) {
        super(s);
        this.init();
    }

    public ForestEnvironment() {
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

    public String toString() {
        return "Forest";
    }
    
}
