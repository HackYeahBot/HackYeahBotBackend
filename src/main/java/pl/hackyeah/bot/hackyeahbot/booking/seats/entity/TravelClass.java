package pl.hackyeah.bot.hackyeahbot.booking.seats.entity;

import java.util.Arrays;

public enum TravelClass {
    BUSINESS("business"),
    ECONOMIC("economic"),
    PREMIUM_ECONOMIC("premium-economic");

    private String travelClassName;

    TravelClass(String travelClassName) {
        this.travelClassName = travelClassName;
    }

    public static TravelClass getByName(String travelClassName) {
        return Arrays.stream(TravelClass.values())
                .filter(travelClass -> travelClass.getTravelClassName().equals(travelClassName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unrecognized travel class name"));
    }

    public String getTravelClassName() {
        return travelClassName;
    }
}
