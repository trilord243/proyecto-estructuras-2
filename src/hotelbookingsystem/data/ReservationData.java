// ReservationData.java
package hotelbookingsystem.data;

import hotelbookingsystem.models.Reservation;
import hotelbookingsystem.utils.BinarySeachTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReservationData {
    private BinarySeachTree<Reservation> reservations;

    public ReservationData() {
        reservations = new BinarySeachTree<>();
    }

    public void loadReservationData(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Assuming the CSV file has the format: ci,firstName,lastName,email,gender,roomType,phoneNumber,arrivalDate,departureDate
                String ci = parts[0];
                String firstName = parts[1];
                String lastName = parts[2];
                String email = parts[3];
                String gender = parts[4];
                String roomType = parts[5];
                String phoneNumber = parts[6];
                String arrivalDate = parts[7];
                String departureDate = parts[8];
                Reservation reservation = new Reservation(ci, firstName, lastName, email, gender, roomType, phoneNumber, arrivalDate, departureDate);
                reservations.put(reservation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Reservation getReservationByCI(String ci) {
        return reservations.get(new Reservation(ci));
    }
}
