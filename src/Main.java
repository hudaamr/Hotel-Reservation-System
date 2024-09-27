import Models.*;
import Services.ReservationManager;
import Repositories.RoomRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        RoomRepository roomRepository = RoomRepository.getInstance();

        ReservationManager reservationManager = new ReservationManager(roomRepository);

        Room singleRoom = new SingleRoom(101, 100.0, true); // Single Room
        Room doubleRoom = new DoubleRoom(102, 150.0, true); // Double Room
        Room suiteRoom = new SuiteRoom(103, 250.0, true);   // Suite Room

        roomRepository.addRoom(singleRoom);
        roomRepository.addRoom(doubleRoom);
        roomRepository.addRoom(suiteRoom);

        System.out.println("Welcome to the Hotel Reservation System!");



        // Step 6: Get booking dates from user
        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDateInput = scanner.nextLine();
        Date startDate = dateFormat.parse(startDateInput);

        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateInput = scanner.nextLine();
        Date endDate = dateFormat.parse(endDateInput);

        // Step 7: Create a booking
        System.out.println("\nCreating your booking...");
        reservationManager.createBooking(guest, selectedRoom, startDate, endDate);

        // Step 8: Ask if user wants to cancel the booking
        System.out.print("\nWould you like to cancel your booking? (yes/no): ");
        String cancelInput = scanner.nextLine();

        if (cancelInput.equalsIgnoreCase("yes")) {
            System.out.print("Enter the booking ID to cancel: ");
            String bookingID = scanner.nextLine();
            reservationManager.cancelBooking(bookingID);
        }

        // Step 9: Display all bookings
        System.out.println("\nCurrent bookings: ");
        for (Booking booking : reservationManager.getAllBookings()) {
            System.out.println(booking.getBookingDetails());
        }

        // Step 10: Close the scanner
        scanner.close();
    }
}

