/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandle;

import static Collections.BrandManager.brandList;
import static Collections.BrandManager.brandListModified;
import Collections.CarManager;
import static Collections.CarManager.carList;
import static Collections.CarManager.carListModified;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import model.Brand;
import model.Car;

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

        System.out.println("All changes have been saved successfully.");
        brandListModified = false;
        carListModified = false;
    }

    public static void saveDataSilentlyIfDirty() throws IOException {
        if (!brandListModified && !carListModified) {
            return; // nothing to do
        }
        writeBrandsToFile("src/data/brands.txt");
        writeCarsToFile("src/data/cars.txt");
        brandListModified = false;
        carListModified = false;
        System.out.println("Changes detected. Data saved before exit.");
    }

    private static void writeBrandsToFile(String path) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
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
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
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
}
