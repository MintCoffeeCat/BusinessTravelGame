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
public abstract class Environment implements EnvironmentInfluencable {

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
        this.init();
        this.target.stageInfluence(this);
    }

    public Environment() {

    }
    public abstract void init();
    
    public void setTarget(EnvironmentInfluencable ei) {
        this.target = ei;
    }

    public Set<String> getEnvironment() {
        Set<String> envs = new HashSet<String>();
        envs.add(this.toString());
        envs.addAll(this.target.getEnvironment());
        return envs;
    }


    public Set<String> getSpeciality() {
        Set<String> speciality = new HashSet<String>();
        speciality.addAll(this.influence.keySet());
        speciality.addAll(this.target.getSpeciality());
        return speciality;
    }

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
    }
    
    @Override
    public Object getOri(){
        return this.target.getOri();
    }
}
