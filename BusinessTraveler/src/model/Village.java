/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Yun_c
 */
public class Village extends BusinessPoint {
    public Village(String name){
        this.name = name;
        this.store = new Store(30,1);
    }
}