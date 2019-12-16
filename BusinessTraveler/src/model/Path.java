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
public class Path {
    
    private PathType type;
    private int baseMoveCost;
    private int weatherMoveCost;
    private BusinessPoint aPoint;
    private BusinessPoint bPoint;
    
    public Path(PathType tp, BusinessPoint a, BusinessPoint b, int cost){
        this(tp,a,b);
        this.baseMoveCost = cost;
    }
    public Path(PathType tp, BusinessPoint a, BusinessPoint b){
        this.aPoint = a;
        this.bPoint = b;
        this.type = type;
        this.weatherMoveCost = 0;
    }
}

enum PathType{
    DIRT,GRASS,ROCK,ROAD,
}