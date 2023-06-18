/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Escal
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HotelBookingSystemGUI extends Application {

    private HotelBookingSystem hotelBookingSystem;

    public HotelBookingSystemGUI() {
        hotelBookingSystem = new HotelBookingSystem(100); // o el tamaño que prefieras para la tabla hash
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Check-in");
        btn.setOnAction(event -> {
            // Aquí puedes llamar a hotelBookingSystem.checkIn() con los datos del cliente y la reservación
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hotel Booking System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

