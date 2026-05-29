public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    public String getRoomType() {
        return "Deluxe Room";
    }

    public double calculatePrice(int nights) {
        return super.calculatePrice(nights);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Extra     : Better room");
    }
}