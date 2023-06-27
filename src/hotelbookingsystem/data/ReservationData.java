/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Escal
 */
public class ReservationData {

    /**
     *
     */
    public ReservationData(){
        String filePath = "Booking_hotel - reservas.csv";
        String newUser = "29.765.316,Chris,Diaz,CD@mozilla.org,Masculine,suite,(242) 2310316,20/08/2023,30/08/2023";
        agregarNuevoElementoCSV(filePath, newUser);
    }
    
    
    public static String agregarNuevoElementoCSV(String filePath, String newUser) {
        String ultimoElemento = null;

        try {
            // Leer el archivo CSV existente
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuilder fileContent = new StringBuilder();

            // Leer y almacenar el contenido actual del archivo
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }
            reader.close();

            // Agregar el nuevo elemento después de la última fila de la primera columna
            String[] rows = fileContent.toString().split(System.lineSeparator());
            String lastCellValue = rows[rows.length - 1].split(",")[0];

            // Construir la nueva línea con el nuevo elemento
            StringBuilder newLine = new StringBuilder();
            newLine.append(lastCellValue).append(",").append(newUser);

            // Agregar la nueva línea al contenido del archivo
            fileContent.append(newLine.toString()).append(System.lineSeparator());

            // Escribir el contenido actualizado en el archivo CSV
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(fileContent.toString());
            writer.close();

            System.out.println("Successful reservation processes. See you soon!");

            // Establecer el último elemento como resultado
            ultimoElemento = newUser;
        } catch (IOException e) {
            System.out.println("Error al manipular el archivo CSV: " + e.getMessage());
        }

        return ultimoElemento;
    }
    
}
