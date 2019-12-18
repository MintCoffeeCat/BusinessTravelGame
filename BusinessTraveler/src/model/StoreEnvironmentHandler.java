/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import myinterface.Tradable;

/**
 *
 * @author Yun_c
 */
public class StoreEnvironmentHandler extends Store {

    protected static final ArrayList<String> environmentList = new ArrayList<String>() {
        {
            add("Plain");
            add("Mountain");
            add("Forest");
        }
    };
    private Store store;
    protected Map<String, Double> priceAdjust;

    public StoreEnvironmentHandler(Store s) {
        this.store = s;
        this.store.addAdditionalLevel();
    }

    public StoreEnvironmentHandler() {

    }

    public void setStore(Store s) {
        this.store = s;
    }

    public int getAdditionalLevel() {
        return this.store.getAdditionalLevel();
    }

    public void addAdditionalLevel() {
        this.store.addAdditionalLevel();
    }

    public void setAdditionalLevel(int additionalLevel) {
        this.store.setAdditionalLevel(additionalLevel);
    }

    public int getMAX_GOODS_NUM() {
        return store.getMAX_GOODS_NUM();
    }

    public int getMAX_GOODS_LEVEL() {
        return store.getMAX_GOODS_LEVEL();
    }

    public void addGoods(Goods g, int num) {
        store.addGoods(g, num);
    }

    public double sell(Goods g, int num) {
        return store.sell(g, num);
    }

    public double buy(Goods g, int num) {
        return store.buy(g, num);
    }
    public String[] getEnvironment(){
        ArrayList<String> envs = new ArrayList<String>();
        this.getEnvironment(envs);
        String[] result = new String[envs.size()];
        return (String[])envs.toArray(result);
    }
    public void getEnvironment(ArrayList<String> envs) {
        envs.add(this.toString());
        this.store.getEnvironment(envs);
    }
    public String[] getSpeciality() {
        Set<String> speciality = new HashSet<String>();
        this.getSpeciality(speciality);
        String[] result = new String[speciality.size()];
        return (String[])speciality.toArray(result);
    }

    public void getSpeciality(Set<String> spe) {
        Set<String> my_spe = this.priceAdjust.keySet();
        if (my_spe != null) {
            spe.addAll(my_spe);
        }
        this.store.getSpeciality(spe);
    }
    protected double calculateFinalPrice(double price, TypeNode tn) {
        double final_factor = 1;
        do {
            Double factor = this.priceAdjust.get(tn.getTypeName());
            if (factor != null) {
                final_factor *= factor;
            }
        } while ((tn = tn.getFather()) != null);
        return price * final_factor;

    }

}



