/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterface;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import model.Environment.Environment;

/**
 *
 * @author Yun_c
 */
public interface EnvironmentInfluencable {
    
    public double calculateInfluence(EnvironmentInfluencable ev, Map<String, Double> influenceList);
    
    /**
     * This method is expected to called when environment applied to an 
     * EnvironmentInfluencable instance. And the aim of this function is to
     * stage some persistent changes to the instance.
     * 
     * Example: When Store being added an environment, the goods level of 
     * speciality that this environment could provide should be added by 1
     * If Store's max good level is 2, then if environment provide fruit, fruit
     * level would be 3.
     * 
     */
    default public void stageInfluence(Environment e){}
    
    /**
     * Get the name of environments this object have. If this is instance
     * of environment itself, just get its environment name.
     */
    default public Set<String> getEnvironment(){return new HashSet<String>();};
    
    /**
     * Get the speciality name in this environment.speciality is 
     * type of goods. Legal type of goods list is in GoodsType.java 
     * 
     */
    default public Set<String> getSpeciality(){return new HashSet<String>();};
    
    /**
     * Get the instance of Environment decorated.
     */
    default public Object getOri(){return this;};
}
