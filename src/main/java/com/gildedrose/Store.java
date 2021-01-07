package com.gildedrose;

import com.gildedrose.item.Item;

import java.util.Collection;

public abstract class Store {
    Collection<Item> items;

    public void addItem(String name, int sellIn, int quality) {
        items.add(createItem(name, sellIn, quality));
    }

    public void updateQuality() {
        items.forEach(item -> {
            item.sellIn--;
            item.updateQuality();
        });
    }

    abstract Item createItem(String name, int sellIn, int quality);
}
