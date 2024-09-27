package Models;

import java.util.List;

public abstract class Room {
    int roomNumber;
    double pricePerNight;
    boolean isAvailable;
    boolean amenities;

    Room(int roomNumber, double pricePerNight, boolean amenities) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
        isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean getAmenities() {
        return amenities;
    }

    public void setAmenities(boolean amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
       return "The room number is " + roomNumber + " and the price per night is " + pricePerNight +
               ". The amenities are " + amenities + ". The room is " + (isAvailable ? "available" : "not available");
    }
}
