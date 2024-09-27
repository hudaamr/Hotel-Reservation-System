package Services;

import Models.Booking;
import Models.Guest;
import Models.Room;
import Repositories.RoomRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationManager {
    private List<Booking> bookings;
    private RoomRepository roomRepository;

    // Constructor that accepts RoomRepository for managing room data
    public ReservationManager(RoomRepository roomRepository) {
        this.bookings = new ArrayList<>();
        this.roomRepository = roomRepository;
    }

    // Method to check if a room is available for given dates
    public boolean isRoomAvailable(Room room, Date startDate, Date endDate) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room) && booking.isActive()) {
                // Check if the booking overlaps with the requested dates
                if (!(startDate.after(booking.getEndDate()) || endDate.before(booking.getStartDate()))) {
                    return false; // Room is not available for the requested dates
                }
            }
        }
        return true; // Room is available
    }

    // Method to create a new booking
    public void createBooking(Guest guest, Room room, Date startDate, Date endDate) {
        // Check if room is available before creating a booking
        if (isRoomAvailable(room, startDate, endDate)) {
            String bookingID = generateBookingID();
            Booking booking = new Booking(bookingID, guest, room, startDate, endDate);
            bookings.add(booking); // Add booking to the list of active bookings
            guest.addBookingToHistory(booking); // Add booking to the guest's reservation history
            room.setAvailable(false); // Update room availability
            System.out.println("Booking created successfully for " + guest.getName());
        } else {
            System.out.println("Room is not available for the selected dates.");
        }
    }

    // Method to cancel a booking
    public void cancelBooking(String bookingID) {
        for (Booking booking : bookings) {
            if (booking.getBookingID().equals(bookingID)) {
                booking.cancelBooking();
                booking.getRoom().setAvailable(true); // Make the room available again
                System.out.println("Booking with ID " + bookingID + " has been canceled.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    // Generate a unique booking ID
    private String generateBookingID() {
        return "BOOK" + (bookings.size() + 1); // Simple ID generation logic
    }

    // Method to get all bookings (useful for viewing or listing bookings)
    public List<Booking> getAllBookings() {
        return bookings;
    }

    // Additional methods to update bookings, check booking details, etc., can be added here
}
