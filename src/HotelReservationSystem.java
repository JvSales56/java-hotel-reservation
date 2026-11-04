import java.util.Scanner;

public class HotelReservationSystem {
    private static int capacity = 10;
    private static Reservation[] reservations = new Reservation[capacity];
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

        if(reservationCount >= capacity) {
            System.out.println("The reservation system is full!");
            return;
        }

        System.out.println("Enter Guest Name: ");
        String guestName = input.nextLine().trim();

        while(guestName.isEmpty()){
            System.out.print("Name cannot be empty. Enter guest name: ");
            guestName = input.nextLine().trim();
        }

        System.out.println("Enter Room type: ");
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
            if(dailyRate < 0){
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
        if (reservationCount == 0){
            System.out.println("There are no reservations registered!");
            return;
        }

        System.out.println("\n=== Hotel Reservations Registered ===");

        for(int i = 0; i < reservationCount; i++){
            System.out.println((reservations[i].toString()));
        }
    }


    private static void searchReservation() {}
    private static void sortReservations() {}
}