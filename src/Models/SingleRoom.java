package Models;

import Models.Room;

import java.util.List;

public class SingleRoom extends Room {
    SingleRoom(int roomNumber, double pricePerNight, List<String> amenities) {
        super(roomNumber, pricePerNight, amenities);
    }
}
