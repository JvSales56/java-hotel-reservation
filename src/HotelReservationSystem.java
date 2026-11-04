import java.util.Scanner;

public class HotelReservationSystem {
    private static int CAPACITY = 10;
    private static Reservation[] reservations = new Reservation[CAPACITY];
    private static int reservationCount = 0;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args){



        int option;

        do {
            displayMenu();
            System.out.println("Choose an option: ");
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    addReservation();
                    break;
                case 2:
                    listReservations();
                    break;
                case 3:
                    searchReservation();
                    break;
                case 4:
                    sortReservations();
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 5);
        input.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Hotel Reservation System ===");
        System.out.println("1. New Reservation");
        System.out.println("2. List Reservations");
        System.out.println("3. Search Reservation by Guest Name");
        System.out.println("4. Sort Reservations by Number of Days");
        System.out.println("5. Exit");
    }

    private static void addReservation() {

        if(reservationCount >= CAPACITY) {
            System.out.println("The reservation system is full!");
            return;
        }

        System.out.println("Enter guest name: ");
        String guestName = input.nextLine().trim();

        while(guestName.isEmpty()){
            System.out.print("Name cannot be empty. Enter guest name: ");
            guestName = input.nextLine().trim();
        }

        System.out.println("Enter room type: ");
        String roomType = input.nextLine().trim();

        while(roomType.isEmpty()){
            System.out.println("Room type cannot be empty. Enter room type: ");
            roomType = input.nextLine().trim();
        }

        int numberOfDays = 0;
        do{
            System.out.println("How many days: ");
            numberOfDays = Integer.parseInt(input.nextLine().trim());
            if(numberOfDays < 1){
                System.out.println("The number of days must be at least 1.");
            }
        }while(numberOfDays < 1);

        double dailyRate = 0;
        do{
            System.out.println("Enter the daily rate: R$ ");
            dailyRate = Double.parseDouble(input.nextLine());
            if(dailyRate <= 0){
                System.out.println("The daily rate must be greater than zero.");
            }
        }while(dailyRate <= 0);

        Reservation reservation = new Reservation(
                guestName,
                roomType,
                numberOfDays,
                dailyRate
        );

        reservations[reservationCount] = reservation;
        reservationCount++;

        System.out.println("Reservation registered successfully!");

    }

    private static void listReservations() {
        if (hasNoReservations()) {
            return;
        }

        System.out.println("\n=== Registered Hotel Reservations ===");

        for(int i = 0; i < reservationCount; i++){
            System.out.println((reservations[i].toString()));
        }
    }

    private static void searchReservation() {
        if (hasNoReservations()) {
            return;
        }

        String guestName = "";
        do{
            System.out.println("Enter Guest Name: ");
            guestName = input.nextLine().trim();

            if(guestName.isEmpty()){
                System.out.println("Name cannot be empty.");
            }
        }while(guestName.isEmpty());

        System.out.println("\n=== Search Results ===");

        boolean found = false;

        for(int i = 0; i < reservationCount; i++){
            if (reservations[i].getGuestName().toLowerCase().contains(guestName.toLowerCase())){
                System.out.println((reservations[i].toString()));
                found = true;
            }
        }

        if(!found){
            System.out.println("No reservations found for that guest.");
        }
    }

    private static void sortReservations() {
        if (hasNoReservations()) {
            return;
        }

        bubbleSortDesc();

        System.out.println("\n=== Reservations Sorted by Number of Days ===");

        for(int i = 0; i < reservationCount; i++){
            System.out.println(reservations[i].toString());
        }
    }

    private static boolean hasNoReservations(){
        if(reservationCount == 0){
            System.out.println("There are no reservations registered!");
            return true;
        }
        return false;
    }

    private static void bubbleSortDesc() {
        for (int i = 0; i < reservationCount - 1; i++) {
            for (int j = 0; j < reservationCount - 1 - i; j++) {
                if (reservations[j].getNumberOfDays() < reservations[j + 1].getNumberOfDays()) {
                    Reservation temp = reservations[j];
                    reservations[j] = reservations[j + 1];
                    reservations[j + 1] = temp;
                }
            }
        }
    }
}