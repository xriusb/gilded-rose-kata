package com.gildedrose.item;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    public abstract void updateQuality();

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
