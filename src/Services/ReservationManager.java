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
    private double additionalServicesRevenue;

    // Prices for additional services
    private final double ROOM_SERVICE_PRICE = 50.0;
    private final double SPA_PRICE = 100.0;
    private final double LAUNDRY_PRICE = 30.0;

    public ReservationManager(RoomRepository roomRepository) {
        this.bookings = new ArrayList<>();
        this.roomRepository = roomRepository;
        this.additionalServicesRevenue = 0.0;
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

    // apply additional services with fixed service names and prices
    public void applyAdditionalService(Guest guest, String serviceName) {
        double serviceCost = 0.0;

        switch (serviceName.toLowerCase()) {
            case "room service":
                serviceCost = ROOM_SERVICE_PRICE;
                break;
            case "spa":
                serviceCost = SPA_PRICE;
                break;
            case "laundry":
                serviceCost = LAUNDRY_PRICE;
                break;
            default:
                System.out.println("Service not available.");
                return;
        }

        additionalServicesRevenue += serviceCost;
        System.out.println(serviceName + " applied to guest " + guest.getName() + ". Cost: $" + serviceCost);
    }

    // calculate total booking revenue
    public double calculateBookingRevenue() {
        double totalBookingRevenue = 0.0;
        for (Booking booking : bookings) {
            totalBookingRevenue += booking.getRoom().getPricePerNight() * booking.getRoom().getPricePerNight();
        }
        return totalBookingRevenue;
    }

    // calculate total revenue
    public double calculateTotalRevenue() {
        return calculateBookingRevenue() + additionalServicesRevenue;
    }

    // generate a revenue report
    public void generateRevenueReport() {
        double bookingRevenue = calculateBookingRevenue();
        System.out.println("Revenue Report:");
        System.out.println("Total Booking Revenue: $" + bookingRevenue);
        System.out.println("Total Additional Services Revenue: $" + additionalServicesRevenue);
        System.out.println("Total Revenue: $" + calculateTotalRevenue());
    }
}
