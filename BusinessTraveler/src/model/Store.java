/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import myinterface.Subject;
import myinterface.Tradable;

/**
 *
 * @author Yun_c
 */
public class Store implements Tradable, Subject {

    private final int MAX_GOODS_NUM;
    private final int MAX_GOODS_LEVEL;
    private int additionalLevel;
    private ArrayList<Slot> slots;

    public int getAdditionalLevel() {
        return additionalLevel;
    }

    public void setAdditionalLevel(int additionalLevel) {
        this.additionalLevel = additionalLevel;
    }

    public int getMAX_GOODS_NUM() {
        return MAX_GOODS_NUM;
    }

    public int getMAX_GOODS_LEVEL() {
        return MAX_GOODS_LEVEL;
    }

    public Store() {
        this.MAX_GOODS_NUM = 0;
        this.MAX_GOODS_LEVEL = 0;
        this.additionalLevel = 0;
    }

    public Store(int max_num, int max_level) {
        this.MAX_GOODS_NUM = max_num;
        this.MAX_GOODS_LEVEL = max_level;
        this.additionalLevel = 0;
    }

    public void addGoods(Goods g, int num) {
        if (g.getLevel() > this.MAX_GOODS_LEVEL) {
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

}

class Slot {

    private Goods good;
    private int num;

    public Slot(Goods good, int num) {
        this.good = good;
        this.num = num;
    }

    public int addNum(int n) {
        this.num += n;
        return this.num;
    }

    public int minusNum(int n) {
        this.num -= n;
        if (this.num < 0) {
            this.num = 0;
        }
        return this.num;
    }

    public int setNum(int n) {
        this.num = n;
        return this.num;
    }

    public int getNum() {
        return this.num;
    }

    public boolean equals(Object o) {
        return good.equals(o);
    }
}
