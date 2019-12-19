/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Goods;

/**
 *
 * @author Yun_c
 */
public class TypeNode {
    
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
