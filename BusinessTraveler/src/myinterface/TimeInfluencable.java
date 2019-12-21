/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterface;

import java.util.ArrayList;
import model.TimeHandler;

/**
 *
 * @author Yun_c
 */
public interface TimeInfluencable {
    
    public abstract void timePassBy();

    default public void addToTimeHandler() {
        TimeHandler.getInstance().add(this);
    }
}
