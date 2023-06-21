/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelbookingsystem;

import hotelbookingsystem.data.CustomerData;
import hotelbookingsystem.utils.HashTable;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Escal
 */
public class HotelBookingSystem {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        CustomerData customerdata = new CustomerData();
        HashTable habitaciones = customerdata.getHabitaciones();
        
        Scanner scanner = new Scanner(System.in);
        String fullname;

        System.out.println("Enter the guest´s fullname to search for the room:");
        fullname = scanner.nextLine();

        if (habitaciones.get(fullname)==null){
            System.out.println(fullname +"'s room does not exist, contact customer service.");
        }
        else{
            System.out.println(fullname +"'s room is number: " + habitaciones.get(fullname)+".");
        }
        
    
    }
}
    

