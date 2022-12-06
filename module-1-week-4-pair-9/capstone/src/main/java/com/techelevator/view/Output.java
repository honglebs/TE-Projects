package com.techelevator.view;

import com.techelevator.models.products.Product;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Output
{
    public static void printWelcomeScreen()
    {

        System.out.println(Colors.BLUE);
        System.out.println("-------------------------------------");
        System.out.println("           Vending Machine"           );
        System.out.println("                 v1.0"                );
        System.out.println("-------------------------------------");


        System.out.println(Colors.PURPLE);
        System.out.print("　　　|　　|┌─────────────┐|\n" );
        System.out.print("　　　|　　|│![] [] [] [] │|\n" );
        System.out.print("     |　　|::l三三三三三!. │|\n" );
        System.out.print("　　　|　　|│![] [] [] [] │|\n" );
        System.out.print("     |　　|::l三三三三三!. │|\n" );
        System.out.print("　　　|　　|│![] [] [] [] │|\n" );
        System.out.print("     |　　|::l三三三三三!. │|\n" );
        System.out.print("　　　|　　|│![] [] [] [] │|\n" );
        System.out.print("　　　|　　|::l三三三三三!. ||\n" );
        System.out.print("　　　|　　|┌─────────────┐|　ｺﾞｿｺﾞｿ　　lヽ,,lヽ\n" );
        System.out.print("　　　|　　|│＿＿＿＿＿＿＿/\\,,|\\　　　  (　   ）　やめて！\n" );
        System.out.print("　　  {二二}￣￣￣￣￣￣￣⊂<　　⌒ヽ　　　  と　  i\n" );
        System.out.print("　　　　　　　　　　        ∪(＿つ つ　　　　しーJ");
        System.out.println();
        System.out.println(Colors.YELLOW);
        System.out.print("Press enter to start " + Emojis.CANDY + " ");
    }

    public static void printHomeScreen()
    {
        System.out.print(Console.CLEAR_SCREEN);
        System.out.println(Colors.BLUE);
        System.out.println("=====================================");
        System.out.println("Vending Machine v1.0");
        System.out.println("=====================================");
        System.out.println(Colors.WHITE);
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit ");
    }

    public static void printItems(LinkedHashMap<String, Product> currentInventory)
    {
        System.out.print(Console.CLEAR_SCREEN);
        System.out.println(Colors.CYAN);
        System.out.println("=====================================");
        System.out.println();
        for (Product product : currentInventory.values())
        {
            System.out.println(product.getId() + " | " + product.getName() + " | " + product.getPrice() + " | " + product.getRemainingQuantity());
        }
        System.out.println();
        System.out.println("=====================================");
        System.out.println(Colors.WHITE);
        System.out.println("(3) Go back");
    }

    public static void printPurchaseScreen(BigDecimal moneyProvided)
    {
        System.out.println(Console.CLEAR_SCREEN + Colors.CYAN);
        System.out.println("=====================================");
        System.out.println();
        System.out.println(Colors.YELLOW + "Current Money Provided $" + moneyProvided + " " + Colors.GREEN + Emojis.MONEY_WITH_WINGS);
        System.out.println(Colors.WHITE);
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
    }


    public static void printFeedMoneyScreen(BigDecimal moneyProvided)
    {
        System.out.println(Console.CLEAR_SCREEN + Colors.CYAN);
        System.out.println("=====================================");
        System.out.println();
        System.out.println(Colors.YELLOW + "Current Money Provided $" + moneyProvided + " " + Colors.GREEN + Emojis.MONEY_WITH_WINGS);

        System.out.println(Colors.GREEN);
        System.out.print("____________________________________\n");
        System.out.print("|#######====================########|\n");
        System.out.print("|#(1)*UNITED STATES OF AMERICA*(1)# |\n");
        System.out.print("|#**          /===\\   ********   **#|\n");
        System.out.print("|*# {G}      | (\") |              #*|\n");
        System.out.print("|#*  ******  | /v\\ |    O N E     *#|\n");
        System.out.print("|#(1)         \\===/             (1)#|\n");
        System.out.print("|##=========ONE DOLLAR============##|\n");
        System.out.print("-------------------------------------\n");
        System.out.println(Colors.WHITE);
        System.out.print("How much money do you want to put in? $");
    }

    public static void printSelectProductScreen()
    {
        System.out.println(Console.CLEAR_SCREEN);
        System.out.print(Colors.GREEN);
        System.out.print("-------------------------------------\n");
        System.out.print("|   A1   |   A2   |   A3   |   A4   |\n");
        System.out.print("| $3.05  | $1.45  | $2.75  |  $3.65 |\n");
        System.out.print("-------------------------------------\n");
        System.out.print("|   B1   |   B2   |   B3   |   B4   |\n");
        System.out.print("| $1.80  | $1.50  | $1.50  |  $1.75 |\n");
        System.out.print("-------------------------------------\n");
        System.out.print("|   C1   |   C2   |   C3   |   C4   |\n");
        System.out.print("| $1.25  | $1.50  | $1.50  |  $1.50 |\n");
        System.out.print("-------------------------------------\n");
        System.out.print("|   D1   |   D2   |   D3   |   D4   |\n");
        System.out.print("| $0.85  | $0.95  | $0.75  |  $0.75 |\n");
        System.out.print("-------------------------------------");
        System.out.println();
        System.out.println(Colors.WHITE);
        System.out.print("Please enter the id for the product you would like: ");
    }

    public static void printChange(BigDecimal amount, String change)
    {
        System.out.println(Console.CLEAR_SCREEN);
        System.out.print(Colors.YELLOW);
        System.out.print("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n");
        System.out.print("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡛⠉⢸⣿⣿⣿⣿\n");
        System.out.print("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠇⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣴⣿⣿⣿⣿⣿\n");
        System.out.print("⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣷⡄⢠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿\n");
        System.out.print("⣿⣿⣿⣦⢀⣹⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⢿⣿⣿⣿⣿⣿⣟⣀⢠⣾⣿⣿⣿⣿\n");
        System.out.print("⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⣿⣿⠻⢦⣤⣤⡾⠿⠿⠿⣿⡿⠿⣿⣿⣿⣿⣿⣿⣿\n");
        System.out.print("⣿⢿⣿⣿⠟⠉⢉⣿⣀⣀⣨⡿⢶⣤⣤⡿⠷⣦⣴⣶⣋⣀⣤⣿⡁⠉⠻⣿⠿⣿\n");
        System.out.print("⣿⣀⣈⣿⣶⠶⠟⠉⠉⠉⢩⡟⠛⠉⠛⣷⠀⠀⠀⠉⠉⠉⠁ ⠈⠛⠷⢶⣟⣀⣿\n");
        System.out.print("⣿⠙⢛⣽⠶⠶⢶⣄⠀⠀⠘⠷⢶⠶⠟⠋⠀⠀⢀⣀⣀⠀⠀⠀⠀ ⠀  ⢀⣭⡿⣿\n");
        System.out.print("⣿⣤⣼⣧⣤⣤⠾⠋⢀⣤⡶⣦⣤⡀⠀⠀⠀⣾⠛⠉⠉⣿⣆⠀ ⠀  ⢿⣥⣤⣿\n");
        System.out.print("⣿⣧⡀⠈⢻⡇⠀⠀⠸⣧⣀⣀⣨⡷⠀⠀⠀⠙⢻⣿⠛⠉⠙⢷⡄⠀⠀  ⠈⠉⣿\n");
        System.out.print("⣿⠉⠛⠛⠛⠁⠀⠀⠀⠀⠉⠙⠉⠁⢀⣤⡶⠶⢶⡝⠻⠶⠶⠟⠁⠀⠀⠀  ⠀⣿\n");
        System.out.print("⣿⠀⠀⢰⠾⠿⠶⣤⡀⠀⠀⠀⠀⠀⢿⣅⣀⣠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⣿\n");
        System.out.print("⣿⠀⠀⠘⠷⣦⣤⣼⠟⠻⣦⡀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀   ⠀⢠⡾⠛⠻⣿\n");
        System.out.print("⣿⣤⣤⣤⣤⣼⣷⣤⣤⣶⣿⣥⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣼⣷⣦⣤⣿");
        System.out.println();
        System.out.println(Colors.WHITE);
        System.out.println("Please take your change " + Colors.YELLOW + Emojis.MONEY_BAGS);
        System.out.println(Colors.GREEN + "$" + amount);
        System.out.println(change);
    }

    public static void printHiddenScreen()
    {
        System.out.println(Console.CLEAR_SCREEN);
        System.out.print(Colors.RED);
        System.out.println("**********************************");
        System.out.println("----------- ADMIN MENU -----------");
        System.out.println("**********************************");
        System.out.println();
        System.out.print(Colors.WHITE + "Enter the passcode: ");
    }

    public static void printAdminMenu()
    {
        System.out.println(Console.CLEAR_SCREEN);
        System.out.print(Colors.RED);
        System.out.println("**********************************");
        System.out.println("----------- ADMIN MENU -----------");
        System.out.println("**********************************");
        System.out.println(Colors.WHITE);
        System.out.println("(1) View sales report");
        System.out.println("(2) Clear sales report");
    }

    public static void printLogs(File file)
    {
        System.out.println(Console.CLEAR_SCREEN + Colors.CYAN);
        try (Scanner reader = new Scanner(file))
        {
            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.out.print(Colors.RED);
            System.out.println("File not found");
        }
    }


    public static void printSoldProduct(Product product, BigDecimal moneyRemaining)
    {
        System.out.println();
        System.out.println(product.getName() + " costs $" + product.getPrice());
        System.out.println("You now have $" + moneyRemaining + " in the machine");
        System.out.println(product);
    }

    public static void printErrorMessage(Exception e)
    {
        System.out.println(Colors.RED);
        System.out.println(e.getMessage());
    }
}
