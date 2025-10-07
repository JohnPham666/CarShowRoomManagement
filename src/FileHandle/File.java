/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandle;

import static Collections.BrandManager.brandList;
import static Collections.CarManager.carList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import model.Brand;
import model.Car;
import static Collections.BrandManager.brandListChange;
import static Collections.CarManager.carListChange;
/**
 *
 * @author admin
 */
public class File {

    public static void saveData() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you sure you want to save all changes to files? (Y/N): ");
        String answer = scanner.nextLine().trim();
        if (!answer.equalsIgnoreCase("Y")) {
            System.out.println("Save cancelled.");
            return;
        }

        writeBrandsToFile("src/data/brands.txt");
        writeCarsToFile("src/data/cars.txt");
        brandListChange=false;
        carListChange=false;
        System.out.println("All changes have been saved successfully.");
    }

    private static void writeBrandsToFile(String path) throws IOException {
        try ( PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
            for (Brand brand : brandList) {
                String line = String.format("%s, %s, %s: %.3fB",
                        brand.getId(),
                        brand.getName(),
                        brand.getSound(),
                        brand.getPrice());
                writer.println(line);
            }
        }
    }

    private static void writeCarsToFile(String path) throws IOException {
        try ( PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
            for (Car car : carList) {
                String line = String.format("%s, %s, %s, %s, %s",
                        car.getCarId(),
                        car.getBrandId(),
                        car.getColor(),
                        car.getFrameId(),
                        car.getEngineId());
                writer.println(line);
            }
        }
    }
    
    public static void saveDataSilentlyIfDirty() throws IOException {
    if (!brandListChange && !carListChange) {
        return;
    }
    writeBrandsToFile("src/data/brands.txt");
    writeCarsToFile("src/data/cars.txt");
    brandListChange = false;
    carListChange = false;
    System.out.println("Changes detected. Data saved before exit.");
}


public static void handleQuit() throws IOException {
    if (brandListChange || carListChange) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Unsaved changes detected. Save before exit? (Y/N): ");
        String ans = sc.nextLine().trim();
        if (ans.equalsIgnoreCase("Y")) {
            saveDataSilentlyIfDirty();
        }
    }else{
        System.out.println("No change detected. Exit Programme successfully!");
    }
}

}
