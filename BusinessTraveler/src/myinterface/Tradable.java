/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterface;

import model.Goods.Goods;

/**
 *
 * @author Yun_c
 */
public interface Tradable {
    public double sell(Goods g, int num);
    public double buy(Goods g, int num);
}
