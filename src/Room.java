public class Room {
    private int roomNumber;
    private double pricePerNight;
    private boolean available;

    public Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        if (roomNumber > 0) {
            this.roomNumber = roomNumber;
        }
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight > 0) {
            this.pricePerNight = pricePerNight;
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getRoomType() {
        return "Room";
    }

    public double calculatePrice(int nights) {
        return pricePerNight * nights;
    }

    public void displayShortInfo() {
        System.out.println(
                "Room " + roomNumber +
                        " - " + getRoomType() +
                        " - Price: " + pricePerNight
        );
    }

    public void displayInfo() {
        System.out.println("Room Type : " + getRoomType());
        System.out.println("Room No   : " + roomNumber);
        System.out.println("Price     : " + pricePerNight);

        if (available) {
            System.out.println("Available : Yes");
        } else {
            System.out.println("Available : No");
        }
    }
}