/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.data;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Escal
 */
public class RoomData {

    public class CVSReader {

        public static void main(String[] args) {

            String path = "C:\\Users\\Gabriel Mena\\Documents\\Booking - Historico.csv";
            
            
            Scanner scan_user= new Scanner(System.in);
            System.out.println("Ingrese el numero de habitacion que quiere saber su historial: ");
            
            int same = scan_user.nextInt();
            int cont = 0;

            try (Scanner scanner = new Scanner(new File(path))) {
                scanner.useDelimiter(",");

                while (scanner.hasNextLine() && same <= 300) {

                    String line = scanner.nextLine();
                    String[] values = line.split(",");
                    
                    String ci = values[0].trim();
                    String name = values[1].trim();
                   
                    String room_num = values[6].trim();
                    
                    try {
                        if (same == Integer.parseInt(room_num)) {
                            cont++;
                             System.out.println(name);
                            System.out.println(ci);
                           
                        } 
                    } catch (NumberFormatException nf) {
                        System.out.println("Compruebe los valores del csv");
                    }
                }
                
                System.out.println("el numero de personas que alguna vez hubo en la habitacion " + same + " es de " + cont);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }

}
