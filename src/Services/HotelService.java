package Services;

import Models.*;
import Repositories.IRoomRepository;
import Repositories.RoomRepository;

import java.util.List;

public class HotelService {
    Guest guest;
    RoomRepository roomRepository = RoomRepository.getInstance();

    public boolean isValid(String prompt){
        return prompt != null && !prompt.isEmpty();
    }
    public boolean isAllFieldsValid(String name, String email, String number){
        return isValid(name) && isValid(email) && isValid(number);
    }
    public void addGuest(String name, String email, String number){
        if(isAllFieldsValid(name, email, number))
            guest = new Guest(name, email, number);
    }

    public List<Room> filterRoomsByType(int roomType){
        return roomRepository.filterRoomsByType(roomType);
    }

    public Room getNextAvailableRoom(List<Room> filteredRooms){
        return roomRepository.getNextAvailableRoom(filteredRooms);
    }


}
