/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment;

import model.Goods.Goods;
import java.util.HashMap;
import myinterface.EnvironmentInfluencable;

/**
 *
 * @author Yun_c
 */
public class PlainEnvironment extends Environment {
    
    public PlainEnvironment() {
        super();
        this.init();
    }

    public PlainEnvironment(EnvironmentInfluencable s) {
        super(s);
        this.init();
    }

    public void init() {
        this.influence = new HashMap<String, Double>();
        this.influence.put("crop", 0.9);
        this.influence.put("Grain", 0.9);
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
        return "Plain";
    }
    
}
