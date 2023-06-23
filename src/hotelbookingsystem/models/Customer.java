package  hotelbookingsystem.models;

import hotelbookingsystem.utils.HashTable;
import java.util.Scanner;

public class Customer {
    private int ci;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phoneNumber;
    private String arrivalDate;
    private String exitDate;
    

    // Getters and setters for each field

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
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

