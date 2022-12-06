package com.techelevator.file_io;

import com.techelevator.models.products.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class InventoryLoader
{
    static final File C_S_V = new File("data/vendingmachine.csv");
    private static LinkedHashMap<String, Product> allProducts = new LinkedHashMap<>();

    public static LinkedHashMap<String, Product> stockInventory() {
        try(Scanner filesScanner = new Scanner(C_S_V)) {
            while (filesScanner.hasNextLine()) {
                String line = filesScanner.nextLine();
                String [] everythingSplit = line.split("\\|");
                String id = everythingSplit[0];
                String name = everythingSplit[1];
                BigDecimal price = new BigDecimal(everythingSplit[2]);
                String type = everythingSplit[3];
                Product product = createProduct(type, id, name, price);
                allProducts.put(id, product);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        }
        return allProducts;
    }

    public static Product createProduct(String type, String id, String name, BigDecimal price)
    {
        if (type.equals("Chip"))
        {
            return new Chips(name, price, id);
        }
        else if (type.equals("Drink"))
        {
            return new Drinks(name, price, id);
        }
        else if (type.equals("Gum"))
        {
            return new Gum(name, price, id);
        }
        else if (type.equals("Candy"))
        {
            return new Candy(name, price, id);
        }
        return null;
    }


}
