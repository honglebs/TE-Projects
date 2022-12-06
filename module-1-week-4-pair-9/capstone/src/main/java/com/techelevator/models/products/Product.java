package com.techelevator.models.products;

import java.math.BigDecimal;

public abstract class Product
{
    private String name;
    private BigDecimal price;
    private String id;
    private int quantity = 5;
    private int soldQuantity = 0;

    public Product(String name, BigDecimal price, String id)
    {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getId()
    {
        return id;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getSoldQuantity()
    {
        return soldQuantity;
    }

    public int getRemainingQuantity()
    {
        return quantity - soldQuantity;
    }

    public void itemsSold()
    {
        soldQuantity++;
    }

    public abstract String toString();

}
