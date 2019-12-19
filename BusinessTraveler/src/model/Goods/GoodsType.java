/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yun_c
 */
public class GoodsType {

    private static Map<String, TypeNode> types;

    public GoodsType() {
        this.loadGoodsType();
    }

    public static void loadGoodsType() {
        ArrayList<TypeNode> n = new ArrayList<TypeNode>();
        TypeNode crop = new TypeNode("crop");
        TypeNode mineral = new TypeNode("mineral");
        TypeNode animal = new TypeNode("animal");
        TypeNode wood = new TypeNode("wood");
        TypeNode fruit = new TypeNode("fruit");
        TypeNode grain = new TypeNode("grain");
        fruit.link(crop);
        grain.link(crop);
        GoodsType.types = new HashMap<String, TypeNode>() {
            {
                put(crop.getTypeName(), crop);
                put(fruit.getTypeName(), fruit);
                put(grain.getTypeName(), grain);
            }
        };
    }

    public static TypeNode get(String nm) {
        return GoodsType.types.get(nm);
    }
}
