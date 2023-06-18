/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.utils;
import hotelbookingsystem.models.Reservation;
/**
 *
 * @author Escal
 */
public class ReservationNode {
    private Integer ci;
    private Reservation reservation;

    public ReservationNode(Integer ci, Reservation reservation) {
        this.ci = ci;
        this.reservation = reservation;
    }

    public Integer getCI() {
        return ci;
    }

    public Reservation getReservation() {
        return reservation;
    }
}

