package pl.hackyeah.bot.hackyeahbot.booking.luggage.control;

import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageForTripDurationAndersonaDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.TripType;

import java.util.List;

public interface LuggageService {
    public LuggageResultDTO getLuggageForPersonalPreferernces(TripType tripType);
}
