package com.gildedrose;

import com.gildedrose.item.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final int BACK_STAGE_INITIAL_TEST_QUALITY = 5;

    Store store;

    @Before
    public void setUp() {
        store = new GildedRose();
    }

    @Test
    public void atEndOfEachDayEveryItemLowersBothValues() {
        store.addItem("foo", 5, 5);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(4, result.sellIn);
        assertEquals(4, result.quality);
    }

    @Test
    public void onceSellByDateIsPassed_qualityLowersTwiceFast() {
        store.addItem("foo", 0, 5);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(-1, result.sellIn);
        assertEquals(3, result.quality);

    }

    @Test
    public void itemsQualityIsNeverNegative() {
        store.addItem("foo", 5, 0);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(0, result.quality);
    }

    @Test
    public void agedBrieIncreasesInQualityTheOlderItGets() {
        store.addItem(AGED_BRIE, 5, 5);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(4, result.sellIn);
        assertEquals(6, result.quality);
    }

    @Test
    public void itemQualityNeverBiggerThan50() {
        store.addItem(AGED_BRIE, 5, 50);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(50, result.quality);
    }

    @Test
    public void sulfurasQualityIsAlwaysEightyAndNeverDecrease() {
        store.addItem(SULFURAS, 5, 0);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(80, result.quality);
    }


    @Test
    public void backStagePassesQualityIncreaseByOne_whenMoreThanTenDaysToExpire() {
        store.addItem(BACKSTAGE_PASSES, 15, BACK_STAGE_INITIAL_TEST_QUALITY);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(BACK_STAGE_INITIAL_TEST_QUALITY + 1, result.quality);
    }

    @Test
    public void backStagePassesQualityIncreaseByTwo_whenExpiresBetweenTenAndFive() {
        store.addItem(BACKSTAGE_PASSES, 7, BACK_STAGE_INITIAL_TEST_QUALITY);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(BACK_STAGE_INITIAL_TEST_QUALITY + 2, result.quality);
    }


    @Test
    public void backStagePassesQualityIncreaseByThree_whenExpiresFiveOrLess() {
        store.addItem(BACKSTAGE_PASSES, 5, BACK_STAGE_INITIAL_TEST_QUALITY);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(BACK_STAGE_INITIAL_TEST_QUALITY + 3, result.quality);
    }

    @Test
    public void backStagePassesIsZero_whenConcertIsDone() {
        store.addItem(BACKSTAGE_PASSES, -1, BACK_STAGE_INITIAL_TEST_QUALITY);

        store.updateQuality();

        Item result = store.items.iterator().next();

        assertEquals(0, result.quality);
    }
}
