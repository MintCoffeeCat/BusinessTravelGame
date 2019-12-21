/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorldMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.BusinessPoint.BusinessPoint;
import model.Path.Path;
import myinterface.Subject;

/**
 *
 * @author Yun_c
 */
public class WorldMap implements Subject {

    private int chosenId;
    private int nowId;
    private int lockId;

    private Map<Integer, BusinessPoint> points;
    private Map<Integer, Path> paths;

    private static class WorldMapInner {

        private static WorldMap wMap = new WorldMap();
    }

    private WorldMap() {
        this.paths = new HashMap<Integer, Path>();
        this.points = new HashMap<Integer, BusinessPoint>();
        this.chosenId = -1;
        this.nowId = -1;
        this.lockId = -1;
    }

    public static WorldMap getInstance() {
        return WorldMap.WorldMapInner.wMap;
    }

    public void addPoint(BusinessPoint bp) {
        BusinessPoint temp = this.points.get(bp.getId());
        if (temp != null) {
            return;
        }
        this.points.put(bp.getId(), bp);
    }

    public void addPath(Path p) {
        Path temp = this.paths.get(p.getId());
        if (temp != null) {
            return;
        }
        BusinessPoint temp_a = this.points.get(p.getA().getId());
        BusinessPoint temp_b = this.points.get(p.getB().getId());

        if (temp_a == null || temp_b == null) {
            return;
        }

        this.paths.put(p.getId(), p);
    }

    public BusinessPoint[] getAllPoints() {
        return points.values().toArray(new BusinessPoint[this.points.size()]);
    }

    public Path[] getAllPaths() {
        return paths.values().toArray(new Path[this.paths.size()]);
    }

    public BusinessPoint getPoint(int id) {
        return points.get(id);
    }

    public BusinessPoint getChosen() {

        if (this.chosenId < 0) {
            return null;
        }
        return this.getPoint(this.chosenId);

    }

    public BusinessPoint getNowArrive() {
        if (this.nowId < 0) {
            return null;
        }
        return this.getPoint(this.nowId);
    }

    public BusinessPoint getLocked() {
        if (this.lockId < 0) {
            return null;
        }
        return this.getPoint(this.lockId);
    }

    public void setChosen(BusinessPoint bp) {
        if (bp != null && this.nowId != bp.getId()) {
            this.chosenId = bp.getId();
        }
        if (bp == null) {
            this.chosenId = -1;
        }
        this.notifyObserver();
    }

    public void setArrival(BusinessPoint bp) {
        if (bp == null) {
            return;
        }
        this.nowId = bp.getId();
        this.notifyObserver();
    }

    public void setLocked(BusinessPoint bp) {
        if (bp == null) {
            this.lockId = -1;
            this.notifyObserver();
            return;
        }
        this.lockId = bp.getId();
        this.notifyObserver();
    }

    public Path getPath(int id) {
        return paths.get(id);
    }
}
