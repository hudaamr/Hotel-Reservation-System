package Models;
import java.util.Date;

public class Booking {
    private String bookingID;
    private Guest guest;
    private Room room;
    private Date startDate;
    private Date endDate;
    private double totalCost;
    private boolean isActive;

    // Constructor
    public Booking(String bookingID, Guest guest, Room room, Date startDate, Date endDate) {
        this.bookingID = bookingID;
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = true;
        this.totalCost = calculateCost();
    }

    // Getters and setters
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Calculate total cost of booking based on room price and stay duration
    private double calculateCost() {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
        return diffInDays * room.getPricePerNight();
    }

    // Other booking-related methods (e.g., cancel booking, modify booking)
}
