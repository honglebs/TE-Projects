package com.techelevator.models.products;

import java.math.BigDecimal;

public class Drinks extends Product
{
    public Drinks(String name, BigDecimal price, String id) {
        super(name, price, id);
    }

    @Override
    public String toString() {
        return "Glug, Glug, Yum!";
    }


}
