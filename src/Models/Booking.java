package Models;

import java.util.Date;

public class Booking {
    private String bookingID;
    private Date startDate;
    private Date endDate;
    private Guest guest;
    private Room room;
    private String status;

    public Booking(String bookingID, Guest guest, Room room, Date startDate, Date endDate) {
        this.bookingID = bookingID;
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Confirmed";  // Default status for new bookings
    }

    public String getBookingID() {
        return bookingID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Create a new booking
    public static Booking createBooking(String bookingID, Guest guest, Room room, Date startDate, Date endDate) {
        return new Booking(bookingID, guest, room, startDate, endDate);
    }

    //Modify an existing booking (dates and room)
    public void modifyBooking(Date newStartDate, Date newEndDate, Room newRoom) {
        if (newRoom.isAvailable()) {
            this.startDate = newStartDate;
            this.endDate = newEndDate;
            this.room = newRoom;
            System.out.println("Booking modified successfully.");
        } else {
            System.out.println("Room is not available for the selected dates.");
        }
    }

    //Cancel a booking
    public void cancelBooking() {
        this.status = "Cancelled";
        System.out.println("Booking cancelled successfully.");
    }

    // Get details of a booking
    public String getBookingDetails() {
        return "Booking ID: " + bookingID + ", Guest: " + guest.getName() + 
               ", Room: " + room.getRoomNumber() + ", Status: " + status;
    }

}
