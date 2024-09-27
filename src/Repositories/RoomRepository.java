package Repositories;

import Models.DoubleRoom;
import Models.Room;
import Models.SingleRoom;
import Models.SuiteRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository implements IRoomRepository {
    private final List<Room> rooms;
    private static RoomRepository instance ;

    private RoomRepository() {
        rooms = new ArrayList<>();
    }

    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }

    @Override
    public Room getRoom(int roomNumber) {
       for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public Room getNextAvailableRoom(List<Room> rooms) {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                return room;
            }
        }
        return null;
    }

     public List<Room> filterRoomsByType(int roomType) {
         List<Room> filteredRooms = new ArrayList<>();
         for (Room room : rooms) {
             if (roomType == 1 && room instanceof SingleRoom) {
                 filteredRooms.add(room);
             } else if (roomType == 2 && room instanceof DoubleRoom) {
                 filteredRooms.add(room);
             } else if (roomType == 3 && room instanceof SuiteRoom) {
                 filteredRooms.add(room);
             }
         }
         return filteredRooms;
     }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void removeRoom(int roomNumber) {
        rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
    }

    @Override
    public void updateRoom(Room room) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == room.getRoomNumber()) {
                r.setPricePerNight(room.getPricePerNight());
                r.setAmenities(room.getAmenities());
            }
        }

    }

    public void updateRoomAvailability(int roomNumber) {
       Room room = getRoom(roomNumber);
       room.setAvailable(!room.isAvailable());
    }


}
