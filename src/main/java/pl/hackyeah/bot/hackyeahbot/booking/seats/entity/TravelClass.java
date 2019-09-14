package pl.hackyeah.bot.hackyeahbot.booking.seats.entity;

public enum TravelClass {
    BUSINESS("business"),
    ECONOMIC("economic"),
    PREMIUM_ECONOMIC("premium-economic");

    private String travelClassName;

    TravelClass(String travelClassName) {
        this.travelClassName = travelClassName;
    }

    public String getTravelClassName() {
        return travelClassName;
    }
}
