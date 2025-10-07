/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collections;

import static Collections.BrandManager.brandList;
import io.Input;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Brand;
import model.Car;

/**
 *
 * @author admin
 */
public class CarManager {

    public static boolean carListChange = true;
    public static final Scanner sc = new Scanner(System.in);
    public static ArrayList<Car> carList = new ArrayList<>();

    public static Car datatoObjectCar(String input) {
        try {
            String[] parts = input.split(",");
            if (parts.length == 5) {
                String carId = parts[0].trim();
                String brandId = parts[1].trim();
                String color = parts[2].trim();
                String frameId = parts[3].trim();
                String engineId = parts[4].trim();

                return new Car(carId, brandId, color, frameId, engineId);
            }

        } catch (Exception e) {

        }
        return null;
    }

    public static void readFromFileCar() throws IOException {
        String path = "src/data/cars.txt";
        carList.clear();

        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Car car = datatoObjectCar(line);

                if (car != null) {
                    carList.add(car);
                }

            }
        } catch (IOException e) {

        }
        carListChange = false;

    }

    /*Function 6:List all cars in ascending order of brand names: Display all cars in ascending order of
brand names; if same brand, sort by price descending.
     */
    public static void listAllCarAscBrandName() {
        ArrayList<Car> carListSorted = new ArrayList<>(carList);
        carListSorted.sort((c1, c2) -> {
            Brand b1 = BrandManager.returnBrandById(c1.getBrandId());
            Brand b2 = BrandManager.returnBrandById(c2.getBrandId());

            int cmpBrand = b1.getName().compareToIgnoreCase(b2.getName());
            if (cmpBrand != 0) {
                return cmpBrand;
            } else {
                return Double.compare(b2.getPrice(), b1.getPrice());
            }
        });
        displayCarList(carListSorted);
    }

    //Function search Car by BrandId
    public static ArrayList<Car> searchCarByBrandId(String id) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getBrandId().equalsIgnoreCase(id)) {
                result.add(car);
            }

        }
        return result;
    }

    //Function 7:Search cars by partial brand name match
    public static void searchCarByPartialName() {
        ArrayList<Car> carListByPartialName = new ArrayList<>();
        System.out.println("Input partial name of the cars: ");
        String partialName = sc.nextLine().trim().toLowerCase();
        for (Brand b : brandList) {
            if (b.getName().toLowerCase().contains(partialName)) {
                ArrayList<Car> cars = searchCarByBrandId(b.getId());
                carListByPartialName.addAll(cars);
            }
        }
        if (carListByPartialName.isEmpty()) {
            System.out.println("No cars found!");
        } else {
            displayCarList(carListByPartialName);
        }
    }

    //Function 8:Add a new car
    public static void addNewCar() {
        String carId = Input.inputCarId();
        String brandId = Input.inputBrandIdCar();
        String color = Input.inputColor();
        String frameId = Input.inputFrameId();
        String engineId = Input.inputEngineId();

        carList.add(new Car(carId, brandId, color, frameId, engineId));
        carListChange = true;

    }

    //Function 9: Remove a car by ID:
    //Function search Car by CarId
    public static Car searchCarByCarId(String id) {
        for (Car car : carList) {
            if (car.getCarId().equalsIgnoreCase(id)) {
                return car;
            }
        }
        return null;

    }

    public static void removeCarById() {
        System.out.println("Enter CarId you want to delete: ");
        String id = sc.nextLine();
        Car carSearched = searchCarByCarId(id);
        if (carSearched != null) {
            System.out.println("Are you sure you want to delete Car " + carSearched.getCarId() + "?(Y/N)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                carList.remove(carSearched);
                System.out.println("Remove successfully!");
                carListChange = true;

            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Cancel Remove Process!");
            }
        } else {
            System.out.println("Car not found!");
        }
    }

    //Function 10: Update a car by ID
    public static void updateCarById() {
        Car carUpdate;
        while (true) {
            System.out.println("Enter CarId you want to update: ");
            String id = sc.nextLine();
            carUpdate = searchCarByCarId(id);
            if (carUpdate == null) {
                System.out.println("This car does not exist!");
            } else {
                break;
            }

        }

        //Update Car Color
        while (true) {
            System.out.println("Update new color or Press 'Enter' to keep current color: ");
            String newColor = sc.nextLine().trim();
            if (newColor.isEmpty()) {
                System.out.println("No changing color, keep current color!");
                break;
            } else {
                carUpdate.setColor(newColor);
                System.out.println("update new color successfully");
                carListChange = true;

                break;
            }
        }

        //Update FrameId
        while (true) {
            System.out.println("Update new FrameId or Press 'Enter' to keep current FrameId: ");
            String newFrameId = sc.nextLine().trim();
            if (newFrameId == null) {
                System.out.println("No changing FrameId, keep current FrameId!");
                break;
            } else {
                if (!io.Validation.isValidFrameId(newFrameId)) {
                    System.out.println("Invalid FrameId, follow this format “F00000” and must be unique!");
                } else {
                    carUpdate.setFrameId(newFrameId);
                    System.out.println("Update FrameId successfully!");
                    carListChange = true;

                    break;
                }
            }
        }
        //Update EngineId
        while (true) {
            System.out.println("Update new EngineId or Press 'Enter' to keep current Engine: ");
            String newEngineId = sc.nextLine().trim();
            if (newEngineId == null) {
                System.out.println("No changing EngineId, keep current EngineId!");
                break;
            } else {
                if (!io.Validation.isValidEngineId(newEngineId)) {
                    System.out.println("Invalid EngineId, follow this format “E00000” and must be unique!");
                } else {
                    carUpdate.setEngineId(newEngineId);
                    System.out.println("Update EngineId successfully!");
                    carListChange = true;

                    break;
                }
            }
        }
    }

    //Function to display listCar
    public static void displayCarList(ArrayList<Car> list) {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.printf("| %-10s %-15s %-10s %-15s %-15s |\n",
                "Car ID", "Brand ID", "Color", "Frame ID", "Engine ID");
        System.out.println("+---------------------------------------------------------------------+");

        for (Car car : list) {
            System.out.println(car);
        }
        System.out.println("+---------------------------------------------------------------------+");

    }

    public static void displayAll() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.printf("| %-10s %-15s %-10s %-15s %-15s |\n",
                "Car ID", "Brand ID", "Color", "Frame ID", "Engine ID");
        System.out.println("+---------------------------------------------------------------------+");

        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println("+---------------------------------------------------------------------+");

    }

    //Function 11: List all cars by a specific color
    public static void ListCarsByColor() {
        ArrayList<Car> carListByColor = new ArrayList<>();
        String colorInput;
        while (true) {
            System.out.println("Input color of the you want to list: ");
            colorInput = sc.nextLine().trim();
            if (colorInput.isEmpty()) {
                System.out.println("Color cannot be empty! Try Again");
            } else {
                for (Car car : carList) {
                    if (car.getColor().equalsIgnoreCase(colorInput)) {
                        carListByColor.add(car);
                    }

                }
                displayCarList(carListByColor);
                break;
            }
        }

    }
}
