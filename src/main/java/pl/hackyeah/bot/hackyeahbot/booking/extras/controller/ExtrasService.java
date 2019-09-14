package pl.hackyeah.bot.hackyeahbot.booking.extras.controller;

import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasBookingParameters;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasResultDTO;

public interface ExtrasService {
    ExtrasResultDTO getExtrasForPersonalPreferences(ExtrasBookingParameters bookingParameters);
}
