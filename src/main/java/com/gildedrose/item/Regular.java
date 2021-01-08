package com.gildedrose.item;

public class Regular extends Item {

    public Regular(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        if (quality > 0) {
            quality--;
            if (sellIn < 0) {
                quality--;
            }
        }
    }
}
