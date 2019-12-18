/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterface;

import java.util.ArrayList;

/**
 *
 * @author Yun_c
 */
public interface Subject {
    public ArrayList<Observer> observer = new ArrayList<Observer>();
    
    default public void attach(Observer o){
        this.observer.add(o);
    }
    default public void detach(Observer o){
        this.observer.remove(o);
    }
    default public void notifyObserver(){
        for(Observer o : this.observer){
            o.update(this);
        }
    }
}
