/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;

import static Collections.BrandManager.brandList;
import static Collections.CarManager.carList;
import model.Brand;
import model.Car;

/**
 *
 * @author admin
 */
public class Validation {
    //Validate String id : not null, not empty
    public  static boolean isValidId(String id){
        if(id==null){
            return false;
        }
        return !id.trim().isEmpty();
    }

    //Validate String id must be unique, not in the brands.txt
    public static boolean isUniqueId(String id){
        if(brandList==null){
            return true;//No brand in the list yet so the id is unique
        }
        for(Brand brand: brandList){
            if(brand.getId().equalsIgnoreCase(id)){
                return false;//Same id
            }
        }
        return true;
    }
    
    //Validate String name <Not empty>
    public static boolean isValidName(String name){
        if(name.isEmpty()){
            return false;
        }
        return true;
    }
    
    
    //Validate String sound <Not empty>
    public static boolean isValidSound(String sound){
        if(sound.isEmpty()){
            return false;
        }
        return true;
    }
    
    //Validate  price <Positive number, 1.234 means 1.234 billions
    public static boolean isValidPriceFormat(String priceText){
         // Must match: number or number with decimal "
        return priceText.matches("\\d+(\\.\\d+)?");
    }
    
    public static boolean isPositivePrice(double price){
        return price>0;
    }
    
   
    
    //////////////////////////////////////////////////////////////////////////////////
    ///////////////////VALIDATION FOR CAR////////////////////////////////////////////
    
    //Validate Car ID
    public static boolean isValidCarId(String id){
        if(id==null|| id.trim().isEmpty()){
            return false;
        }
        for(Car c: carList){
            if(c.getCarId().equalsIgnoreCase(id)){
                return false;
            }
               
            }
        return true;
            
        }
    
    
    //Check color cannot be empty
    public static boolean isValidColor(String color){
        if(color==null || color.trim().isEmpty()){
            return false;
        }
        return true;
    }
    
    //Check valid FrameID
    public static boolean isValidFrameId(String id){
        //Check empty
        if(id == null || id.trim().isEmpty()){
            System.out.println("Frame id cannot be empty!");
            return false;
        }
        
        id= id.trim();
        //check format F00000
        if(!id.matches("^F\\d{5}$")){
            System.out.println("FrameId must follow the format: 'F00000'");
            return false;
        }
        //Check unique
        for(Car car : carList){
            if(car.getFrameId().equalsIgnoreCase(id)){
                System.out.println("FrameId already exist");
                return false;
            }
        }
        return true;
        
    }
    
    //Check valid EngineId
    public static boolean isValidEngineId(String id){
        //Check empty
        if(id == null || id.trim().isEmpty()){
            System.out.println("Engine id cannot be empty!");
            return false;
        }
        
        id= id.trim();
        //check format E00000
        if(!id.matches("^E\\d{5}$")){
            System.out.println("EngineId must follow the format: 'E00000'");
            return false;
        }
        //Check unique EngineId
        for(Car car : carList){
            if(car.getEngineId().equalsIgnoreCase(id)){
                System.out.println("EngineId already exist");
                return false;
            }
        }
        return true;
    }
    
    
    }

