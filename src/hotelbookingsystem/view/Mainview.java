/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelbookingsystem.view;

import com.toedter.calendar.JDateChooser;
import hotelbookingsystem.data.ControllerCsv;
import hotelbookingsystem.models.Customer;
import hotelbookingsystem.models.Reservation;
import hotelbookingsystem.utils.BinarySeachTree;
import hotelbookingsystem.utils.HashTable;
import hotelbookingsystem.utils.LinkedList;
import hotelbookingsystem.utils.ListNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Escal
 */
public class Mainview extends javax.swing.JFrame {
    HashTable<String, Customer> customerTable = new HashTable<>(1200);
    BinarySeachTree<Integer, LinkedList<Customer>> tree;
    BinarySeachTree<Integer, Reservation> reservationTree = new BinarySeachTree<>();





    /**
     * Creates new form Mainview
     */
    
    
    
    
    
    
    
public void loadData(BinarySeachTree<Integer, LinkedList<Customer>> tree) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("Booking_hotel - historico.csv"));
    String line;
    
    // Saltar la primera línea
    br.readLine();
    
    while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        int ci = Integer.parseInt(values[0].replace(".", "")); // quitamos los puntos
        String firstName = values[1];
        String lastName = values[2];
        String email = values[3];
        String gender = values[4];
        String arrivalDate = values[5];
        int roomNumber = Integer.parseInt(values[6]);

        Customer customer = new Customer();
        customer.setCi(ci);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setArrivalDate(arrivalDate);

        LinkedList<Customer> customers = tree.get(roomNumber);
        if (customers == null) {
            customers = new LinkedList<>();
            tree.put(roomNumber, customers);
        }
        customers.append(customer);
    }
    br.close();
}


public void loadReservationData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("Booking_hotel - reservas.csv"));
    String line;
    boolean isFirstLine = true; // variable para controlar la primera línea (encabezado)
    while ((line = br.readLine()) != null) {
        
        if (isFirstLine) {
            isFirstLine = false; // Si es la primera línea (encabezado), se omite
            continue;
        }
        String[] values = line.split(",");
        int ci = Integer.parseInt(values[0].replace(".", "")); // quitamos los puntos
        
        String firstName = values[1];
        String lastName = values[2];
        String email = values[3];
        String gender = values[4];
        String roomType = values[5];
        String phoneNumber = values[6];
        String arrivalDate = values[7];
        String departureDate = values[8];

        Reservation reservation = new Reservation();
        reservation.setCustomerCI(ci);
        reservation.setFirstName(firstName);
        reservation.setLastName(lastName);
        reservation.setEmail(email);
        reservation.setGender(gender);
        reservation.setRoomType(roomType);
        reservation.setPhoneNumber(phoneNumber);
        reservation.setArrivalDate(arrivalDate);
        reservation.setDepartureDate(departureDate);

        reservationTree.put(ci, reservation);
    }
    br.close();
}




    
    
    
    
    
    
    public Mainview() {
        initComponents();
        tree = new BinarySeachTree<>();  
  
  


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        historialButton = new javax.swing.JButton();
        addClient = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        busquedaRerservacion = new javax.swing.JButton();
        checkOut = new javax.swing.JButton();
        checkIn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(46, 111, 223));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbookingsystem/view/icons8-booking-90.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Italic_IV50", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EliteStay");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 140, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbookingsystem/view/icons8-search-property-60.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 180));

        jLabel3.setBackground(new java.awt.Color(46, 111, 223));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(46, 111, 223));
        jLabel3.setText("Buscar habitacion");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbookingsystem/view/icons8-add-user-60.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbookingsystem/view/icons8-search-property-60.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbookingsystem/view/icons8-reservation-60.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbookingsystem/view/icons8-check-all-60.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbookingsystem/view/icons8-time-machine-60.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        jLabel11.setBackground(new java.awt.Color(46, 111, 223));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(46, 111, 223));
        jLabel11.setText(" por nombre de ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        jLabel13.setBackground(new java.awt.Color(46, 111, 223));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(46, 111, 223));
        jLabel13.setText("de reservación");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        jLabel14.setBackground(new java.awt.Color(46, 111, 223));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(46, 111, 223));
        jLabel14.setText("huesped");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jLabel15.setBackground(new java.awt.Color(46, 111, 223));
        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(46, 111, 223));
        jLabel15.setText("Búsqueda  ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        jLabel16.setBackground(new java.awt.Color(46, 111, 223));
        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(46, 111, 223));
        jLabel16.setText("de habitación");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbookingsystem/view/icons8-check-out-60.png"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        jLabel18.setBackground(new java.awt.Color(46, 111, 223));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(46, 111, 223));
        jLabel18.setText("Check-out");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, -1, -1));

        jLabel20.setBackground(new java.awt.Color(46, 111, 223));
        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(46, 111, 223));
        jLabel20.setText("Check-in");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, -1, -1));

        jLabel19.setBackground(new java.awt.Color(46, 111, 223));
        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(46, 111, 223));
        jLabel19.setText("Historial ");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        jLabel17.setBackground(new java.awt.Color(46, 111, 223));
        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(46, 111, 223));
        jLabel17.setText("Agregar reserva");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        historialButton.setBackground(new java.awt.Color(230, 230, 230));
        historialButton.setForeground(new java.awt.Color(230, 230, 230));
        historialButton.setBorder(null);
        historialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialButtonActionPerformed(evt);
            }
        });
        jPanel3.add(historialButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 130, 120));

        addClient.setBackground(new java.awt.Color(230, 230, 230));
        addClient.setForeground(new java.awt.Color(230, 230, 230));
        addClient.setBorder(null);
        addClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClientActionPerformed(evt);
            }
        });
        jPanel3.add(addClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 130, 120));

        jButton4.setBackground(new java.awt.Color(230, 230, 230));
        jButton4.setForeground(new java.awt.Color(230, 230, 230));
        jButton4.setBorder(null);
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 130, 120));

        busquedaRerservacion.setBackground(new java.awt.Color(230, 230, 230));
        busquedaRerservacion.setForeground(new java.awt.Color(230, 230, 230));
        busquedaRerservacion.setBorder(null);
        busquedaRerservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaRerservacionActionPerformed(evt);
            }
        });
        jPanel3.add(busquedaRerservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 130, 120));

        checkOut.setBackground(new java.awt.Color(230, 230, 230));
        checkOut.setForeground(new java.awt.Color(230, 230, 230));
        checkOut.setBorder(null);
        jPanel3.add(checkOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 130, 120));

        checkIn.setBackground(new java.awt.Color(230, 230, 230));
        checkIn.setForeground(new java.awt.Color(230, 230, 230));
        checkIn.setBorder(null);
        checkIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInActionPerformed(evt);
            }
        });
        jPanel3.add(checkIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 130, 120));
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 356, -1, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    


    
    
    
    
    
    private void addClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClientActionPerformed
  String csvFile = "Booking_hotel - reservas.csv";
String ci = null;
String line = "";
String cvsSplitBy = ",";

BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader(csvFile));
    do {
        ci = JOptionPane.showInputDialog(this, "Ingrese la cédula del cliente");
        if (ci == null) return; // Si el usuario presiona cancelar
        if (!ci.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe ser numérica.");
        } else {
            while ((line = br.readLine()) != null) {
                // Usamos coma como separador
                String[] client = line.split(cvsSplitBy);

                // Verificamos si el cliente ya está registrado
                if (client[0].replace(".", "").equals(ci)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un cliente con esa cédula");
                    return;
                }
            }
            break;
        }
    } while (true);
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar la cédula");
    e.printStackTrace();
} finally {
    if (br != null) {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    String primer_nombre = JOptionPane.showInputDialog(this, "Ingrese el primer nombre");
    String segundo_nombre = JOptionPane.showInputDialog(this, "Ingrese el segundo nombre");

    String email = null;
    do {
        email = JOptionPane.showInputDialog(this, "Ingrese el email");
        if (email == null) return; // Si el usuario presiona cancelar
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "El correo electrónico es inválido.");
        } else {
            break;
        }
    } while (true);

 String genero = JOptionPane.showInputDialog(this, "Ingrese el genero");

    Object[] tipos_hab = {"doble", "simple", "suite"};
    String tipo_hab = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de habitación", 
        "Tipo de Habitación", JOptionPane.QUESTION_MESSAGE, null, tipos_hab, tipos_hab[0]);

    String celular = JOptionPane.showInputDialog(this, "Ingrese el número de celular");

    String llegada = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    do {
        JDateChooser jd = new JDateChooser();
        JOptionPane.showMessageDialog(null, jd, "Ingrese la fecha de llegada", JOptionPane.PLAIN_MESSAGE);
        llegada = sdf.format(jd.getDate());
        if (llegada == null) return; // Si el usuario presiona cancelar
        if (!llegada.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "La fecha de llegada es inválida.");
        } else {
            break;
        }
    } while (true);

    // Lo mismo para la fecha de salida, reutilizando el mismo formato de fecha.
    String salida = null;
    do {
        JDateChooser jd = new JDateChooser();
        JOptionPane.showMessageDialog(null, jd, "Ingrese la fecha de salida", JOptionPane.PLAIN_MESSAGE);
        salida = sdf.format(jd.getDate());
        if (salida == null) return; // Si el usuario presiona cancelar
        if (!salida.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "La fecha de salida es inválida.");
        } else {
            break;
        }
    } while (true);

    String clientInfo = String.join(",", ci, primer_nombre, segundo_nombre, email, genero, tipo_hab, celular, llegada, salida) + "\n";



    try {
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            // Usamos coma como separador
            String[] client = line.split(cvsSplitBy);

            // Verificamos si el cliente ya está registrado
            if (client[0].equals(ci)) {
                JOptionPane.showMessageDialog(this, "Este cliente ya está registrado");
                return;
            }
        }

        // Usamos el flag "true" en FileWriter para agregar información en lugar de sobrescribir.
        FileWriter writer = new FileWriter(csvFile, true);
        writer.write(clientInfo);
        writer.close();
        JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar la información del cliente");
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }//GEN-LAST:event_addClientActionPerformed

    private void historialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialButtonActionPerformed
        
              try {
        loadData(tree); 
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
        String roomNumberString = null;
    do {
        roomNumberString = JOptionPane.showInputDialog(this, "Ingrese el número de la habitación");
        if (roomNumberString == null) return; // Si el usuario presiona cancelar
        if (!roomNumberString.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El número de habitación debe ser numérico.");
        } else {
            break;
        }
    } while (true);
    Integer roomNumber = Integer.parseInt(roomNumberString);

    LinkedList guests = tree.get(roomNumber);

    if (guests == null) {
        JOptionPane.showMessageDialog(this, "No hay historial para esta habitación.");
    } else {
        StringBuilder guestList = new StringBuilder();
        ListNode node = guests.getHead();

        while (node != null) {
            guestList.append(node.getData()).append("\n");
            node = node.getNext();
        }

        JOptionPane.showMessageDialog(this, "Los clientes que se han alojado en esta habitación son:\n" + guestList.toString());
    }
    }//GEN-LAST:event_historialButtonActionPerformed

    private void busquedaRerservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaRerservacionActionPerformed
        
         try {
        loadReservationData(); 
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
        String ciString = null;
    do {
        ciString = JOptionPane.showInputDialog(this, "Ingrese la cédula de identidad");
        if (ciString == null) return;
        if (!ciString.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula de identidad debe ser numérica.");
        } else {
            break;
        }
    } while (true);
    int ci = Integer.parseInt(ciString);

    Reservation reservation = reservationTree.get(ci);

    if (reservation == null) {
        JOptionPane.showMessageDialog(this, "No existe una reservación para esta cédula.");
    } else {
        JOptionPane.showMessageDialog(this, reservation.toString());
    }
    }//GEN-LAST:event_busquedaRerservacionActionPerformed

    private void checkInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkInActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClient;
    private javax.swing.JButton busquedaRerservacion;
    private javax.swing.JButton checkIn;
    private javax.swing.JButton checkOut;
    private javax.swing.JButton historialButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
