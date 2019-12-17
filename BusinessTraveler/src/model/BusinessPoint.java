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
public  class BusinessPoint {
    private Store store;
    private Path path;

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
    public BusinessPoint(Store s){
        this.store = s;
        this.path = null;
    }
    
    private void generateEnvironment(StoreEnvironmentHandler env){
        env.setStore(this.store);
        this.store =env;
    }
    
    public static void main(String[] args) {
        BusinessPoint bsp = new BusinessPoint(new Store());
        bsp.generateEnvironment(new PlainEnvironment(new ForestEnvironment()));
    }
}
