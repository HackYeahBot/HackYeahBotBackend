package pl.hackyeah.bot.hackyeahbot.booking.luggage.control;

import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageBookingParameters;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.dto.LuggageResultDTO;

public interface LuggageService {
    LuggageResultDTO getLuggageForPersonalPreferences(LuggageBookingParameters bookingParameters);

}
