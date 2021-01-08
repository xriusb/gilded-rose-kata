package com.gildedrose.item;

public class Conjured extends Item {

    private final Item item;

    public Conjured(Item item) {
        this.item = item;
        this.name = item.name;
        this.sellIn = item.sellIn;
        this.quality = item.quality;
    }

    @Override
    public void updateQuality() {
        item.updateQuality();
        item.updateQuality();
        this.quality = item.quality;
    }
}
