/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterface;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Yun_c
 */
public interface EnvironmentInfluencable {
    //public ArrayList<String> environmentList = new ArrayList<String>();
    
    public double calculateInfluence(EnvironmentInfluencable ev, Map<String, Double> influenceList);
    default public Set<String> getEnvironment(){return new HashSet<String>();};
    default public Set<String> getSpeciality(){return new HashSet<String>();};
    default public Object getOri(){return this;};
}
