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
import view.MainFrame;


/**
 *
 * @author Yun_c
 */
public class Main {
    public static void main(String[] args) {
        MainFrame jf = new MainFrame();
        BusinessPointFactory bfct = new BusinessPointFactory();
        BusinessPoint bf = bfct.getBusinessPoint(1);
        bf.generateEnvironment(new PlainEnvironment(new ForestEnvironment(bf.getStore())));
        bf.attach(jf.getBusinessPointPanel());
        jf.setVisible(true);
        
    }
}
