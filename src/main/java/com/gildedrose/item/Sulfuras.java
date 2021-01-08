package com.gildedrose.item;

public class Sulfuras extends Item {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn) {
        this.name = SULFURAS;
        this.sellIn = sellIn;
        this.quality = 80;
    }

    @Override
    public void updateQuality() {
        sellIn++;
    }
}
