import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Hotel hotel = new Hotel("Sunrise Hotel");

        hotel.addRoom(new StandardRoom(101, 2000));
        hotel.addRoom(new StandardRoom(102, 2000));
        hotel.addRoom(new StandardRoom(103, 2000));
        hotel.addRoom(new DeluxeRoom(201, 3500));
        hotel.addRoom(new DeluxeRoom(202, 3500));

        System.out.println("================================");
        System.out.println("WELCOME TO " + hotel.getHotelName());
        System.out.println("================================");

        while (true) {
            System.out.println("\n=========== MENU ===========");
            System.out.println("1. Book room");
            System.out.println("2. Add room");
            System.out.println("3. Update room price");
            System.out.println("4. View available rooms");
            System.out.println("5. View all rooms");
            System.out.println("6. View bookings");
            System.out.println("7. Cancel booking");
            System.out.println("8. Exit");
            System.out.print("Choose: ");

            int choice = readInt(input);

            if (choice == 1) {
                bookRoomFlow(input, hotel);
            } else if (choice == 2) {
                addRoomFlow(input, hotel);
            } else if (choice == 3) {
                updatePriceFlow(input, hotel);
            } else if (choice == 4) {
                hotel.showRoomTypes();

                System.out.print("Choose room type: ");
                int typeChoice = readInt(input);

                if (typeChoice == 1 || typeChoice == 2) {
                    hotel.showAvailableRooms(typeChoice);
                } else {
                    System.out.println("Invalid room type.");
                }
            } else if (choice == 5) {
                hotel.showAllRooms();
            } else if (choice == 6) {
                hotel.showBookings();
            } else if (choice == 7) {
                System.out.print("Enter booking ID: ");
                int bookingId = readInt(input);

                boolean result = hotel.cancelBooking(bookingId);

                if (result) {
                    System.out.println("Booking cancelled.");
                } else {
                    System.out.println("Booking not found.");
                }
            } else if (choice == 8) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }

    public static void bookRoomFlow(Scanner input, Hotel hotel) {
        System.out.println("\n===== BOOK ROOM =====");

        hotel.showRoomTypes();

        System.out.print("Choose room type: ");
        int typeChoice = readInt(input);

        if (typeChoice != 1 && typeChoice != 2) {
            System.out.println("Invalid room type.");
            return;
        }

        hotel.showAvailableRooms(typeChoice);

        System.out.print("Enter room number: ");
        int roomNumber = readInt(input);

        System.out.print("Enter nights (1 - 20): ");
        int nights = readInt(input);

        if (nights < 1 || nights > 20) {
            System.out.println("Invalid nights.");
            return;
        }

        System.out.print("Enter guest name: ");
        String name = input.nextLine();

        if (name.trim().equals("")) {
            System.out.println("Guest name is required.");
            return;
        }

        System.out.print("Enter guest age: ");
        int age = readInt(input);

        if (age < 18) {
            System.out.println("You are not eligible for booking a room.");
            return;
        }

        System.out.print("Enter guest phone number: ");
        String phone = input.nextLine();

        if (phone.trim().equals("")) {
            System.out.println("Phone number is required.");
            return;
        }

        Room room = hotel.findAvailableRoom(roomNumber, typeChoice);

        if (room == null) {
            System.out.println("Room not found or already booked.");
            return;
        }

        Guest guest = new Guest(name, age, phone);
        Booking booking = hotel.createBooking(room, guest, nights);

        System.out.println("\n===== BOOKING DETAILS =====");
        booking.displayInfo();

        System.out.print("\nConfirm booking? (yes/no): ");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            boolean saved = hotel.saveBooking(booking);

            if (saved) {
                System.out.println("\nBooking successful!");
                booking.displayInfo();
            } else {
                System.out.println("Booking could not be saved.");
            }
        } else {
            System.out.println("Booking cancelled.");
        }
    }

    public static void addRoomFlow(Scanner input, Hotel hotel) {
        System.out.println("\n===== ADD ROOM =====");
        hotel.showRoomTypes();

        System.out.print("Choose room type: ");
        int typeChoice = readInt(input);

        if (typeChoice != 1 && typeChoice != 2) {
            System.out.println("Invalid room type.");
            return;
        }

        System.out.print("Enter room number: ");
        int roomNumber = readInt(input);

        boolean added = hotel.addRoom(typeChoice, roomNumber);

        if (added) {
            System.out.println("Room added successfully.");
        } else {
            System.out.println("Could not add room. Room number may already exist or list may be full.");
        }
    }

    public static void updatePriceFlow(Scanner input, Hotel hotel) {
        System.out.println("\n===== UPDATE ROOM PRICE =====");
        hotel.showRoomTypes();

        System.out.print("Choose room type: ");
        int typeChoice = readInt(input);

        if (typeChoice != 1 && typeChoice != 2) {
            System.out.println("Invalid room type.");
            return;
        }

        System.out.print("Enter new price: ");
        double newPrice = readDouble(input);

        if (newPrice <= 0) {
            System.out.println("Price cannot be negative or zero.");
            return;
        }

        boolean updated = hotel.updateRoomPrice(typeChoice, newPrice);

        if (updated) {
            System.out.println("Price is updated successfully.");
        } else {
            System.out.println("Could not update price.");
        }
    }

    public static int readInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            input.nextLine();
        }

        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    public static double readDouble(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.print("Enter a valid price: ");
            input.nextLine();
        }

        double value = input.nextDouble();
        input.nextLine();
        return value;
    }
}