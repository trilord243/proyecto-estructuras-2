/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelbookingsystem.view;

import com.toedter.calendar.JDateChooser;
import hotelbookingsystem.data.CustomerData;
import static hotelbookingsystem.models.Customer.Status;
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
import hotelbookingsystem.data.AvaliableRoom;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Escal
 */
public class Mainview extends javax.swing.JFrame {

    HashTable<String, Customer> customerTable = new HashTable<>(1200);
    BinarySeachTree<Integer, LinkedList<Customer>> tree;
    BinarySeachTree<Integer, Reservation> reservationTree = new BinarySeachTree<>();
    HashTable<String, String> clients = new HashTable<>(1100);
    AvaliableRoom avaliabreRoom = new AvaliableRoom();

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
        if (tree.isEmpty()) {
            try {
                loadData(tree);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        pm("mm.wav");

    }

    public void pm(String location) {
        String mp = location;
        File music = new File(mp);
        try {
            if (music.exists()){
            AudioInputStream ai = AudioSystem.getAudioInputStream(music);
            Clip clip = AudioSystem.getClip();
            clip.open(ai);
            clip.start();
            }else{
            
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
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
        checkOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutActionPerformed(evt);
            }
        });
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

        // Cargar los clientes existentes en la Hashtable
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] clientData = line.split(",");
                String ciNoDots = clientData[0].replace(".", ""); // Eliminar los puntos
                clients.put(ciNoDots, line);
            }
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
        // Registrar al nuevo cliente
        do {
            ci = JOptionPane.showInputDialog(this, "Ingrese la cédula del cliente");
            if (ci == null) {
                return; // Si el usuario presiona cancelar
            }
            if (!ci.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "La cédula debe ser numérica.");
            } else {
                // Verificar si el cliente ya está registrado
                if (clients.get(ci) != null) {
                    JOptionPane.showMessageDialog(this, "Ya existe un cliente con esa cédula");
                    return;
                }
                break;
            }
        } while (true);

        String primer_nombre = JOptionPane.showInputDialog(this, "Ingrese el primer nombre");
        String segundo_nombre = JOptionPane.showInputDialog(this, "Ingrese el segundo nombre");

        String email = null;
        do {
            email = JOptionPane.showInputDialog(this, "Ingrese el email");
            if (email == null) {
                return; // Si el usuario presiona cancelar
            }
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
        String salida = null;
        Date fechaLlegada = null;
        Date fechaSalida = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        do {
            JDateChooser jd = new JDateChooser();
            jd.setMinSelectableDate(new Date()); // Establecer la fecha mínima seleccionable como la fecha actual
            JOptionPane.showMessageDialog(null, jd, "Ingrese la fecha de llegada", JOptionPane.PLAIN_MESSAGE);
            fechaLlegada = jd.getDate();
            llegada = sdf.format(fechaLlegada);
            if (llegada == null) {
                return; // Si el usuario presiona cancelar
            }
            if (!llegada.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                JOptionPane.showMessageDialog(this, "La fecha de llegada es inválida.");
            } else if (fechaLlegada.before(new Date())) {
                JOptionPane.showMessageDialog(this, "La fecha de llegada no puede ser anterior a la fecha actual o la actual.");
            } else {
                break;
            }
        } while (true);

        do {
            JDateChooser jd = new JDateChooser();
            jd.setMinSelectableDate(fechaLlegada); // Establecer la fecha mínima seleccionable como la fecha de llegada
            JOptionPane.showMessageDialog(null, jd, "Ingrese la fecha de salida", JOptionPane.PLAIN_MESSAGE);
            fechaSalida = jd.getDate();
            salida = sdf.format(fechaSalida);
            if (salida == null) {
                return; // Si el usuario presiona cancelar
            }
            if (!salida.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                JOptionPane.showMessageDialog(this, "La fecha de salida es inválida.");
            } else if (fechaSalida.before(fechaLlegada)) {
                JOptionPane.showMessageDialog(this, "La fecha de salida no puede ser anterior a la fecha de llegada.");
            } else {
                break;
            }
        } while (true);

        String clientInfo = String.join(",", ci, primer_nombre, segundo_nombre, email, genero, tipo_hab, celular, llegada, salida) + "\n";
        clients.put(ci, clientInfo);

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

        String roomNumberString = null;
        do {
            roomNumberString = JOptionPane.showInputDialog(this, "Ingrese el número de la habitación");
            if (roomNumberString == null) {
                return; // Si el usuario presiona cancelar
            }
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
            if (ciString == null) {
                return;
            }
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
        avaliabreRoom.createAvailableRoomsCSV();
        String ci = JOptionPane.showInputDialog("Por favor, introduzca el número de cédula:");
        ci = ci.replace(".", ""); // quitar los puntos del número de cédula introducido por el usuario
        try {
            // Leer el archivo CSV de clientes
            File inputFile = new File("Booking_hotel - reservas.csv");
            File tempFile = new File("temp.csv");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line;
            String clientData = null;
            while ((line = br.readLine()) != null) {
                String ciFromFile = line.split(",")[0].replace(".", ""); // quitar los puntos del número de cédula del archivo
                if (ciFromFile.equals(ci)) {
                    clientData = line;
                    continue; // no escribir esta línea en el archivo temporal
                }
                pw.println(line);
            }
            br.close();

            if (clientData == null) {
                JOptionPane.showMessageDialog(null, "El cliente no está registrado.");
                return;
            }

            // Crear una nueva cadena que contenga todos los campos de clientData excepto el número de cédula y el tipo de habitación
            // Crear una nueva cadena que contenga todos los campos de clientData excepto el número de cédula, el tipo de habitación y la fecha de salida
            String[] clientDataFields = clientData.split(",");
            StringBuilder clientDataWithoutCIAndRoomType = new StringBuilder();
            for (int i = 1; i < clientDataFields.length; i++) {
                if (i != 5 && i != clientDataFields.length - 1) { // Asumiendo que el tipo de habitación es el sexto campo y la fecha de salida es el último campo
                    clientDataWithoutCIAndRoomType.append(clientDataFields[i]);
                    if (i < clientDataFields.length - 2) { // no agregar una coma después del último campo
                        clientDataWithoutCIAndRoomType.append(",");
                    }
                }
            }
            clientDataWithoutCIAndRoomType.append(","); // agregar una coma al final

            String roomType = clientDataFields[5]; // Asumiendo que el tipo de habitación es el sexto campo

            // Leer el archivo CSV de habitaciones disponibles
            br = new BufferedReader(new FileReader("available_rooms.csv"));
            String roomData = null;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[1].equals(roomType)) {
                    roomData = line;
                    break;
                }
            }
            br.close();

            if (roomData == null) {
                JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles del tipo seleccionado.");
                pw.close(); // cerrar el PrintWriter antes de retornar
                return;
            }

            // Si llegamos a este punto, significa que hay una habitación disponible del tipo seleccionado
            // Entonces, podemos eliminar al cliente de la reserva
            pw.close();
            if (!inputFile.delete()) {
                System.out.println("No se pudo eliminar el archivo original");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("No se pudo renombrar el archivo temporal");
                return;
            }

            // Agregar los datos del cliente al archivo CSV de habitaciones ocupadas
            pw = new PrintWriter(new FileWriter("Booking_hotel - estado.csv", true));
            pw.println(roomData.split(",")[0] + "," + clientDataWithoutCIAndRoomType.toString() + "\n");
            pw.close();

            // Eliminar la habitación del archivo CSV de habitaciones disponibles
        } catch (IOException e) {
            e.printStackTrace();
        }

        customerdata.updateData(); // Actualizar los datos en tiempo real
    }//GEN-LAST:event_checkInActionPerformed

    CustomerData customerdata = new CustomerData();

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        HashTable habitaciones = customerdata.getHabitaciones();
        Status(habitaciones);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void checkOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutActionPerformed

        //Writers and readers
        String csvFile = "Booking_hotel - estado.csv";
        String csvFileH = "Booking_hotel - historico.csv";
        String csvFileT = "temp.csv";
        String mm = "rr.wav";

        File of = new File(csvFile);
        File nf = new File(csvFileT);

        //Variables de utilidad
        String line;
        long tlf_c;
        long i_tlf;
        boolean war = false;

        try {

            FileWriter tfw = new FileWriter(csvFileT, true);
            BufferedWriter tbw = new BufferedWriter(tfw);
            PrintWriter tpw = new PrintWriter(tbw);

            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            FileWriter fw = new FileWriter(csvFileH, true);

            br.readLine();
            do {
                String tlfString = JOptionPane.showInputDialog(this, "Ingrese su numero telefonico");
                if (tlfString == null) {
                    return;
                }
                if (!tlfString.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "El numero de celular debe ser numerico.");
                } else {
                    tlf_c = Long.parseLong(tlfString);
                    break;
                }
            } while (true);

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String num_hab = values[0]; //Habitacion
                String name = values[1];//Nombre
                String lastName = values[2]; //Apellido
                String mail = values[3]; //mail
                String gender = values[4]; //genero 
                String tlf = values[5].replace(".", "").replace("(", "").replace(")", "").replace(" ", "");
                i_tlf = Long.parseLong(tlf);
                String date = values[6];

                if (tlf_c == i_tlf) {
                    if (JOptionPane.showConfirmDialog(null, "¿Quiere terminar la estadia?: " + name + " " + lastName, "CONFIRMACION",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        do {
                            String ci = JOptionPane.showInputDialog(this, "Ingrese su cedula para terminar el proceso");
                            if (ci == null) {
                                return;
                            }
                            if (!ci.matches("\\d+")) {
                                JOptionPane.showMessageDialog(this, "La cédula de identidad debe ser numérica.");
                            } else {
                                // Long i_ci = Long.parseLong(ci);
                                fw.append("\r\n" + ci + "," + name + "," + lastName + "," + mail + "," + gender + "," + date + "," + num_hab);
                                fw.close();
                                loadData(tree);

                                break;
                            }
                        } while (true);

                    } else {
                        JOptionPane.showMessageDialog(this, "Volviendo al menu");
                    }

                } else {
                    if (!war) {
                        JOptionPane.showMessageDialog(this, "No hubo coincidicencias, verifique");
                        war = true;

                        File mp = new File(mm);
                        if (mp.exists()) {

                            try {
                                AudioInputStream ai = AudioSystem.getAudioInputStream(mp);
                                Clip clip = AudioSystem.getClip();
                                clip.open(ai);
                                clip.start();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        } else {
                            System.out.println("a");
                        }

                    }
                    tpw.println(line);
                }

            }

            tpw.flush();
            tpw.close();
            tbw.close();
            tfw.close();
            br.close();

            of.delete();
            File nn = new File(csvFile);
            nf.renameTo(nn);

        } catch (IOException e) {
            e.printStackTrace();
        }

        customerdata.updateData();
    }//GEN-LAST:event_checkOutActionPerformed

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
            java.util.logging.Logger.getLogger(Mainview.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainview.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainview.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainview.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
