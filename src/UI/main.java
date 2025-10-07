/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UI;
import Collections.BrandManager;
import java.io.IOException;
import menu.menu;
/**
 *
 * @author admin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
     BrandManager.readFromFileBrand();

        menu.printMenu();
        // TODO code application logic here
    }
    
}
