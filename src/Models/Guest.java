package Models;

public class Guest {
    private String guestID;
    private String name;
    private String contactInfo;
    private List<Booking> bookings;

    // Constructor
    public Guest(String guestID, String name, String contactInfo) {
        this.guestID = guestID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.bookings = new ArrayList<>();
    }

    // Getters and setters
    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    // Add a booking
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    // Other guest-related methods (e.g., cancel booking, view booking history)
}

