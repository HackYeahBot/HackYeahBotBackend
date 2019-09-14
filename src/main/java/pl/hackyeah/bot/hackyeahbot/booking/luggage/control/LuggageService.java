package pl.hackyeah.bot.hackyeahbot.booking.luggage.control;

import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageBookingParameters;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.TripDuration;

public interface LuggageService {
    public LuggageResultDTO getLuggageForPersonalPreferences(LuggageBookingParameters bookingParameters);

}
