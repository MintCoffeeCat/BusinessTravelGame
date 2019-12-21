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
        SUNNY("sunny"),RAINY("rainy"),HEAVY_RAINY("heavy rainy"),
        SNOWY("snowy");
        
        private String name;
        
        private WeatherType(String n){
            this.name = n;
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
