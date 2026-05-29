public class Hotel {
    private String hotelName;

    private Room[] rooms;
    private Booking[] bookings;

    private int roomCount;
    private int bookingCount;
    private int nextBookingId;

    private double standardPrice;
    private double deluxePrice;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;

        rooms = new Room[20];
        bookings = new Booking[20];

        roomCount = 0;
        bookingCount = 0;
        nextBookingId = 1;

        standardPrice = 2000;
        deluxePrice = 3500;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void addRoom(Room room) {
        if (roomCount < rooms.length) {
            if (findRoomByNumber(room.getRoomNumber()) == null) {
                rooms[roomCount] = room;
                roomCount++;
                System.out.println("Room added successfully.");
            } else {
                System.out.println("Room number already exists.");
            }
        } else {
            System.out.println("Room list is full.");
        }
    }

    public boolean addRoom(int typeChoice, int roomNumber) {
        if (findRoomByNumber(roomNumber) != null) {
            return false;
        }

        if (roomCount >= rooms.length) {
            return false;
        }

        if (typeChoice == 1) {
            rooms[roomCount] = new StandardRoom(roomNumber, standardPrice);
            roomCount++;
            return true;
        } else if (typeChoice == 2) {
            rooms[roomCount] = new DeluxeRoom(roomNumber, deluxePrice);
            roomCount++;
            return true;
        }

        return false;
    }

    public void showRoomTypes() {
        System.out.println("\n===== ROOM TYPES =====");
        System.out.println("1. Standard Room - " + standardPrice + " per night");
        System.out.println("2. Deluxe Room   - " + deluxePrice + " per night");
    }

    public boolean updateRoomPrice(int typeChoice, double newPrice) {
        if (newPrice <= 0) {
            return false;
        }

        if (typeChoice == 1) {
            standardPrice = newPrice;

            for (int i = 0; i < roomCount; i++) {
                if (rooms[i].getRoomType().equals("Standard Room")) {
                    rooms[i].setPricePerNight(newPrice);
                }
            }

            return true;
        } else if (typeChoice == 2) {
            deluxePrice = newPrice;

            for (int i = 0; i < roomCount; i++) {
                if (rooms[i].getRoomType().equals("Deluxe Room")) {
                    rooms[i].setPricePerNight(newPrice);
                }
            }

            return true;
        }

        return false;
    }

    public String getTypeName(int typeChoice) {
        if (typeChoice == 1) {
            return "Standard Room";
        } else {
            return "Deluxe Room";
        }
    }

    public void showAvailableRooms(int typeChoice) {
        String typeName = getTypeName(typeChoice);
        boolean found = false;

        System.out.println("\n===== AVAILABLE ROOMS =====");

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].isAvailable()) {
                if (rooms[i].getRoomType().equals(typeName)) {
                    rooms[i].displayShortInfo();
                    found = true;
                }
            }
        }

        if (found == false) {
            System.out.println("No available " + typeName + " right now.");
        }
    }

    public void showAllRooms() {
        System.out.println("\n===== ALL ROOMS =====");

        if (roomCount == 0) {
            System.out.println("No rooms added yet.");
        } else {
            for (int i = 0; i < roomCount; i++) {
                System.out.println("--------------------");
                rooms[i].displayInfo();
            }
        }
    }

    public Room findRoomByNumber(int roomNumber) {
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomNumber() == roomNumber) {
                return rooms[i];
            }
        }

        return null;
    }

    public Room findAvailableRoom(int roomNumber, int typeChoice) {
        String typeName = getTypeName(typeChoice);

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomNumber() == roomNumber) {
                if (rooms[i].isAvailable()) {
                    if (rooms[i].getRoomType().equals(typeName)) {
                        return rooms[i];
                    }
                }
            }
        }

        return null;
    }

    public Booking createBooking(Room room, Guest guest, int nights) {
        Booking booking = new Booking(nextBookingId, guest, room, nights);
        return booking;
    }

    public boolean saveBooking(Booking booking) {
        if (bookingCount < bookings.length) {
            bookings[bookingCount] = booking;
            bookingCount++;
            booking.getRoom().setAvailable(false);
            nextBookingId++;
            return true;
        }

        return false;
    }

    public void showBookings() {
        System.out.println("\n===== BOOKINGS =====");

        if (bookingCount == 0) {
            System.out.println("No bookings yet.");
        } else {
            for (int i = 0; i < bookingCount; i++) {
                System.out.println("--------------------");
                bookings[i].displayInfo();
            }
        }
    }

    public boolean cancelBooking(int bookingId) {
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i].getBookingId() == bookingId) {
                bookings[i].getRoom().setAvailable(true);

                for (int j = i; j < bookingCount - 1; j++) {
                    bookings[j] = bookings[j + 1];
                }

                bookings[bookingCount - 1] = null;
                bookingCount--;
                return true;
            }
        }

        return false;
    }
}