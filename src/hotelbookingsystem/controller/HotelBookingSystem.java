/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.controller;

import hotelbookingsystem.models.Customer;
import hotelbookingsystem.models.Reservation;
import hotelbookingsystem.utils.BinarySeachTree;
import hotelbookingsystem.utils.CustomerHashTable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Escal
 */
public class HotelBookingSystem {
    private CustomerHashTable customerTable;
    private BinarySeachTree<String, Reservation> reservationTree;
    private BinarySeachTree<String, Reservation> roomHistoryTree;

    public HotelBookingSystem(int size) {
        customerTable = new CustomerHashTable(size);
        reservationTree = new BinarySeachTree<>();
        roomHistoryTree = new BinarySeachTree<>();
    }

    public void checkIn(Customer customer, Reservation reservation) {
        // Añadir al cliente a la tabla hash de clientes
        customerTable.put(customer);

        // Añadir la reservación al ABB de reservaciones
        reservationTree.put(reservation.getCustomerCI(), reservation);
    }

    public void checkOut(String customerLastName, String customerCI) {
        // Eliminar al cliente de la tabla hash
        customerTable.remove(customerLastName);

        // Obtener la reservación del ABB de reservaciones
        Reservation reservation = reservationTree.get(customerCI);

        // Añadir la reservación al ABB del historial de la habitación
        roomHistoryTree.put(reservation.getRoomNumber(), reservation);
    }
        public Reservation findReservation(String customerCI) {
        // Buscar la reservación en el ABB de reservaciones
        return reservationTree.get(customerCI);
    }

    public Reservation findRoomHistory(String roomNumber) {
        // Buscar el historial de la habitación en el ABB del historial de las habitaciones
        return roomHistoryTree.get(roomNumber);
    }
    public void loadReservations(String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split("\t");
        Reservation reservation = new Reservation();
        reservation.setCustomerCI(parts[0]);
        reservation.setFirstName(parts[1]);
        reservation.setLastName(parts[2]);
        reservation.setEmail(parts[3]);
        reservation.setGender(parts[4]);
        reservation.setRoomType(parts[5]);
        reservation.setPhoneNumber(parts[6]);
        reservation.setArrivalDate(parts[7]);
        reservation.setDepartureDate(parts[8]);
        reservationTree.put(reservation.getCustomerCI(), reservation);
    }
    reader.close();
}
    public void loadCustomers(String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split("\t");
        Customer customer = new Customer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
        customerTable.put(customer);
    }
    reader.close();
}

    public void loadRoomHistory(String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split("\t");
        Reservation reservation = new Reservation();
        reservation.setCustomerCI(parts[0]);
        reservation.setFirstName(parts[1]);
        reservation.setLastName(parts[2]);
        reservation.setEmail(parts[3]);
        reservation.setGender(parts[4]);
        reservation.setArrivalDate(parts[5]);
        reservation.setRoomNumber(parts[6]);
        roomHistoryTree.put(reservation.getRoomNumber(), reservation);
    }
    reader.close();
}



}

