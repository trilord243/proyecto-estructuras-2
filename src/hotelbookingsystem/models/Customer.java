package  hotelbookingsystem.models;

import hotelbookingsystem.utils.HashTable;
import java.util.Scanner;
import javax.swing.JOptionPane;



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
        

        String fullname = JOptionPane.showInputDialog(null, "Ingrese su nombre completo:");;

        
        if (fullname == null) {
            JOptionPane.showMessageDialog(null, "Se canceló el ingreso de nombre completo.");
        } else {
            fullname =  fullname.toUpperCase();
            if (fullname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese su nombre completo.");
            } else if (habitaciones.get(fullname) == null) {
                JOptionPane.showMessageDialog(null, "La habitación de " + fullname + " no existe. Si deseas registrar una nueva reserva, regresa a la página de inicio.");
            } else {
                JOptionPane.showMessageDialog(null, "La habitación de " + fullname + " es la número: " + habitaciones.get(fullname) + ".");
            }
        }

    }
    
    public String toString() {
        return firstName + " " + lastName + ", CI: " + ci;
    }


}

