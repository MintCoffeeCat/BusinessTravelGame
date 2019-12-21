/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import component.WorldMapPanel;
import factory.BusinessPointFactory;
import javax.swing.JFrame;
import model.BusinessPoint.BusinessPoint;
import model.Environment.Forest;
import model.Environment.Mountain;
import model.Environment.Plain;
import model.Path.Path;
import model.User.User;
import model.WorldMap.WorldMap;
import model.EnumType.EnumTypes.PathType;
import model.TimeHandler;
import view.MainFrame;

/**
 *
 * @author Yun_c
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        BusinessPointFactory bfct = new BusinessPointFactory();
        WorldMap wMap = WorldMap.getInstance();
        TimeHandler tHandler = TimeHandler.getInstance();

        BusinessPoint a = bfct.getBusinessPoint(1, "village A", 300, 300);
        BusinessPoint b = bfct.getBusinessPoint(1, "village B", 450, 530);
        BusinessPoint c = bfct.getBusinessPoint(2, "town C", 700, 200);
        BusinessPoint d = bfct.getBusinessPoint(2, "town D", 1000, 220);
        BusinessPoint e = bfct.getBusinessPoint(3, "city E", 520, 100);
        BusinessPoint f = bfct.getBusinessPoint(3, "city F", 680, 400);

        a.generateTopography(new Plain(new Mountain(a.getStore())));
        b.generateTopography(new Mountain(new Forest(b.getStore())));
        c.generateTopography(new Forest(c.getStore()));
        d.generateTopography(new Plain(d.getStore()));
        e.generateTopography(new Plain(new Forest(e.getStore())));
        f.generateTopography(new Mountain(f.getStore()));

        Path pab = new Path(PathType.DIRT, a, b, 10);
        Path pac = new Path(PathType.DIRT, a, c, 8);
        Path pbc = new Path(PathType.DIRT, b, c, 10);
        Path pcd = new Path(PathType.GRASS, c, d, 8);
        Path pde = new Path(PathType.ROAD, d, e, 6);
        Path pdf = new Path(PathType.ROAD, d, f, 6);

        wMap.addPoint(a);
        wMap.addPoint(b);
        wMap.addPoint(c);
        wMap.addPoint(d);
        wMap.addPoint(e);
        wMap.addPoint(f);
        wMap.addPath(pab);
        wMap.addPath(pac);
        wMap.addPath(pbc);
        wMap.addPath(pcd);
        wMap.addPath(pde);
        wMap.addPath(pdf);

        MainFrame jf = new MainFrame();

        User u = User.getInstance();
        u.setName("Alice");
        u.setMax_energy(80);
        u.setEnergy(60);

        jf.getWorldMapPanel().initWorldMap(wMap.getAllPoints(), wMap.getAllPaths());
        wMap.attach(jf.getNowBusinessPoint());
        wMap.attach(jf.getDestinationPoint());
        u.attach(jf.getBasicInfoPanel());
        tHandler.attach(jf.getBasicInfoPanel());
        wMap.setArrival(a);
        
        jf.setVisible(true);
//        Thread.sleep(1000);
//        u.changeTravelDestination(bf);
//        Thread.sleep(1000);
//        u.travel();

    }
}
