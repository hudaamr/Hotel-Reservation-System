package Repositories;

import Models.Room;

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
