/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import myinterface.Observer;
import myinterface.Subject;
import myinterface.TimeInfluencable;

/**
 *
 * @author Yun_c
 */
public class TimeHandler implements TimeInfluencable, Subject {

    private ArrayList<TimeInfluencable> timeInfluencableData = new ArrayList<TimeInfluencable>();
    private int days = 1;

    private static class TimeInner {

        private static TimeHandler t = new TimeHandler();
    }

    public static TimeHandler getInstance() {
        return TimeHandler.TimeInner.t;
    }

    public int getDays() {
        return days;
    }

    public void add(TimeInfluencable t) {
        this.timeInfluencableData.add(t);
    }

    public void timePassBy() {
        this.days += 1;
        for (TimeInfluencable t : this.timeInfluencableData) {
            t.timePassBy();
        }
        this.notifyObserver();
    }

}
