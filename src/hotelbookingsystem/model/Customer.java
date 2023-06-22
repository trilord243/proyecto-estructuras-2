/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.model;

import hotelbookingsystem.data.CustomerData;
import hotelbookingsystem.utils.HashTable;
import java.util.Scanner;

/**
 *
 * @author Escal
 */
public class Customer {
    public static void Status(HashTable habitaciones){
        
        Scanner scanner = new Scanner(System.in);
        String fullname;

        System.out.println("Enter the guest´s fullname to search for the room:");
        fullname = scanner.nextLine().toUpperCase();
        
        if (habitaciones.get(fullname)==null){
            System.out.println(fullname +"'s room does not exist. If you want to register a new reservation, return to the home page.");
        }
        else{
            System.out.println(fullname +"'s room is the number: " + habitaciones.get(fullname)+".");
        }
    }
    
    
}
