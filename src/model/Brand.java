/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Brand {
    private String id;
    private String name;
    private String sound;
    private double price;
    
    public Brand(){
    }

    public Brand(String id, String name, String sound, double price) {
        this.id = id;
        this.name = name;
        this.sound = sound;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
return String.format("│ %-10s │ %-40s │ %-20s │ %20.3fB │", 
                              id,name,sound, price);    
    
    }
    
    
    }

    
