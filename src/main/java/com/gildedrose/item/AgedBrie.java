package com.gildedrose.item;

public class AgedBrie extends Item {

    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        this.name = AGED_BRIE;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality++;
        }
    }
}
