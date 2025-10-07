/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;

import java.util.Scanner;
import io.Validation;
/**
 *
 * @author admin
 */
public class Input {
    public static final Scanner sc = new Scanner(System.in);
    //input New brandId
    public static String inputNewBrandId(){
        String id;
        do{
        System.out.println("Enter your new Brand ID: ");
        id = sc.nextLine();
        
        if(!Validation.isValidId(id)){
            System.out.println("Brand id cannot be empty, please try again!!!");
            id=null;
            continue;
        }
        
        if(!Validation.isUniqueId(id)){
            System.out.println("Brand id already exist. Enter another one!!!");
            id=null;
        }
        }while(id==null);
        return id;
    }
    
    //input Brand name
    public static String inputBrandName(){
        String name ;
        do{
            System.out.println("Enter your new Brand name: ");
            name = sc.nextLine().trim();
            if(!Validation.isValidName(name)){
                System.out.println("Name cannot be empty. Please enter new name!!!");
                name = null;
            }
        }while(name==null);
        return name;
    }
    
    //Input sound 
    
    public static String inputSound(){
        String sound;
        do{
            System.out.println("Enter new sound manufacturing: ");
            sound = sc.nextLine().trim();
            if(!Validation.isValidSound(sound)){
                System.out.println("Sound must not be empty, please try again!!!");
                sound=null;
            }
        }while(sound==null);
            return sound;
    }
    
    //Input Brand Price
    public static double inputBrandPrice(){
        String priceText;
        double price = 1;
        do{
            System.out.println("Enter your brand price(Billions | example: 1.234 means 1.234B): ");
            priceText = sc.nextLine().trim();
            
            if(!Validation.isValidPriceFormat(priceText)){
                System.out.println("Price must be a positive number, try again please!!!");
                price =0;
            }else{
                price =1;

            }
                        
        }while(price<=0);
        System.out.println("Add new brand successfully!!!");
        return Double.parseDouble(priceText) ;
        
    }
    
    /////////////////////////////////////////////////////////////////
    ////////////////INPUT FOR CAR////////////////////////////////////
    //Input BrandId for Car
    public static String inputBrandIdCar(){
        String id;
        do{
        System.out.println("Enter your Brand ID(BrandId must exist in BrandList): ");
        id = sc.nextLine().trim();
        
        if(!Validation.isValidId(id)){
            System.out.println("Brand id cannot be empty, please try again!!!");
            id=null;
            continue;
        }
        
        if(Validation.isUniqueId(id)){
            System.out.println("Brand id does not exist. Enter another one!!!");
            id=null;
        }
        }while(id==null);
        return id;
    }
    //Input Car Id
    public static String inputCarId(){
        String id;
        do{
            System.out.println("Enter Car Id: ");
            id = sc.nextLine().trim();
            if(!Validation.isValidCarId(id)){
                System.out.println("Invalid Id, Please try again!");
                id=null;
            }else{
                break;
                
            }
        }while(id==null);
        return id;
    }
    
    //input Color
    public static String inputColor(){
        String color;
        do{
            System.out.println("Enter Car Color: ");
            color = sc.nextLine().trim();
            if(!Validation.isValidColor(color)){
                System.out.println("Color cannot be empt. Please try again");
                color =null;
            }else{
                break;
            }
        
        
        
        }while(color==null);
        return color;
    }
    
    //input Frame Id
    public static String inputFrameId(){
        String frameId;
        do{
            System.out.println("Enter Car Frame Id: ");
            frameId = sc.nextLine().trim();
            if(!Validation.isValidFrameId(frameId)){
                System.out.println("Invalid FrameId. Please try again");
                frameId =null;
            }else{
                break;
            }
    }while(frameId==null);
        return frameId;
}
    
    
    //input Engine Id
    public static String inputEngineId(){
        
        String engineId;
        do{
            System.out.println("Enter Car Engine ID: ");
            engineId = sc.nextLine().trim();
            if(!Validation.isValidEngineId(engineId)){
                System.out.println("invalid Engine ID. Please try again!");
                engineId = null;
            }else{
                break;
            }
        
        
        
        }while(engineId==null);
        return engineId;
    }
}
