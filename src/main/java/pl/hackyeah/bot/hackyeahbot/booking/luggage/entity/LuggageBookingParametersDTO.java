package pl.hackyeah.bot.hackyeahbot.booking.luggage.entity;

public class LuggageBookingParametersDTO {

    private String tripDuration;
    private String userPersona;


    public String getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(String tripDuration) {
        this.tripDuration = tripDuration;
    }

    public String getUserPersona() {
        return userPersona;
    }

    public void setUserPersona(String userPersona) {
        this.userPersona = userPersona;
    }
}
