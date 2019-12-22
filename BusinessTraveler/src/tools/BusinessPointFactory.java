/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Random;
import model.BusinessPoint.BusinessPoint;
import model.BusinessPoint.City;
import model.BusinessPoint.Town;
import model.BusinessPoint.Village;

/**
 *
 * @author Yun_c
 */
public class BusinessPointFactory {
    private static final String[] DEFAULT_NAMES = {
        "Stonegard","Westriver","Alam","Elior","Pristella",
        "Lifaus","Lugnica"
    };
    public BusinessPoint getBusinessPoint(int i){
        BusinessPoint bp = null;
        Random rd = new Random();
        int idx = rd.nextInt(BusinessPointFactory.DEFAULT_NAMES.length);
        String temp_name = BusinessPointFactory.DEFAULT_NAMES[idx];
        if(i == 1){
            bp = new Village(temp_name);
        }else if( i == 2){
            bp = new Town(temp_name);
        } else if(i == 3){
            bp = new City(temp_name);
        }
        return bp;
    }
    
    public BusinessPoint getBusinessPoint(int i, String name){
        BusinessPoint bp = this.getBusinessPoint(i);
        bp.setName(name);
        return bp;
    }
        public BusinessPoint getBusinessPoint(int i, String name, int x, int y){
        BusinessPoint bp = this.getBusinessPoint(i, name);
        bp.setX(x);
        bp.setY(y);
        return bp;
    }
    
}
