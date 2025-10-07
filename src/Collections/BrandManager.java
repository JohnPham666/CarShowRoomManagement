/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Brand;

/**
 *
 * @author admin
 */
public class BrandManager {

    public static ArrayList<Brand> brandList = new ArrayList<>();
    public static boolean brandListModified = false;

    public static Brand dataToObjectBrand(String text) {
        try {
            // Format: id, name, sound: price
            String[] parts = text.split(",|:");
            if (parts.length >= 4) {
                String id = parts[0].trim();
                String name = parts[1].trim();
                String sound = parts[2].trim();
                String priceText = parts[3].trim();

                double price;
                if (priceText.endsWith("B")) {
                    // B = billion
                    priceText = priceText.replace("B", "");
                    price = Double.parseDouble(priceText);
                } else {
                    price = Double.parseDouble(priceText);
                }

                return new Brand(id, name, sound, price);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static ArrayList<Brand> readFromFileBrand() {
        brandList.clear();
        String pathFile = "src/data/brands.txt";

        try ( BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                Brand brand = dataToObjectBrand(line);

                if (brand != null) {
                    brandList.add(brand);
                }
            }
        } catch (IOException e) {

        }
        brandListModified = false; // freshly loaded from disk
        return brandList;

    }

    //Function 1:Display all brand in the file brands.txt
    public static void displayAll() {
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("│ %-10s │ %-40s │ %-20s │ %20s  │", "Brand Id", "Brand Name", "Sound", "Price"));

        for (Brand b : brandList) {
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(b);
            System.out.println("-------------------------------------------------------------------------------------------------------");
        }

    }

    //Function 2: Add a new brand
    public static void addNewBrand() {
        String id = io.Input.inputNewBrandId();
        String name = io.Input.inputBrandName();
        String sound = io.Input.inputSound();
        double price = io.Input.inputBrandPrice();

        brandList.add(new Brand(id, name, sound, price));
        brandListModified = true;

    }

    //Function 3 : Search brand by ID
    public static void searchBrandByID() {
        //User input id
        System.out.println("Enter ID: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        //Compare id with brandID in the list
        boolean found = false;
        String idSearch;
        for (Brand brand : brandList) {
            idSearch = brand.getId();
            if (idSearch.equalsIgnoreCase(id)) {
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.println(String.format("│ %-10s │ %-40s │ %-20s │ %20s  │", "Brand Id", "Brand Name", "Sound", "Price"));
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.println(brand);
                System.out.println("-------------------------------------------------------------------------------------------------------");

                found = true;
            }
        }
        if (found == false) {
            System.out.println("This brand does not exist!");
        }

    }

    //Function 4: Update a brand by ID
    //Function found brand by ID
    public static Brand foundBrandById(String id) {
        for (Brand brand : brandList) {
            if (brand.getId().equalsIgnoreCase(id)) {
                return brand;
            }
        }
        return null;
    }

    //Function 4: Update brand by id
    public static void updateBrandById() {
        Scanner sc = new Scanner(System.in);
        String id;
        Brand brand;
        while (true) {
            System.out.println("Enter Brand Id to update: ");
            id = sc.nextLine();
            brand = foundBrandById(id);
            if (brand != null) {
                break;
            } else {
                System.out.println("Brand Id not found, please try again! ");
            }

        }

        //Update Brand name
        while (true) {
            System.out.println("Enter new brand name or press 'Enter' to skip: ");
            String newName = sc.nextLine();
            if (newName.isEmpty()) {
                System.out.println("No changing name, keep current name!");
                break;
            } else if (io.Validation.isValidName(newName) == true) {
                brand.setName(newName);
                brandListModified = true;
                break;
            } else {
                System.out.println("Invalid Name, please try again");
            }

        }

        //Update Brand soud
        while (true) {
            System.out.println("Enter new brand sound or press 'Enter' to skip: ");
            String newSound = sc.nextLine();
            if (newSound.isEmpty()) {
                System.out.println("no changing sound, keep current sound");
                break;
            } else if (io.Validation.isValidSound(newSound)) {
                brand.setSound(newSound);
                brandListModified = true;
                break;
            } else {
                System.out.println("Invalid sound, please try again");
            }
        }

        //update price
        while (true) {
            System.out.println("Enter new brand price(B) or press 'Enter' to skip: ");
            String newPrice = sc.nextLine().trim();
            double newPriceDouble = Double.parseDouble(newPrice);
            if (newPrice.isEmpty()) {
                System.out.println("No changing price, keep current price");
                break;
            } else if (io.Validation.isValidPriceFormat(newPrice) && newPriceDouble > 0) {
                brand.setPrice(newPriceDouble);
                brandListModified = true;
                break;
            } else {
                System.out.println("Invalid Price, please try again!");
            }

        }
        System.out.println("Update Brand successfully!");
    }
    //Finish Function 4

    //Function 5: List all brands with price less than or equal to an input value
    public static void displayBrand(ArrayList<Brand> list) {
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("│ %-10s │ %-40s │ %-20s │ %20s  │", "Brand Id", "Brand Name", "Sound", "Price"));
        for (Brand b : list) {
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(b);
            System.out.println("-------------------------------------------------------------------------------------------------------");

        }
    }

    public static void listBrandByPrice() {
        ArrayList<Brand> listByPrice = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        double priceInput;
        while (true) {
            System.out.println("Enter your Price: ");
            priceInput = sc.nextDouble();
            if (io.Validation.isPositivePrice(priceInput)) {
                break;
            } else {
                System.out.println("Price must be a positive number, Pleasse try again");
            }
        }
        for (Brand brand : brandList) {
            if (brand.getPrice() <= priceInput) {
                listByPrice.add(brand);
            }
        }

        if (listByPrice.isEmpty()) {
            System.out.println("No brand found with price <= " + priceInput + "B");
        } else {
            displayBrand(listByPrice);
        }
    }
    //finish function 5
    
    //Function return brand by Id
    public static Brand returnBrandById(String id){
        for(Brand b: brandList){
            if(b.getId().equalsIgnoreCase(id)){
                return b;
            }
        }
        return null; 
    }
}

