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
import model.User.User;
import myinterface.Subject;
import myinterface.TimeInfluencable;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Yun_c
 */
public class WorldMap implements Subject, TimeInfluencable {

    private int chosenId;
    private int nowId;
    private int lockId;
    private int shortestCost;
    private Map<Integer, BusinessPoint> points;
    private Map<Integer, Path> paths;
    private final ReentrantReadWriteLock pointsLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock pathsLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock chosenlock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock lockLock = new ReentrantReadWriteLock();

    private static class WorldMapInner {

        private static WorldMap wMap = new WorldMap();
    }

    private WorldMap() {
        this.paths = new HashMap<Integer, Path>();
        this.points = new HashMap<Integer, BusinessPoint>();
        this.chosenId = -1;
        this.nowId = -1;
        this.lockId = -1;
        this.shortestCost = 0;
        this.addToTimeHandler();
    }

    public static WorldMap getInstance() {
        return WorldMap.WorldMapInner.wMap;
    }

    public void addPoint(BusinessPoint bp) {
        BusinessPoint temp = null;
        this.pointsLock.readLock().lock();
        try {
            temp = this.points.get(bp.getId());
        } finally {
            this.pointsLock.readLock().unlock();
        }
        if (temp != null) {
            return;
        }
        this.pointsLock.writeLock().lock();
        try {
            this.points.put(bp.getId(), bp);
        } finally {
            this.pointsLock.writeLock().unlock();
        }
    }

    public void addPath(Path p) {
        Path temp = null;
        BusinessPoint temp_a = null;
        BusinessPoint temp_b = null;
        this.pathsLock.readLock().lock();
        try {
            temp = this.paths.get(p.getId());
        } finally {
            this.pathsLock.readLock().unlock();
        }

        this.pointsLock.readLock().lock();
        try {
            temp_a = this.points.get(p.getA().getId());
            temp_b = this.points.get(p.getB().getId());
        } finally {
            this.pointsLock.readLock().unlock();
        }
        if (temp_a == null || temp_b == null) {
            return;
        }

        this.pathsLock.writeLock().lock();
        try {
            this.paths.put(p.getId(), p);
        } finally {
            this.pathsLock.writeLock().unlock();
        }

    }

    public BusinessPoint[] getAllPoints() {
        BusinessPoint[] bps = null;
        this.pointsLock.readLock().lock();
        try {
            bps = points.values().toArray(new BusinessPoint[this.points.size()]);
        } finally {
            this.pointsLock.readLock().unlock();
        }
        return bps;
    }

    public Path[] getAllPaths() {
        Path[] ps = null;
        this.pathsLock.readLock().lock();
        try {
            ps = paths.values().toArray(new Path[this.paths.size()]);
        } finally {
            this.pathsLock.readLock().unlock();
        }
        return ps;
    }

    public BusinessPoint getPoint(int id) {
        BusinessPoint bp = null;
        this.pointsLock.readLock().lock();
        try {
            bp = points.get(id);
        } finally {
            this.pointsLock.readLock().unlock();
        }
        return bp;
    }

    public BusinessPoint getChosen() {
        int id = -1;
        this.chosenlock.readLock().lock();
        try {
            id = this.chosenId;
        } finally {
            this.chosenlock.readLock().unlock();
            if (id < 0) {
                return null;
            }
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
        int id = -1;
        this.lockLock.readLock().lock();
        try {
            id = this.lockId;
        } finally {
            this.lockLock.readLock().unlock();
            if (id < 0) {
                return null;
            }
        }
        return this.getPoint(this.lockId);
    }

    public void setChosen(BusinessPoint bp) {
        this.chosenlock.writeLock().lock();
        try {
            if (bp != null && this.nowId != bp.getId()) {
                this.chosenId = bp.getId();
            }
            if (bp == null) {
                this.chosenId = -1;
            }
        } finally {
            this.chosenlock.writeLock().unlock();
        }
        int id = -1;
        this.lockLock.readLock().lock();
        try {
            id = this.lockId;
        } finally {
            this.lockLock.readLock().unlock();
            if (id == -1 && bp != null) {
                this.bellmanFord();
            }
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
            this.lockLock.writeLock().lock();
            this.lockId = -1;
            this.lockLock.writeLock().unlock();
            this.notifyObserver();
            return;
        }
        if (this.nowId == bp.getId()) {
            return;
        }
        this.lockLock.writeLock().lock();
        this.lockId = bp.getId();
        this.lockLock.writeLock().unlock();
        this.bellmanFord();
        this.notifyObserver();
    }

    public int getShortestCost() {
        return this.shortestCost;
    }

    public Path getPath(int id) {
        Path p = null;
        this.pathsLock.readLock().lock();
        try {
            p = paths.get(id);
        } finally {
            this.pathsLock.readLock().unlock();
        }
        return p;
    }

    public Path getPath(int aid, int bid) {
        Path pth = null;
        this.pathsLock.readLock().lock();
        try {
            for (Path p : this.paths.values()) {
                int aid_ = p.getA().getId();
                int bid_ = p.getB().getId();
                if ((aid == aid_ && bid == bid_) || (aid == bid_ && bid == aid_)) {
                    pth = p;
                    break;
                }
            }
        } finally {
            this.pathsLock.readLock().unlock();
        }
        return pth;
    }

    @Override
    public void timePassBy() {
        this.pointsLock.readLock().lock();
        try {
            for (BusinessPoint bp : this.points.values()) {
                bp.timePassBy();
            }
        } finally {
            this.pointsLock.readLock().unlock();
        }
        this.pathsLock.readLock().lock();
        try {
            for (Path p : this.paths.values()) {
                p.timePassBy();
            }
        } finally {
            this.pathsLock.readLock().unlock();
        }

        this.bellmanFord();
        this.notifyObserver();
    }

    public void clearAllPathColor() {
        this.pathsLock.writeLock().lock();
        for (Path p : this.paths.values()) {
            p.setColor(Color.BLACK);
        }
        this.pathsLock.writeLock().lock();
        this.notifyObserver();
    }

    private void initBellmanFord(BusinessPoint s) {
        this.clearAllPathColor();
        this.pointsLock.writeLock().lock();
        for (BusinessPoint bp : this.points.values()) {
            bp.setD((long) Integer.MAX_VALUE);
            bp.setPi(-1);
        }
        s.setD(0L);
        this.pointsLock.writeLock().unlock();
    }

    private void relax(BusinessPoint u, BusinessPoint v, int w) {

        if (v.getD() > u.getD() + w) {
            v.setD(u.getD() + w);
            v.setPi(this.getPath(u.getId(), v.getId()).getId());

        }
    }

    public void bellmanFord() {
        this.initBellmanFord(this.getNowArrive());
        this.pointsLock.writeLock().lock();
        for (int i = 0; i < this.points.size() - 1; i++) {
            System.out.println(i);
            this.pathsLock.readLock().lock();
            for (Path p : this.paths.values()) {
                this.relax(p.getA(), p.getB(), p.getTotalMoveCost());
                this.relax(p.getB(), p.getA(), p.getTotalMoveCost());
            }
            this.pathsLock.readLock().unlock();
        }
        this.lockLock.readLock().lock();
        BusinessPoint bp = this.getLocked();
        this.lockLock.readLock().unlock();
        
        if (bp == null) {
            bp = this.getChosen();
        }
        this.shortestCost = (int) bp.getD();
        while (true) {
            int pid = bp.getPi();
            if (pid == -1) {
                break;
            }
            Path p = this.getPath(bp.getPi());
            if (bp.getD() > User.getInstance().getEnergy()) {
                p.setColor(Color.RED);
            } else {
                p.setColor(Color.GREEN);
            }

            bp = p.getA().getId() == bp.getId() ? p.getB() : p.getA();
        }
        this.pointsLock.writeLock().unlock();
    }
}
