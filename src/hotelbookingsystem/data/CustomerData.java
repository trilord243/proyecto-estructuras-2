/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.data;

/**
 *
 * @author Escal
 */
import hotelbookingsystem.utils.HashTable;
import hotelbookingsystem.utils.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerData {
    private HashTable<String, LinkedList<String>> habitaciones;

    public CustomerData() {
        habitaciones = new HashTable<>(300);
        String filePath = "Booking_hotel - estado.csv";
        readCSV(filePath);
    }

    private void readCSV(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter(","); // Especifica el delimitador del archivo CSV

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] valores = linea.split(",");

                String habitacion = valores[0].trim();
                String nombre = valores[1].trim().toUpperCase();
                String apellido = valores[2].trim().toUpperCase();

                // Verificar si el número de habitación está vacío y omitir el cliente
                if (habitacion.isEmpty() || habitacion.equals("N/A")) {
                    continue;
                }

                String nombreCompleto = nombre + " " + apellido;

                if (habitaciones.get(nombreCompleto) == null) {
                    LinkedList<String> habitacionesAsociadas = new LinkedList<>();
                    habitacionesAsociadas.append(habitacion);
                    habitaciones.put(nombreCompleto, habitacionesAsociadas);
                } else {
                    LinkedList<String> habitacionesAsociadas = habitaciones.get(nombreCompleto);
                    habitacionesAsociadas.append(habitacion);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public HashTable<String, LinkedList<String>> getHabitaciones() {
        return habitaciones;
    }
}
