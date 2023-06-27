/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelbookingsystem;

import hotelbookingsystem.data.CustomerData;
import hotelbookingsystem.data.ReservationData;
//import static hotelbookingsystem.models.Customer.Status;
import hotelbookingsystem.utils.HashTable;
import hotelbookingsystem.view.Mainview;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Escal
 */
public class HotelBookingSystem {

    public static void main(String[] args) {
        
        //precargar la informacion de los hospedados
//        CustomerData customerdata = new CustomerData();
//        HashTable habitaciones = customerdata.getHabitaciones();
        //mandar a Status la hashtable de habitaciones donde nos dira si el huesped esta hospedado en el holtel actualmente
//        Status(habitaciones);
//        ReservationData reservationdata = new ReservationData();
        
        Mainview interfaz = new Mainview();
        interfaz.setVisible(true);

        
    }

}
    

