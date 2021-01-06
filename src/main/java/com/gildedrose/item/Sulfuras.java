package com.gildedrose.item;

public class Sulfuras extends Item {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn) {
        super(SULFURAS, sellIn, 80);
    }

    @Override
    public void updateQuality() {
        sellIn++;
    }
}
