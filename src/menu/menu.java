/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import Collections.BrandManager;
import Collections.CarManager;
import java.io.IOException;
import FileHandle.File;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class menu {
   

    public static void printMenu() throws IOException {
        CarManager.readFromFileCar();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1- List all brands");
            System.out.println("2- Add a new brand");
            System.out.println("3- Search for a brand by ID");
            System.out.println("4- Update a brand by ID");
            System.out.println("5- List all brands with prices <= input value");
            System.out.println("6- List all cars in ascending order of brand names");
            System.out.println("7- Search cars by partial brand name match");
            System.out.println("8- Add a new car");
            System.out.println("9- Remove a car by ID");
            System.out.println("10- Update a car by ID");
            System.out.println("11- List all cars by a specific color");
            System.out.println("12- Save data to files");
            System.out.println("13- Quit program");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number please!");
                continue;
            }

            switch (choice) {
                case 1:
                    BrandManager.displayAll();
                    break;
                case 2:
                    BrandManager.addNewBrand();
                    break;
                case 3 :
                    BrandManager.searchBrandByID();
                    break;
                case 4:
                    BrandManager.updateBrandById();
                    break;
                case 5:
                    BrandManager.listBrandByPrice();
                    break;
                case 6:
                    CarManager.listAllCarAscBrandName();
                    break;
                case 7: 
                    CarManager.searchCarByPartialName();
                    break;
                case 8:
                    CarManager.addNewCar();
                    break;
                case 9:
                    CarManager.removeCarById();
                    break;
                case 10:
                    CarManager.updateCarById();
                    break;
                case 11:
                    CarManager.ListCarsByColor();
                    break;
                case 12:
                    File.saveData();
                    break;
                case 13:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Feature not implemented yet!");
            }

        } while (choice != 13);

        sc.close();
    }
}  
