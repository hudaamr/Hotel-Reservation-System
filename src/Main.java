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

        // Step 1: Create the RoomRepository
        RoomRepository roomRepository = new RoomRepository();

        // Step 2: Initialize the ReservationManager with the RoomRepository
        ReservationManager reservationManager = new ReservationManager(roomRepository);

        // Step 3: Create Rooms and add them to the RoomRepository
        Room singleRoom = new SingleRoom(101, 100.0, true); // Single Room
        Room doubleRoom = new DoubleRoom(102, 150.0, true); // Double Room
        Room suiteRoom = new SuiteRoom(103, 250.0, true);   // Suite Room

        roomRepository.addRoom(singleRoom);
        roomRepository.addRoom(doubleRoom);
        roomRepository.addRoom(suiteRoom);

        // User Interaction Begins
        System.out.println("Welcome to the Hotel Reservation System!");

        // Step 4: Get user details for creating a guest
        System.out.print("Enter your name: ");
        String guestName = scanner.nextLine();

        System.out.print("Enter your email: ");
        String guestEmail = scanner.nextLine();

        System.out.print("Enter your contact number: ");
        String guestContact = scanner.nextLine();

        Guest guest = new Guest(guestName, guestEmail, guestContact);

        // Step 5: Select room type
        System.out.println("Select Room Type: ");
        System.out.println("1. Single Room");
        System.out.println("2. Double Room");
        System.out.println("3. Suite Room");

        int roomChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        Room selectedRoom;
        switch (roomChoice) {
            case 1:
                selectedRoom = singleRoom;
                break;
            case 2:
                selectedRoom = doubleRoom;
                break;
            case 3:
                selectedRoom = suiteRoom;
                break;
            default:
                System.out.println("Invalid selection. Defaulting to Single Room.");
                selectedRoom = singleRoom;
        }

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

