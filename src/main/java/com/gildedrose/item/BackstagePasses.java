package com.gildedrose.item;

public class BackstagePasses extends Item {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(int sellIn, int quality) {
        this.name = BACKSTAGE_PASSES;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality++;

            if (sellIn < 11) {
                quality++;
            }
            if (sellIn < 6) {
                quality++;
            }
        }
        if (sellIn < 0) {
            quality = 0;
        }
    }
}
