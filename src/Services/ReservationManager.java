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

    public ReservationManager(RoomRepository roomRepository) {
        this.bookings = new ArrayList<>();
        this.roomRepository = roomRepository;
    }

    public boolean isRoomAvailable(Room room, Date startDate, Date endDate) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room)) {
                if (!(startDate.after(booking.getEndDate()) || endDate.before(booking.getStartDate()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void createBooking(Guest guest, Room room, Date startDate, Date endDate) {
        if (isRoomAvailable(room, startDate, endDate)) {
            String bookingID = generateBookingID();
            Booking booking = new Booking(bookingID, guest, room, startDate, endDate);
            bookings.add(booking);
            guest.addBookingToHistory(booking);
            System.out.println("Booking created successfully for " + guest.getName());
        } else {
            System.out.println("Room is not available for the selected dates.");
        }
    }

    public void cancelBooking(String bookingID) {
        for (Booking booking : bookings) {
            if (booking.getBookingID().equals(bookingID)) {
                booking.cancelBooking();
                System.out.println("Booking with ID " + bookingID + " has been canceled.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    private String generateBookingID() {
        return "BOOK" + (bookings.size() + 1);
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}

