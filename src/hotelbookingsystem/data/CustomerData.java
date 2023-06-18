package hotelbookingsystem.data;

import hotelbookingsystem.models.Customer;
import hotelbookingsystem.utils.HashTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerData {
    private HashTable<String, Customer> customers;

    public CustomerData() {
        customers = new HashTable<String, Customer>(100);
    }

    public void loadCustomerData(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
       
                // El csv tendra este formato :firstName,lastName,email,gender,phoneNumber
                String firstName = parts[0];
                String lastName = parts[1];
                String email = parts[2];
                String gender = parts[3];
                String phoneNumber = parts[4];
                Customer customer = new Customer(firstName, lastName, email, gender, phoneNumber);
                customers.put(firstName + " " + lastName, customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerByName(String firstName, String lastName) {
        return customers.get(firstName + " " + lastName);
    }
}
