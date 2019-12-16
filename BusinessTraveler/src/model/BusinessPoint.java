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
public abstract class BusinessPoint {
    private final int MAX_GOODS_NUM;
    private final int MAX_GOODS_LEVEL;
    
    private Path path;
    public BusinessPoint(){
        MAX_GOODS_NUM = 0;
        MAX_GOODS_LEVEL = 0;
    }
}
