package pl.hackyeah.bot.hackyeahbot.booking.luggage.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.control.LuggageService;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageBookingParameters;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.dto.LuggageBookingParametersDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.dto.LuggageResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.TripDuration;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

@RestController
@RequestMapping("booking/luggage")
public class LuggageController {

    LuggageService luggageService;

    @PostMapping
    LuggageResultDTO getSeatsForPersona(@RequestBody LuggageBookingParametersDTO luggage) {
        TripDuration tripDuration = TripDuration.valueOf(luggage.getTripDuration());
        UserPersona userPersona = UserPersona.valueOf(luggage.getUserPersona());
        LuggageBookingParameters bookingParameters = new LuggageBookingParameters(tripDuration, userPersona);

        return luggageService.getLuggageForPersonalPreferences(bookingParameters);
    }

    public LuggageService getLuggageService() {
        return luggageService;
    }

    @Autowired
    public void setLuggageService(LuggageService luggageService) {
        this.luggageService = luggageService;
    }
}
