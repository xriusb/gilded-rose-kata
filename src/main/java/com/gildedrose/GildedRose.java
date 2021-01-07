package com.gildedrose;

import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.BackstagePasses;
import com.gildedrose.item.Item;
import com.gildedrose.item.Sulfuras;

import java.util.ArrayList;

import static com.gildedrose.item.AgedBrie.AGED_BRIE;
import static com.gildedrose.item.BackstagePasses.BACKSTAGE_PASSES;
import static com.gildedrose.item.Sulfuras.SULFURAS;

class GildedRose extends Store {

    public GildedRose() {
        items = new ArrayList<>();
    }

    @Override
    Item createItem(String name, int sellIn, int quality) {
        if (AGED_BRIE.equals(name)) {
            return new AgedBrie(sellIn, quality);
        }
        else if (SULFURAS.equals(name)) {
            return new Sulfuras(sellIn);
        }
        else if (BACKSTAGE_PASSES.equals(name)) {
            return new BackstagePasses(sellIn, quality);
        }
        else {
            return new Item(name, sellIn, quality);
        }
    }
}
