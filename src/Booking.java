public class Booking {
    private int bookingId;
    private Guest guest;
    private Room room;
    private int nights;
    private double totalPrice;

    public Booking(int bookingId, Guest guest, Room room, int nights) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.nights = nights;
        this.totalPrice = room.calculatePrice(nights);
    }

    public int getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void displayInfo() {
        System.out.println("Booking ID : " + bookingId);
        System.out.println("Guest Name : " + guest.getName());
        System.out.println("Age        : " + guest.getAge());
        System.out.println("Phone      : " + guest.getPhone());
        System.out.println("Room No    : " + room.getRoomNumber());
        System.out.println("Room Type  : " + room.getRoomType());
        System.out.println("Nights     : " + nights);
        System.out.println("Total Price: " + totalPrice + " ETB");
    }
}