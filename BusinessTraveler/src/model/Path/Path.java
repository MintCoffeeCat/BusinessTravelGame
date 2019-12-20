/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Path;
import java.awt.Color;
import model.BusinessPoint.BusinessPoint;

/**
 *
 * @author Yun_c
 */
public class Path {

    public enum PathType {
        DIRT, GRASS, ROCK, ROAD,
    }
    private static int NOW_ID = 0;
    private final int id;
    private PathType type;
    private int baseMoveCost;
    private int weatherMoveCost;
    private BusinessPoint aPoint;
    private BusinessPoint bPoint;
    private Color color;

    public Path(PathType tp, BusinessPoint a, BusinessPoint b, int cost) {
        this(tp, a, b);
        this.baseMoveCost = cost;
    }

    public Path(PathType tp, BusinessPoint a, BusinessPoint b) {
        this.id = Path.NOW_ID;
        Path.NOW_ID += 1;
        this.aPoint = a;
        this.bPoint = b;
        this.type = type;
        this.weatherMoveCost = 0;
        this.color = Color.BLACK;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public int getBaseMoveCost() {
        return baseMoveCost;
    }
    
    public BusinessPoint getA(){
        return this.aPoint;
    }
    public BusinessPoint getB(){
        return this.bPoint;
    }
}
