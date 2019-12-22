/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yun_c
 */
public interface Subject {

    public Map<Integer, ArrayList<Observer>> observer = new HashMap<Integer, ArrayList<Observer>>();

    default public void attach(Observer o) {
        ArrayList arr = this.observer.get(this.hashCode());
        if (arr == null) {
            this.observer.put(this.hashCode(), new ArrayList<Observer>());
        }
        this.observer.get(this.hashCode()).add(o);
    }

    default public void detach(Observer o) {
        ArrayList arr = this.observer.get(this.hashCode());
        if(arr == null)return;
        
        this.observer.get(this.hashCode()).remove(o);
    }

    default public void notifyObserver() {
        ArrayList<Observer> arr = this.observer.get(this.hashCode());
        if(arr == null)return;
        
        for (Observer o : arr) {
            o.update(this);
        }
    }
}
