import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Reservation[] reservations = new Reservation[5];

        int option;

        do {
            displayMenu();
            System.out.println("Choose an option: ");
            option = input.nextInt();

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

    private static void addReservation() {}
    private static void listReservations() {}
    private static void searchReservation() {}
    private static void sortReservations() {}
}