/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import myinterface.TimeInfluencable;

/**
 *
 * @author Yun_c
 */
public class TimeHandler implements TimeInfluencable{
    private static ArrayList<TimeInfluencable> timeInfluencableData = new ArrayList<TimeInfluencable>();
    private TimeHandler hdl;
    public TimeHandler getInstance(){
        if (this.hdl == null) {
            synchronized(this) {
                this.hdl = new TimeHandler();
            }
        }
        return this.hdl;
    }
    public static void add(TimeInfluencable t){
        TimeHandler.timeInfluencableData.add(t);
    }
    public void timePassBy() {
       for(TimeInfluencable t : TimeHandler.timeInfluencableData){
           t.timePassBy();
       }
    }
    
}
