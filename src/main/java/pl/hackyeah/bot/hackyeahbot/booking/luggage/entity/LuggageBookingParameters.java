package pl.hackyeah.bot.hackyeahbot.booking.luggage.entity;

import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

public class LuggageBookingParameters {

    private TripDuration tripDuration;
    private UserPersona userPersona;

    public LuggageBookingParameters() {
    }

    public LuggageBookingParameters(TripDuration tripDuration, UserPersona userPersona) {
        this.tripDuration = tripDuration;
        this.userPersona = userPersona;
    }

    public TripDuration getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(TripDuration tripDuration) {
        this.tripDuration = tripDuration;
    }

    public UserPersona getUserPersona() {
        return userPersona;
    }

    public void setUserPersona(UserPersona userPersona) {
        this.userPersona = userPersona;
    }
}
