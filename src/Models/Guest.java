package Models;

import java.util.ArrayList;
import java.util.List;

public class Guest extends Person {
    private String guestID;
    private String paymentInfo;
    private List<Booking> reservationHistory;

    // Constructor
    public Guest(String name, String contactInfo, String guestID) {
        super(name, contactInfo);
        this.guestID = guestID;
        this.paymentInfo = ""; // default payment info (can be set later)
        this.reservationHistory = new ArrayList<>();
    }

    // Getters
    public String getGuestID() {
        return guestID;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public List<Booking> getReservationHistory() {
        return reservationHistory;
    }

    // Setters
    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    // Functions for Guest Class

    // 1. Update contact information
    public void updateContactInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
        System.out.println("Contact information updated.");
    }

    // 2. Add booking to reservation history
    public void addBookingToHistory(Booking booking) {
        this.reservationHistory.add(booking);
        System.out.println("Booking added to guest's reservation history.");
    }

    // 3. Make a reservation (using the ReservationManager)
    public void makeReservation(ReservationManager reservationManager, Room room, Date startDate, Date endDate) {
        reservationManager.createBooking(this, room, startDate, endDate);
    }

    // 4. View reservation history
    public void viewReservationHistory() {
        System.out.println("Reservation History for Guest: " + this.name);
        for (Booking booking : reservationHistory) {
            System.out.println(booking.getBookingDetails());
        }
    }
}
