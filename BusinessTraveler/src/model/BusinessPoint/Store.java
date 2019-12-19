/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BusinessPoint;

import model.Goods.Goods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import model.Environment.Environment;
import myinterface.EnvironmentInfluencable;
import myinterface.Observer;
import myinterface.Subject;
import myinterface.Tradable;

/**
 *
 * @author Yun_c
 */
public class Store implements Tradable, Subject, EnvironmentInfluencable {

    private final int MAX_GOODS_NUM;
    private final int MAX_GOODS_LEVEL;
    private Map<String, Integer> additionalLevel;
    private ArrayList<Slot> slots;

    public Store() {
        this.MAX_GOODS_NUM = 0;
        this.MAX_GOODS_LEVEL = 0;
        this.additionalLevel = new HashMap<String, Integer>();
    }

    public Store(int max_num, int max_level) {
        this.MAX_GOODS_NUM = max_num;
        this.MAX_GOODS_LEVEL = max_level;
        this.additionalLevel = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getAdditionalLevel() {
        return additionalLevel;
    }

    public void stageInfluence(Environment e) {
        Set<String> envSpe = e.getSpeciality();
        envSpe.forEach((item) -> {
            Integer lv = this.additionalLevel.get(item);
            if (lv == null) {
                this.additionalLevel.put(item, 1);
            } else {
                this.additionalLevel.put(item, lv + 1);
            }
        });

    }

    public int getMAX_GOODS_NUM() {
        return MAX_GOODS_NUM;
    }

    public int getMAX_GOODS_LEVEL() {
        return MAX_GOODS_LEVEL;
    }

    public String toString() {
        return "store";
    }

    public void addGoods(Goods g, int num) {
        Integer addLv = this.additionalLevel.get(g.getType().getTypeName());
        if (addLv == null) {
            addLv = 0;
        }
        if (g.getLevel() > this.MAX_GOODS_LEVEL + addLv) {
            return;
        }
        if (num > this.MAX_GOODS_NUM) {
            num = this.MAX_GOODS_NUM;
        }
        if (!slots.contains(g)) {
            slots.add(new Slot(g, num));
            return;
        }

        for (Slot s : slots) {
            if (s.equals(g)) {
                if (s.getNum() > this.MAX_GOODS_NUM) {
                    return;
                }

                if (s.addNum(num) > this.MAX_GOODS_NUM) {
                    s.setNum(this.MAX_GOODS_NUM);
                }
                return;
            }
        }
    }

    @Override
    public double sell(Goods g, int num) {
        for (Slot s : slots) {
            if (s.equals(g)) {
                if (s.getNum() < num) {
                    return 0;
                }
                s.minusNum(num);
            }
        }
        return g.calculatePrice();
    }

    @Override
    public double buy(Goods g, int num) {
        this.addGoods(g, num);
        return (g.calculatePrice() * num);
    }

    @Override
    public double calculateInfluence(EnvironmentInfluencable ev, Map<String, Double> influenceList) {
        if (!(ev instanceof Goods)) {
            return 0;
        }
        Goods good = (Goods) (ev);
        String typeName = good.getType().getTypeName();
        return good.getPricePerKg() * influenceList.get(typeName);
    }
}

