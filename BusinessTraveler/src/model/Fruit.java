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
public class Fruit extends Crop {

    private double eatableWeight;
    private double pitWeight;

    public Fruit(String name, int rotTime, int level, double e_w, double p_w) {
        super(name, rotTime, level);
        this.eatableWeight = e_w;
        this.pitWeight = p_w;
    }

    public Fruit(String name, int rotTime, int level) {
        super(name, rotTime, level);
        this.eatableWeight = 0;
        this.pitWeight = 0;
    }

    public Fruit(Fruit f) {
        super(f);
        this.eatableWeight = f.getEatableWeight();
        this.pitWeight = f.getPitWeight();
    }

    public void setEatableWeight(double eatableWeight) {
        this.eatableWeight = eatableWeight;
    }

    public void setPitWeight(double pitWeight) {
        this.pitWeight = pitWeight;
    }

    public double getWeight() {
        return this.eatableWeight + this.pitWeight;
    }

    public double getEatableWeight() {
        return eatableWeight;
    }

    public double getPitWeight() {
        return pitWeight;
    }

    @Override
    public String getWeightInfo() {
        double total_weight = this.eatableWeight + this.pitWeight;
        StringBuilder sb = new StringBuilder();
        sb.append("weight: ")
                .append(total_weight)
                .append(" kg.\neatable: ")
                .append(this.eatableWeight)
                .append(" kg.\npit: ")
                .append(this.pitWeight);
        return sb.toString();
    }

    public double calculatePrice() {
        return (this.eatableWeight + this.pitWeight) * this.getPricePerKg();
    }
}