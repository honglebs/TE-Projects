package com.techelevator;

import com.techelevator.file_io.InventoryLoader;
import com.techelevator.models.products.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class InventoryLoaderTest
{
    @Test
    public void stockInventory_should_return_map_of_all_products_in_csv()
    {
        //Arrange
        LinkedHashMap<String, Product> expected = new LinkedHashMap<>();
        expected.put("A1", new Chips("Potato Crisps", new BigDecimal("3.05"), "A1"));
        expected.put("A2", new Chips("Stackers", new BigDecimal("1.45"), "A2"));
        expected.put("A3", new Chips("Grain Waves", new BigDecimal("2.75"), "A3"));
        expected.put("A4", new Chips("Cloud Popcorn", new BigDecimal("3.65"), "A4"));

        expected.put("B1", new Candy("Moonpie", new BigDecimal("1.8"), "B1"));
        expected.put("B2", new Candy("Cowtales", new BigDecimal("1.5"), "B2"));
        expected.put("B3", new Candy("Wonka Bar", new BigDecimal("1.5"), "B3"));
        expected.put("B4", new Candy("Crunchie", new BigDecimal("1.75"), "B4"));

        expected.put("C1", new Drinks("Cola", new BigDecimal("1.25"), "C1"));
        expected.put("C2", new Drinks("Dr. Salt", new BigDecimal("1.5"), "C2"));
        expected.put("C3", new Drinks("Mountain Melter", new BigDecimal("1.5"), "C3"));
        expected.put("C4", new Drinks("Heavy", new BigDecimal("1.5"), "C4"));

        expected.put("D1", new Gum("U-Chews", new BigDecimal("0.85"), "D1"));
        expected.put("D2", new Gum("Little League Chew", new BigDecimal("0.95"), "D2"));
        expected.put("D3", new Gum("Chiclets", new BigDecimal("0.75"), "D3"));
        expected.put("D4", new Gum("Triplemint", new BigDecimal("0.75"), "D4"));

        Set<String> keySetExpected = expected.keySet();

        //Act
        LinkedHashMap<String, Product> actual = InventoryLoader.stockInventory();
        Set<String> keySetActual = actual.keySet();

        //Assert
        Assert.assertEquals("stockInventory should create new hash map with proper values", keySetExpected, keySetActual);

    }
}
