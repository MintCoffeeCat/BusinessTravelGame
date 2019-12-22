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
        this.id = Path.NOW_ID;
        Path.NOW_ID += 1;
        this.type = tp;
        this.baseMoveCost = cost;
        this.aPoint = a;
        this.bPoint = b;
        this.stageInfluence(a.getWeather());
        this.stageInfluence(b.getWeather());
        this.color = Color.BLACK;
    }

    public Path(PathType tp, BusinessPoint a, BusinessPoint b) {
        this.id = Path.NOW_ID;
        Path.NOW_ID += 1;
        this.type = tp;
        this.weatherMoveCost = 0;
        this.aPoint = a;
        this.bPoint = b;
        this.stageInfluence(a.getWeather());
        this.stageInfluence(b.getWeather());
        this.color = Color.BLACK;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public int getBaseMoveCost() {
        return this.baseMoveCost;
    }

    public int getWeatherMoveCost() {
        return this.weatherMoveCost;
    }

    public int getTotalMoveCost() {
        int cost = this.baseMoveCost + this.weatherMoveCost;
        if(cost < 0)cost = 1;
        return cost;
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
        System.out.println("path " + this.getA().getName() + " to " + 
                this.getB().getName() + ": " + influence + "base :" + 
                this.baseMoveCost + " weather :" + this.weatherMoveCost + 
                " total :" + (this.baseMoveCost + this.weatherMoveCost) );
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

    public void checkColor() {
        if ((this.aPoint.getPi() == this.bPoint.getId()
                || this.bPoint.getPi() == this.aPoint.getId())
                && (this.aPoint.getPi() != -1 || this.bPoint.getPi() != -1)) {
            this.color = Color.GREEN;
        } else {
            this.color = Color.BLACK;
        }
    }

    public void setColor(Color c) {
        this.color = c;
    }
}
