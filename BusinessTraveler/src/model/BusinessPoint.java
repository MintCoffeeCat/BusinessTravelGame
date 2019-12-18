/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public abstract class BusinessPoint implements Subject {

    protected String name;
    protected Store store;
    protected Path path;
    
    public BusinessPoint(){}
    public BusinessPoint(String name, Store s) {
        this.name = name;
        this.store = s;
        this.path = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    private void generateEnvironment(StoreEnvironmentHandler env) {
        env.setStore(this.store);
        this.store = env;
    }
}



