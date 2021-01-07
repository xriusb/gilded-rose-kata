package com.gildedrose;

import com.gildedrose.item.Item;

public abstract class Store {
    Item[] items;

    public void updateQuality() {
        for (Item item : items) {
            item.sellIn--;
            item.updateQuality();
        }
    }
}
