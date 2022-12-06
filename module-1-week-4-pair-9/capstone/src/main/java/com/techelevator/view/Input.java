package com.techelevator.view;

import java.util.Scanner;

public class Input
{
    private static Scanner input = new Scanner(System.in);

    public static String getInput()
    {
        String option = input.nextLine();
        return option;
    }
}
