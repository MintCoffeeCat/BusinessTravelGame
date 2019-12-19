/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BusinessPoint;

import model.BusinessPoint.BusinessPoint;
import model.Store;

/**
 *
 * @author Yun_c
 */
public class City extends BusinessPoint{
    public City(String name){
        this.name = name;
        this.store = new Store(200,3);
        this.pointLevel = "City";
    }
}