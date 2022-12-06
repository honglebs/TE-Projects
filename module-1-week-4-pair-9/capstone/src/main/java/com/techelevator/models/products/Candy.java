package com.techelevator.models.products;

import java.math.BigDecimal;

public class Candy extends Product
{
    public Candy(String name, BigDecimal price, String id) {
        super(name, price, id);
    }

    @Override
    public String toString() {
        return "Munch Munch, Yum!";
    }
}
