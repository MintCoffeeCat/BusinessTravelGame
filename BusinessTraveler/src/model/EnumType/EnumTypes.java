/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.EnumType;

/**
 *
 * @author Yun_c
 */
public class EnumTypes {

    public enum TopographyType {
        PLAIN("Plain"), MOUNTAIN("Mountain"), FOREST("Forest");

        private String name;

        private TopographyType(String n) {
            this.name = n;
        }
    }
    
    public enum WeatherType{
        SUNNY("sunny",0),RAINY("rainy",2),HEAVY_RAINY("heavy rainy",3),
        SNOWY("snowy",4),CLOUDY("cloudy",1);
        
        private String name;
        private int alertLevel;
        
        private WeatherType(String n, int lv){
            this.name = n;
            this.alertLevel = lv;
        }
        public static WeatherType getWeatherByAlertLevel(int i){
            WeatherType[] wth = WeatherType.values();
            for(WeatherType w : wth){
                if(w.alertLevel == i){
                    return w;
                }
            }
            return SUNNY;
        }
        public int getAlertLevel(){
            return this.alertLevel;
        }
    }
    
    public enum GoodsType {
        CROP("crop", null), MINERAL("mineral", null), ANIMAL("animal", null),
        WOOD("wood", null), FRUIT("fruit", CROP), GRAIN("grain", CROP),
        STONE("stone",MINERAL), CRYSTAL("crystal",MINERAL);

        private String name;
        private GoodsType father;
        private int depth;

        private GoodsType(String n, GoodsType f) {
            this.name = n;
            this.father = f;
            if (f == null) {
                this.depth = 0;
            } else {
                this.depth = f.depth + 1;
            }
        }
    }

    public enum PathType {
        DIRT, GRASS, ROCK, ROAD,
    }
}
