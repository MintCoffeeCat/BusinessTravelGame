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
import model.EnumType.Couple;
import model.EnumType.EnumTypes.TopographyType;
import myinterface.EnvironmentInfluencable;
import myinterface.Tradable;

/**
 * K is the type of object this environment would influence. E is the
 * environment type, such as Topography or Weather.
 *
 * @author Yun_c
 */
public abstract class Environment<K, E> implements EnvironmentInfluencable<K, E> {

    protected EnvironmentInfluencable target = null;
    protected Map<K, Double> influence = null;

    public Environment(EnvironmentInfluencable t) {
        this.target = t;
        this.init();
    }

    public Environment() {
        this.init();
    }

    public abstract void init();

    public abstract E getEnvironmentType();

    public void addInfluence(Couple<K, Double>... et) {
        if (this.influence == null) {
            this.influence = new HashMap<K, Double>();
        }
        for (Couple<K, Double> c : et) {
            this.influence.put(c.getKey(), c.getValue());
        }
    }

    public void setTarget(EnvironmentInfluencable ei) {
        Environment temp = this;
        while (temp.target instanceof Environment) {
            temp = (Environment) temp.target;
        }
        temp.target = ei;
        temp.target.stageInfluence(this);
    }

    public Set<E> getEnvironment() {
        Set<E> envs = new HashSet<E>();
        envs.add(this.getEnvironmentType());
        envs.addAll(this.target.getEnvironment());
        return envs;
    }

    public Set<K> getSpeciality() {
        Set<K> speciality = new HashSet<K>();
        speciality.addAll(this.influence.keySet());
        speciality.addAll(this.target.getSpeciality());
        return speciality;
    }

    @Override
    public Map<K, Double> calculateInfluence() {
        Map<K, Double> influenceList = new HashMap<>();
        return this.calculateInfluence(influenceList);
    }

    @Override
    public Map<K, Double> calculateInfluence(Map<K, Double> influenceList) {
        this.influence.entrySet().forEach((item) -> {
            K inf_type = item.getKey();
            Double inf_value = item.getValue();
            Double ori_value = influenceList.get(inf_type);
            if (ori_value != null) {
                influenceList.put(inf_type, inf_value * ori_value);
            } else {
                influenceList.put(inf_type, inf_value);
            }
        });
        return this.target.calculateInfluence(influenceList);
    }

    @Override
    public Object getOri() {
        if(this.target == null)return this;
        return this.target.getOri();
    }
}
