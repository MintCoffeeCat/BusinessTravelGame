/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Path;

import java.awt.Color;
import java.util.Map;
import model.BusinessPoint.BusinessPoint;
import model.EnumType.EnumTypes.PathType;
import model.Environment.Environment;
import model.Environment.Weather.Weather;
import myinterface.EnvironmentInfluencable;
import myinterface.Subject;
import myinterface.TimeInfluencable;

/**
 *
 * @author Yun_c
 */
public class Path implements Subject, TimeInfluencable, EnvironmentInfluencable<PathType, Weather<PathType>> {

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
        this.type = tp;
        this.weatherMoveCost = 0;
        this.aPoint = a;
        this.bPoint = b;
        a.setPath(this);
        b.setPath(this);
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

    public BusinessPoint getA() {
        return this.aPoint;
    }

    public BusinessPoint getB() {
        return this.bPoint;
    }

    public PathType getType() {
        return type;
    }

    @Override
    public void stageInfluence(Environment e) {
        if (!(e instanceof Weather)) {
            return;
        }
        Weather w = (Weather) e;
        Map<PathType, Double> res = w.calculateInfluence();
        Double influence = res.get(this.type);
        this.weatherMoveCost += influence;
    }

    @Override
    public Map<PathType, Double> calculateInfluence(Map<PathType, Double> influenceList) {
        return influenceList;
    }

    @Override
    public double superpositionSolution(Double a, Double b) {
        return a + b;
    }

    @Override
    public void timePassBy() {
        this.weatherMoveCost = 0;
        Weather a = this.aPoint.getWeather();
        Weather b = this.bPoint.getWeather();
        this.stageInfluence(a);
        this.stageInfluence(b);
        this.notifyObserver();
    }
}
