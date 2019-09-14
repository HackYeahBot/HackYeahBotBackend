package pl.hackyeah.bot.hackyeahbot.booking.extras.entity;

public class ExtrasBookingParametersDTO {

    private String userPersona;
    private String travelClass;

    public String getUserPersona() {
        return userPersona;
    }

    public void setUserPersona(String userPersona) {
        this.userPersona = userPersona;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }
}
