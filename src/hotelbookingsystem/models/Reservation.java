package hotelbookingsystem.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Customer customer;
    private int roomNumber;
    private LocalDate arrivalDate;
    private LocalDate departureDate;

   public Reservation(String ci, String firstName, String lastName, String email, String gender, String roomType, String phoneNumber, String arrivalDate, String departureDate) {
    this.customer = new Customer(firstName, lastName, email, gender, phoneNumber);
    this.roomNumber = Integer.parseInt(roomType); // Assuming roomType is the room number
    this.arrivalDate = LocalDate.parse(arrivalDate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
    this.departureDate = LocalDate.parse(departureDate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
}


    
public String getCustomerCI() {
        return this.customer.getCI();
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
