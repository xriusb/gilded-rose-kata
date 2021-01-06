package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.BackstagePasses;
import com.gildedrose.item.Item;
import com.gildedrose.item.Sulfuras;
import org.junit.Test;

public class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final int BACK_STAGE_INITIAL_TEST_QUALITY = 5;

    @Test
    public void atEndOfEachDayEveryItemLowersBothValues() {
        Item[] items = new Item[] { new Item("foo", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void onceSellByDateIsPassed_qualityLowersTwiceFast() {
        Item[] items = new Item[] { new Item("foo", 0, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);

    }

    @Test
    public void itemsQualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void agedBrieIncreasesInQualityTheOlderItGets() {
        Item[] items = new Item[] { new AgedBrie(5, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void itemQualityNeverBiggerThan50() {
        Item[] items = new Item[] { new AgedBrie( 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfurasQualityIsAlwaysEightyAndNeverDecrease() {
        Item[] items = new Item[] { new Sulfuras( 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
    }


    @Test
    public void backStagePassesQualityIncreaseByOne_whenMoreThanTenDaysToExpire() {
        Item[] items = new Item[] { new BackstagePasses( 15, BACK_STAGE_INITIAL_TEST_QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(BACK_STAGE_INITIAL_TEST_QUALITY + 1, app.items[0].quality);
    }

    @Test
    public void backStagePassesQualityIncreaseByTwo_whenExpiresBetweenTenAndFive() {
        Item[] items = new Item[] { new BackstagePasses( 7, BACK_STAGE_INITIAL_TEST_QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(BACK_STAGE_INITIAL_TEST_QUALITY + 2, app.items[0].quality);
    }


    @Test
    public void backStagePassesQualityIncreaseByThree_whenExpiresFiveOrLess() {
        Item[] items = new Item[] { new BackstagePasses( 5, BACK_STAGE_INITIAL_TEST_QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(BACK_STAGE_INITIAL_TEST_QUALITY + 3, app.items[0].quality);
    }

    @Test
    public void backStagePassesIsZero_whenConcertIsDone() {
        Item[] items = new Item[] { new BackstagePasses( -1, BACK_STAGE_INITIAL_TEST_QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

}
