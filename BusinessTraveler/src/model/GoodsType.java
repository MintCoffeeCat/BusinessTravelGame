/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

class TypeNode {

    private int depth;
    private String typeName;
    private TypeNode father;

    public TypeNode(String name) {
        this.typeName = name;
        this.depth = 0;
        this.father = null;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public TypeNode getFather() {
        return father;
    }

    public void setFather(TypeNode father) {
        this.father = father;
    }

    public void link(TypeNode fth) {
        this.father = fth;
        this.depth = fth.getDepth() + 1;
    }
}
