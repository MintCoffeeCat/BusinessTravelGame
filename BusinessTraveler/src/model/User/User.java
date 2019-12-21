/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.User;

import model.BusinessPoint.BusinessPoint;
import model.WorldMap.WorldMap;
import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public class User implements Subject {

    private String name;
    private int money;
    private int energy;
    private int max_energy;
//    private BusinessPoint arrive;
//    private BusinessPoint wantTo;

    private static class UserInner {

        private static User u = new User();
    }

    public static User getInstance() {
        return User.UserInner.u;
    }

    private User() {
        this.name = "";
//        this.arrive = null;
//        this.wantTo = null;
    }

    private User(String name) {
        this.name = name;
//        this.arrive = null;
//        this.wantTo = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMax_energy() {
        return max_energy;
    }

    public void setMax_energy(int max_energy) {
        this.max_energy = max_energy;
    }

    public BusinessPoint getArrive() {
        return WorldMap.getInstance().getNowArrive();
    }

    public void setArrive(BusinessPoint arrive) {
        WorldMap.getInstance().setArrival(arrive);
    }

    public BusinessPoint getWantTo() {
        return WorldMap.getInstance().getChosen();
    }

    public void setWantTo(BusinessPoint wantTo) {
        WorldMap.getInstance().setChosen(wantTo);
    }

    public void travel() {
        /*
        
        Here write the energy cost when Path is implemented
        
         */
        BusinessPoint dest = WorldMap.getInstance().getLocked();
        if(dest == null){
            dest = WorldMap.getInstance().getChosen();
        }
        WorldMap.getInstance().setArrival(dest);
        WorldMap.getInstance().setChosen(null);
        WorldMap.getInstance().setLocked(null);
        this.notifyObserver();
    }

}
