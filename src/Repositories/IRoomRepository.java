package Repositories;

import Models.Room;

import java.util.List;

public interface IRoomRepository {

    Room getRoom(int roomNumber);
    List<Room> getAllRooms();

    public Room getNextAvailableRoom(List<Room> rooms);
    void addRoom(Room room);
    void removeRoom(int roomNumber);
    void updateRoom(Room room);

    void updateRoomAvailability(int roomNumber);
}
