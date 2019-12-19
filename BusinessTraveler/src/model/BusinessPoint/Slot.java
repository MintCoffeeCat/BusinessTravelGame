/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BusinessPoint;

import model.Goods.Goods;

/**
 *
 * @author Yun_c
 */
public class Slot {
    
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
