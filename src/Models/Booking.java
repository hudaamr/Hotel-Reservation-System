package Models;

import java.util.Date;

public class Booking {
    private String bookingID;
    private Guest guest;
    private Room room;  // This can be any room type: SingleRoom, DoubleRoom, etc.
    private Date startDate;
    private Date endDate;
    private boolean isActive;

    public Booking(String bookingID, Guest guest, Room room, Date startDate, Date endDate) {
        this.bookingID = bookingID;
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = true;
    }

    public String getBookingID() {
        return bookingID;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
