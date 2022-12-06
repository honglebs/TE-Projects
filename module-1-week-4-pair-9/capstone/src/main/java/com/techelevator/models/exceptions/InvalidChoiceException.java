package com.techelevator.models.exceptions;

public class InvalidChoiceException extends Exception
{
    public InvalidChoiceException() {
        super("Invalid choice, please try again.");
    }
}
