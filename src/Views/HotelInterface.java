package Views;

import Models.Room;
import Services.HotelService;

import java.util.List;
import java.util.Scanner;

public class HotelInterface {
    HotelService hotelService = new HotelService();
    final Scanner  scanner = new Scanner(System.in);


    private String getGuestName() {
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }

    private String getGuestEmail() {
        System.out.println("Enter your email: ");
        return scanner.nextLine();
    }

    private String getGuestNumber() {
        System.out.println("Enter your contact number: ");
        return scanner.nextLine();
    }

    private boolean isValidGuestData(String name, String email, String number){
        return hotelService.isAllFieldsValid(name, email, number);
    }

    private void addGuest(){
        hotelService.addGuest(getGuestName(), getGuestEmail(), getGuestNumber());
    }


    private void displayRoomOptions(){
        System.out.println("Select a room type: ");
        System.out.println("1. Single Room");
        System.out.println("2. Double Room");
        System.out.println("3. Suite Room");
    }

    private void displayMenu(){
        System.out.println("Welcome to the hotel booking system!");
        displayRoomOptions();
    }

    private Integer getRoomChoice(){
        return scanner.nextInt();
    }

    private int isRoomChoiceValid(){
      int roomChoice = getRoomChoice();
      return (roomChoice >= 1 && roomChoice <= 3) ? roomChoice : -1;
    }

    private List<Room> filterRoomsByType(Integer roomType){
        if(roomType != -1){
            hotelService.filterRoomsByType(roomType);
        }
        return null;
    }

    private Room getNextAvailableRoom(int roomType){
        return hotelService.getNextAvailableRoom(filterRoomsByType(roomType));
    }

    private void processRoomChoice(){
        int roomChoice = isRoomChoiceValid();
        Room selectedRoom ;
        switch (roomChoice) {
            case 1, 2, 3 -> {
                selectedRoom = getNextAvailableRoom(roomChoice);
                System.out.println(selectedRoom);
            }
            default ->{
                System.out.println("Invalid selection. Defaulting to Single Room.");
                selectedRoom = getNextAvailableRoom(1);
            }

        }

    }

    public void show(){
        displayMenu();
        processRoomChoice();
    }


}
