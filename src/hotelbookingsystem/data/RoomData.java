package hotelbookingsystem.data;

import hotelbookingsystem.models.Room;
import hotelbookingsystem.utils.BinarySearchTreeRoom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoomData {
    private BinarySearchTreeRoom rooms;

    public RoomData() {
        rooms = new BinarySearchTreeRoom();
    }

    public void loadRoomData(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Assuming the CSV file has the format: roomNumber,roomType
                Integer roomNumber = Integer.parseInt(parts[0]);
                String roomType = parts[1];
                Room room = new Room(roomNumber, roomType);
                rooms.put(roomNumber, room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Room getRoomByNumber(Integer roomNumber) {
        return rooms.get(roomNumber);
    }
}
