package com.techelevator.models.exceptions;

public class InsufficientFundsException extends Exception
{
    public InsufficientFundsException() {
        super("Insufficient funds. Please add more money.");
    }
}
