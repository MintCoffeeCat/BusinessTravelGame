/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Goods;
import model.EnumType.EnumTypes.GoodsType;
import model.Goods.Goods;
import myinterface.TimeInfluencable;

/**
 *
 * @author Yun_c
 */
public abstract class Crop extends Goods implements TimeInfluencable{

    private boolean rot;
    private int rotTime;

    public int getRotTime() {
        return rotTime;
    }

    public Crop() {
    }

    public Crop(Crop c) {
        super(c);
        this.rotTime = c.getRotTime();
        this.rot = c.isRot();
    }

    public Crop(String name, int rotTime, int level) {
        super.setPrice(0);
        this.setName(name);
        this.setLevel(level);
        this.setType(GoodsType.CROP);
        this.rotTime = rotTime;
        this.rot = false;
    }

    public void timePassBy() {
        if (this.rotTime > 0) {
            this.rotTime -= 1;
            if (this.rotTime == 0) {
                this.rot = true;
            }
        }
    }

    public boolean isRot() {
        return this.rot;
    }

    @Override
    public void setPrice(int p) {
        if (this.rot) {
            return;
        }
        super.setPrice(p);
    }
}
