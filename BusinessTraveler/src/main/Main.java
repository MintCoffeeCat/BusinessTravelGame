/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import factory.BusinessPointFactory;
import javax.swing.JFrame;
import model.BusinessPoint.BusinessPoint;
import model.Environment.ForestEnvironment;
import model.Environment.PlainEnvironment;
import model.User.User;
import view.MainFrame;

/**
 *
 * @author Yun_c
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        MainFrame jf = new MainFrame();
        BusinessPointFactory bfct = new BusinessPointFactory();
        BusinessPoint bf = bfct.getBusinessPoint(1);
        User u = new User("Alice");
        u.setMax_energy(80);
        u.setEnergy(60);
        bf.generateEnvironment(new PlainEnvironment(new ForestEnvironment(bf.getStore())));
        u.attach(jf.getNowBusinessPoint());
        u.attach(jf.getDestinationPoint());
        u.attach(jf.getBasicInfoPanel());
        jf.setVisible(true);
        Thread.sleep(1000);
        u.changeTravelDestination(bf);
        Thread.sleep(1000);
        u.travel();
        
    }
}
