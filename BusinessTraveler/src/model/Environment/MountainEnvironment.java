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
public class MountainEnvironment extends Environment {
    
    public MountainEnvironment(Store s) {
        super(s);
        this.init();
    }

    public MountainEnvironment() {
        super();
        this.init();
    }

    public void init() {
        this.influence = new HashMap<String, Double>();
        this.influence.put("mineral", 0.95);
        this.influence.put("stone", 0.8);
        this.influence.put("crystal", 0.9);
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
        return "Mountain";
    }
    
}
