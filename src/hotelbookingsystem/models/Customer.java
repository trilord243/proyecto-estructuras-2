package hotelbookingsystem.models;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phoneNumber;
    private String arrivalDate;  // Agregamos la fecha de llegada
    private Reservation reservation;  // Referencia a la reserva del cliente

    public Customer(String firstName, String lastName, String email, String gender, String phoneNumber, String arrivalDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.arrivalDate = arrivalDate;  // Inicializamos la fecha de llegada
    }

    // Agregamos un getter y un setter para la fecha de llegada
    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
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


}

