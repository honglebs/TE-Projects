package com.techelevator.models.products;

import java.math.BigDecimal;

public class Gum extends Product
{
    public Gum(String name, BigDecimal price, String id) {
        super(name, price, id);
    }

    @Override
    public String toString() {
        return "Chew Chew, Yum!";
    }

}
