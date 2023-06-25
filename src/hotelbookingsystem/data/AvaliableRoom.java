/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.data;

import hotelbookingsystem.utils.HashTable;
import hotelbookingsystem.utils.LinkedList;
import hotelbookingsystem.utils.ListNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Escal
 */
public class AvaliableRoom {
    
    
    
    
    public void createAvailableRoomsCSV() {
    HashTable<String, String> rooms = new HashTable<>(1000);
    LinkedList<String> occupiedRooms = new LinkedList<>();
    try {
        // Leer el archivo CSV de habitaciones
        BufferedReader br = new BufferedReader(new FileReader("Booking_hotel - habitaciones.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String roomNumber = line.split(",")[0]; // Asumiendo que el número de habitación es el primer campo
            rooms.put(roomNumber, line);
        }
        br.close();

        // Leer el archivo CSV de habitaciones ocupadas
        br = new BufferedReader(new FileReader("Booking_hotel - estado.csv"));
        while ((line = br.readLine()) != null) {
            occupiedRooms.append(line.split(",")[0]); // Asumiendo que el número de habitación es el primer campo
        }
        br.close();

        // Crear el archivo CSV de habitaciones disponibles
       
PrintWriter pw = new PrintWriter(new File("available_rooms.csv"));
LinkedList<String> keys = rooms.keys();
ListNode<String> node = keys.getHead();
while (node != null) {
    String room = node.getData();
    if (!occupiedRooms.contains(room)) {
        pw.println(rooms.get(room));
    }
    node = node.getNext();
}
pw.close();


    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
}
