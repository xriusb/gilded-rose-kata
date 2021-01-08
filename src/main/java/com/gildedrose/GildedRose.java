package com.gildedrose;

import com.gildedrose.item.*;

import java.util.ArrayList;

import static com.gildedrose.item.AgedBrie.AGED_BRIE;
import static com.gildedrose.item.BackstagePasses.BACKSTAGE_PASSES;
import static com.gildedrose.item.Sulfuras.SULFURAS;

class GildedRose extends Store {

    private static final String CONJURED = "Conjured";

    public GildedRose() {
        items = new ArrayList<>();
    }

    @Override
    Item createItem(String name, int sellIn, int quality) {
        Item item;
        if (AGED_BRIE.equals(name)) {
            item = new AgedBrie(sellIn, quality);
        }
        else if (SULFURAS.equals(name)) {
            item = new Sulfuras(sellIn);
        }
        else if (BACKSTAGE_PASSES.equals(name)) {
            item =  new BackstagePasses(sellIn, quality);
        }
        else {
            item = new Regular(name, sellIn, quality);
        }

        if (name.endsWith(CONJURED)) {
            item = new Conjured(item);
        }
        return item;
    }
}
