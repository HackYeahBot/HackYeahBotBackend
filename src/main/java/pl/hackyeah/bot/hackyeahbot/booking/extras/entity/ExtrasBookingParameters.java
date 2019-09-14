package pl.hackyeah.bot.hackyeahbot.booking.extras.entity;

import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.TravelClass;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

public class ExtrasBookingParameters {

    private UserPersona userPersona;
    private TravelClass travelClass;

    public ExtrasBookingParameters() {
    }

    public ExtrasBookingParameters(UserPersona userPersona, TravelClass travelClass) {
        this.userPersona = userPersona;
        this.travelClass = travelClass;
    }

    public UserPersona getUserPersona() {
        return userPersona;
    }

    public void setUserPersona(UserPersona userPersona) {
        this.userPersona = userPersona;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }
}
