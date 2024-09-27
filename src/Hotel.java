import Repositories.IRoomRepository;
import Repositories.RoomRepository;


public class Hotel {
    IRoomRepository roomRepository;

    public Hotel() {
        roomRepository = RoomRepository.getInstance();
    }

    private boolean manageRoomAvailability(int roomNumber) {
        return roomRepository.getRoom(roomNumber).isAvailable();
    }
    public void checkIn(int roomNumber) {
       if (manageRoomAvailability(roomNumber)){
           roomRepository.updateRoomAvailability(roomNumber);
       }

    }

    public void checkOut(int roomNumber) {
      if(!manageRoomAvailability(roomNumber)){
          roomRepository.updateRoomAvailability(roomNumber);
      }
    }


}
