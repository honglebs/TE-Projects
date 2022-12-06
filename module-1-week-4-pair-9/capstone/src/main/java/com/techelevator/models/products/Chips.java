package com.techelevator.models.products;

import java.math.BigDecimal;

public class Chips extends Product
{
    public Chips(String name, BigDecimal price, String id) {
        super(name, price, id);
    }

    @Override
    public String toString() {
        return "Crunch Crunch, Yum!";
    }
}
