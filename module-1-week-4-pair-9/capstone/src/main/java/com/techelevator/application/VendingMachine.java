package com.techelevator.application;

import com.techelevator.file_io.InventoryLoader;
import com.techelevator.file_io.Logger;
import com.techelevator.models.exceptions.InsufficientFundsException;
import com.techelevator.models.exceptions.InvalidChoiceException;
import com.techelevator.models.exceptions.OutOfStockException;
import com.techelevator.models.products.Product;
import com.techelevator.view.Input;
import com.techelevator.view.Output;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine
{
    private final String TOTAL_SALES_KEY = "**TOTAL SALES**";
    private LinkedHashMap<String, Product> inventory = InventoryLoader.stockInventory();
    private BigDecimal moneyProvided = BigDecimal.ZERO;
    private Logger logger = new Logger("logs/");
    private LinkedHashMap<String, BigDecimal> sales = new LinkedHashMap<>();
    private BigDecimal totalSales;


    public LinkedHashMap<String, Product> getInventory()
    {
        return inventory;
    }

    public BigDecimal getMoneyProvided()
    {
        return moneyProvided;
    }

    public void insertMoney(BigDecimal amount)
    {
        moneyProvided = moneyProvided.add(amount);
    }

    public String giveChange()
    {
        double moneyInMachine = moneyProvided.doubleValue();
        int totalChange = (int) (moneyInMachine * 100);
        int quarters = totalChange / 25;
        totalChange = totalChange % 25;
        int dimes = totalChange / 10;
        totalChange = totalChange % 10;
        int nickels = totalChange / 5;
        return quarters + " Quarters - " + dimes + " Dimes - " + nickels + " Nickels";
    }

    public void getPreviousSales()
    {
        String path = "data/salesreport.csv";
        File file = new File(path);

        try (Scanner reader = new Scanner(file))
        {
            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                String[] lineSplit = line.split("\\|");
                String snack = lineSplit[0];
                BigDecimal quantity = new BigDecimal(lineSplit[1]);
                sales.put(snack, quantity);
            }
        }
        catch (IOException e)
        {
            Output.printErrorMessage(e);
        }
    }

    public void writeSales()
    {
        String path = "data/salesreport.csv";
        File file = new File(path);
        try (PrintWriter writer = new PrintWriter(file))
        {
            for (String key : sales.keySet())
            {
                writer.println(key + "|" + sales.get(key));
            }
        }
        catch ( IOException e)
        {
            Output.printErrorMessage(e);
        }
    }

    public void clearSales()
    {
        String path = "data/salesreport.csv";
        File file = new File(path);
        try (PrintWriter writer = new PrintWriter(file))
        {
            for (String key : sales.keySet())
            {
                sales.put(key, BigDecimal.ZERO);
                writer.println(key + "|0");
            }
        }
        catch ( IOException e)
        {
            Output.printErrorMessage(e);
        }
    }

    public void run()
    {
        getPreviousSales();
        Output.printWelcomeScreen();
        String input = Input.getInput();

        while(true)
        {
            try
            {
                // display home screen
                // get user selection
                Output.printHomeScreen();
                input = Input.getInput();
                final String LIST_INVENTORY = "1";
                final String PURCHASE = "2";
                final String EXIT = "3";
                final String ADMIN = "4";
                if (input.equals(LIST_INVENTORY))
                {
                    Output.printItems(inventory);
                    input = Input.getInput();
                    logger.logMessage("INVENTORY LISTED");
                    final String GO_BACK = "3";
                    if (input.equals(GO_BACK))
                    {
                        continue;
                    }
                }
                else if (input.equals(PURCHASE))
                {
                    purchaseScreen();
                }
                else if (input.equals(EXIT))
                {
                    writeSales();
                    break;
                }
                else if (input.equals(ADMIN))
                {
                    Output.printHiddenScreen();
                    String password = Input.getInput();

                    if (password.equals("lightship"))
                    {
                        final String VIEW_SALES = "1";
                        final String CLEAR_SALES = "2";
                        Output.printAdminMenu();
                        input = Input.getInput();
                        if (input.equals(VIEW_SALES))
                        {
                            writeSales();
                            String path = "data/salesreport.csv";
                            File file = new File(path);
                            Output.printLogs(file);
                        }
                        else if (input.equals(CLEAR_SALES))
                        {
                            clearSales();
                        }
                    }
                }
                else
                {
                    throw new InvalidChoiceException();
                }
            }
            catch (InvalidChoiceException e)
            {
                Output.printErrorMessage(e);
            }
        }
    }

    public void purchaseScreen()
    {
        String input;
        final String FEED_MONEY = "1";
        final String SELECT_PRODUCT = "2";
        final String FINISH_TRANSACTION = "3";
        while (true)
        {
            try
            {
                Output.printPurchaseScreen(moneyProvided);
                input = Input.getInput();

                if (input.equals(FEED_MONEY))
                {
                    BigDecimal amount;
                    while (true)
                    {
                        Output.printFeedMoneyScreen(moneyProvided);
                        try
                        {
                            input = Input.getInput();
                            if (!isNumberic(input))
                            {
                                throw new InvalidChoiceException();
                            }
                            amount = new BigDecimal(input);
                            if (!isValidMoneyAmount(amount))
                            {
                                throw new InvalidChoiceException();
                            } else
                            {
                                break;
                            }
                        } catch (InvalidChoiceException e)
                        {
                            Output.printErrorMessage(e);
                        }

                    }
                    insertMoney(amount);
                    logger.logMessage("FEED MONEY $" + amount + " $" + moneyProvided);
                } else if (input.equals(SELECT_PRODUCT))
                {
                    Output.printSelectProductScreen();
                    selectProductToPurchase();

                } else if (input.equals(FINISH_TRANSACTION))
                {

                    String change = giveChange();
                    Output.printChange(moneyProvided, change);
                    logger.logMessage("GIVE CHANGE $" + moneyProvided);
                    moneyProvided = BigDecimal.ZERO;
                    break;
                }
                else
                {
                    throw new InvalidChoiceException();
                }
            }
            catch (InvalidChoiceException e)
            {
                Output.printErrorMessage(e);
            }
        }
    }

    private void selectProductToPurchase()
    {
        String input = Input.getInput();
        String id = input.toUpperCase();
        while (true)
        {
            try
            {
                if (inventory.containsKey(id))
                {
                    Product product = inventory.get(id);
                    String name = product.getName();
                    int stock = product.getRemainingQuantity();
                    BigDecimal price = product.getPrice();
                    if (moneyProvided.compareTo(price) == 1 || moneyProvided.compareTo(price) == 0)
                    {
                        if (stock > 0)
                        {
                            product.itemsSold();
                            moneyProvided = moneyProvided.subtract(price);
                            Output.printSoldProduct(product, moneyProvided);
                            inventory.put(id, product);
                            sales.put(name, sales.get(name).add(BigDecimal.ONE));
                            sales.put(TOTAL_SALES_KEY, sales.get(TOTAL_SALES_KEY).add(price));
                            logger.logMessage(name + " " + id + " " + price + " " + moneyProvided);
                            break;
                        }
                        else
                        {
                            throw new OutOfStockException();
                        }

                    }
                    else
                    {
                        throw new InsufficientFundsException();
                    }
                }
                else
                {
                    throw new InvalidChoiceException();
                }
            }
            catch (Exception e)
            {
                Output.printErrorMessage(e);
                break;
            }
        }
    }

    public boolean isValidMoneyAmount(BigDecimal amount)
    {
        double moneyToBeInserted = amount.doubleValue();
        int moneyInPennies = (int) (moneyToBeInserted * 100);
        if (moneyInPennies < 0)
        {
            return false;
        }
        else if (moneyInPennies % 5 != 0)
        {
            return false;
        }
        return true;
    }

    public boolean isNumberic(String str)
    {
        try
        {
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
