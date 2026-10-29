public class Reservation {

    private String guestName;
    private String roomType;
    private int numberOfDays;
    private double dailyRate;

    public Reservation(String guestName, String roomType,
                       int numberOfDays, double dailyRate) {
        this.guestName = guestName;
        this.roomType = roomType;
        setNumberOfDays(numberOfDays);
        setDailyRate(dailyRate);
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        if (numberOfDays < 1) {
            throw new IllegalArgumentException(
                    "The number of days must be at least 1."
            );
        }

        this.numberOfDays = numberOfDays;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate <= 0) {
            throw new IllegalArgumentException(
                    "The daily rate must be greater than zero."
            );
        }

        this.dailyRate = dailyRate;
    }

    public double calculateTotalPrice() {
        return numberOfDays * dailyRate;
    }

    @Override
    public String toString() {
        return String.format(
                "Guest: %s | Room: %s | Days: %d | Daily Rate: R$ %.2f | Total: R$ %.2f",
                guestName,
                roomType,
                numberOfDays,
                dailyRate,
                calculateTotalPrice()
        );
    }
}
