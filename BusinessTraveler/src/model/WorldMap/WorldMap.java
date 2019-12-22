/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.WorldMap;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.BusinessPoint.BusinessPoint;
import model.Path.Path;
import myinterface.Subject;
import myinterface.TimeInfluencable;

/**
 *
 * @author Yun_c
 */
public class WorldMap implements Subject, TimeInfluencable {

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
        this.addToTimeHandler();
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
        if (this.lockId == -1 && bp != null) {
            this.bellmanFord();
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
        if (this.nowId == bp.getId()) {
            return;
        }
        this.lockId = bp.getId();
        this.bellmanFord();
        this.notifyObserver();
    }

    public Path getPath(int id) {
        return paths.get(id);
    }

    public Path getPath(int aid, int bid) {
        for (Path p : this.paths.values()) {
            int aid_ = p.getA().getId();
            int bid_ = p.getB().getId();
            if ((aid == aid_ && bid == bid_) || (aid == bid_ && bid == aid_)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Path> getShortestPath() {
        ArrayList<Path> arr = new ArrayList<>();

        BusinessPoint now = this.getNowArrive();
        BusinessPoint dest = this.getLocked();
        if (dest == null) {
            dest = this.getChosen();
        }
        if (dest == null) {
            return null;
        }
        while (true) {
        }

    }

    @Override
    public void timePassBy() {
        for (BusinessPoint bp : this.points.values()) {
            bp.timePassBy();
        }
        for (Path p : this.paths.values()) {
            p.timePassBy();
        }
        this.notifyObserver();
    }

    public void clearAllPathColor() {
        for (Path p : this.paths.values()) {
            p.setColor(Color.BLACK);
        }
        this.notifyObserver();
    }

    private void initBellmanFord(BusinessPoint s) {
        this.clearAllPathColor();
        for (BusinessPoint bp : this.points.values()) {
            bp.setD((long) Integer.MAX_VALUE);
            bp.setPi(-1);
        }
        s.setD(0L);
    }

    private void relax(BusinessPoint u, BusinessPoint v, int w) {
        if (v.getD() > u.getD() + w) {
            v.setD(u.getD() + w);
            v.setPi(this.getPath(u.getId(), v.getId()).getId());
        }
    }

    public void bellmanFord() {
        this.initBellmanFord(this.getNowArrive());
        for (int i = 0; i < this.points.size() - 1; i++) {
            System.out.println(i);
            for (Path p : this.paths.values()) {
                this.relax(p.getA(), p.getB(), p.getTotalMoveCost());
                this.relax(p.getB(), p.getA(), p.getTotalMoveCost());
            }
        }
        BusinessPoint bp = this.getLocked();
        System.out.println("lock:" + bp);
        if (bp == null) {
            bp = this.getChosen();
            System.out.println("chosen:" + bp);
        }
        while (true) {
            int pid = bp.getPi();
            if (pid == -1) {
                return;
            }
            Path p = this.getPath(bp.getPi());
            p.setColor(Color.GREEN);
            bp = p.getA().getId() == bp.getId() ? p.getB() : p.getA();
        }
    }
}
