public class StandardRoom extends Room {

    public StandardRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    public String getRoomType() {
        return "Standard Room";
    }

    public double calculatePrice(int nights) {
        return super.calculatePrice(nights);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Extra     : Basic room");
    }
}