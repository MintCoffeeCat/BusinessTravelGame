/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment;

import model.Goods.Goods;
import java.util.HashMap;
import model.Store;

/**
 *
 * @author Yun_c
 */
public class ForestEnvironment extends Environment {
    
    public ForestEnvironment(Store s) {
        super(s);
        this.init();
    }

    public ForestEnvironment() {
        super();
        this.init();
    }

    public void init() {
        this.influence = new HashMap<String, Double>();
        this.influence.put("wood", 0.95);
        this.influence.put("fruit", 0.9);
    }

//    public double sell(Goods g, int num) {
//        double price = super.sell(g, num);
//        return this.calculateFinalPrice(price, g.getType());
//    }
//
//    public double buy(Goods g, int num) {
//        double price = super.buy(g, num);
//        return this.calculateFinalPrice(price, g.getType());
//    }

    public String toString() {
        return "Forest";
    }
    
}
