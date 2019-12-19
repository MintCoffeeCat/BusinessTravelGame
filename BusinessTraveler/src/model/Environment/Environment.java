/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Environment;

import model.Goods.TypeNode;
import model.Goods.Goods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import myinterface.EnvironmentInfluencable;
import myinterface.Tradable;

/**
 *
 * @author Yun_c
 */
public class Environment implements EnvironmentInfluencable {

    protected static final ArrayList<String> AVAILABLE_ENVIRONMENT = new ArrayList<String>() {
        {
            add("Plain");
            add("Mountain");
            add("Forest");
        }
    };
    protected EnvironmentInfluencable target;
    protected Map<String, Double> influence;

    public Environment(EnvironmentInfluencable t) {
        this.target = t;
        //this.store.addAdditionalLevel();
    }

    public Environment() {

    }

    public void setTarget(EnvironmentInfluencable ei) {
        this.target = ei;
    }

//    public int getAdditionalLevel() {
//        return this.store.getAdditionalLevel();
//    }
//
//    public void addAdditionalLevel() {
//        this.store.addAdditionalLevel();
//    }
//
//    public void setAdditionalLevel(int additionalLevel) {
//        this.store.setAdditionalLevel(additionalLevel);
//    }
//
//    public int getMAX_GOODS_NUM() {
//        return store.getMAX_GOODS_NUM();
//    }
//
//    public int getMAX_GOODS_LEVEL() {
//        return store.getMAX_GOODS_LEVEL();
//    }
//
//    public void addGoods(Goods g, int num) {
//        store.addGoods(g, num);
//    }
//
//    public double sell(Goods g, int num) {
//        return store.sell(g, num);
//    }
//
//    public double buy(Goods g, int num) {
//        return store.buy(g, num);
//    }
    public Set<String> getEnvironment() {
        Set<String> envs = new HashSet<String>();
        envs.add(this.toString());
        envs.addAll(this.target.getEnvironment());
        return envs;
    }
//    public void getEnvironment(ArrayList<String> envs) {
//        envs.add(this.toString());
//        this.target.getEnvironment(envs);
//    }

    public Set<String> getSpeciality() {
        Set<String> speciality = new HashSet<String>();
        speciality.addAll(this.influence.keySet());
        speciality.addAll(this.target.getSpeciality());
        return speciality;
    }

//    public void getSpeciality(Set<String> spe) {
//        Set<String> my_spe = this.priceAdjust.keySet();
//        if (my_spe != null) {
//            spe.addAll(my_spe);
//        }
//        this.target.getSpeciality(spe);
//    }
    public double calculateInfluence(EnvironmentInfluencable ev, Map<String, Double> influenceList) {
        this.influence.entrySet().forEach((item) -> {
            String inf_name = item.getKey();
            Double inf_value = item.getValue();
            Double ori_value = influenceList.get(inf_name);
            if (ori_value != null) {
                influenceList.put(inf_name, inf_value * ori_value);
            } else {
                influenceList.put(inf_name, inf_value);
            }
        });

        return this.target.calculateInfluence(ev, influenceList);
//        double final_factor = 1;
//        do {
//            Double factor = this.priceAdjust.get(tn.getTypeName());
//            if (factor != null) {
//                final_factor *= factor;
//            }
//        } while ((tn = tn.getFather()) != null);
//        return price * final_factor;
    }
    
    @Override
    public Object getOri(){
        return this.target.getOri();
    }
}
