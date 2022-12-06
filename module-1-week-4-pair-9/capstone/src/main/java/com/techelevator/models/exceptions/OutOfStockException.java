package com.techelevator.models.exceptions;

public class OutOfStockException extends Exception
{
    public OutOfStockException () {
        super("Sorry, that item is out of stock.");
    }
}
