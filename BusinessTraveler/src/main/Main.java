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
import model.Environment.ForestEnvironment;
import model.Environment.MountainEnvironment;
import model.Environment.PlainEnvironment;
import model.Path.Path;
import model.User.User;
import model.WorldMap.WorldMap;
import view.MainFrame;

/**
 *
 * @author Yun_c
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        MainFrame jf = new MainFrame();
        BusinessPointFactory bfct = new BusinessPointFactory();
        WorldMap wMap = WorldMap.getInstance();

        BusinessPoint a = bfct.getBusinessPoint(1, "village A");
        BusinessPoint b = bfct.getBusinessPoint(1, "village B");
        BusinessPoint c = bfct.getBusinessPoint(2, "town C");
        BusinessPoint d = bfct.getBusinessPoint(2, "town D");
        BusinessPoint e = bfct.getBusinessPoint(3, "city E");
        BusinessPoint f = bfct.getBusinessPoint(3, "city F");

        a.generateEnvironment(new PlainEnvironment(new ForestEnvironment(a.getStore())));
        b.generateEnvironment(new MountainEnvironment(new ForestEnvironment(b.getStore())));
        c.generateEnvironment(new ForestEnvironment(c.getStore()));
        d.generateEnvironment(new PlainEnvironment(d.getStore()));
        e.generateEnvironment(new PlainEnvironment(new ForestEnvironment(e.getStore())));
        f.generateEnvironment(new ForestEnvironment(f.getStore()));
        
        Path pab = new Path(Path.PathType.DIRT, a, b, 10);
        Path pac = new Path(Path.PathType.DIRT, a, c, 8);
        Path pbc = new Path(Path.PathType.DIRT, b, c, 10);
        Path pcd = new Path(Path.PathType.GRASS, c, d, 8);
        Path pde = new Path(Path.PathType.ROAD, c, d, 6);
        Path pdf = new Path(Path.PathType.ROAD, d, f, 6);

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
        jf.getWorldMapPanel().initWorldMap(wMap.getAllPoints(), wMap.getAllPaths());
        
        User u = User.getInstance();
        u.setName("Alice");
        u.setMax_energy(80);
        u.setEnergy(60);

        u.attach(jf.getNowBusinessPoint());
        u.attach(jf.getDestinationPoint());
        u.attach(jf.getBasicInfoPanel());
        
        jf.setVisible(true);
//        Thread.sleep(1000);
//        u.changeTravelDestination(bf);
//        Thread.sleep(1000);
//        u.travel();

    }
}
