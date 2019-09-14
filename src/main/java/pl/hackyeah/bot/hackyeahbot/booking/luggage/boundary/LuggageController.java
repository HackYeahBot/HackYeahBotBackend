package pl.hackyeah.bot.hackyeahbot.booking.luggage.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.control.LuggageService;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageForTripDurationAndersonaDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.LuggageResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.TripType;
import pl.hackyeah.bot.hackyeahbot.booking.seats.control.SeatsBookingService;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatsResultDTO;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersonaDTO;

import java.util.List;

@RestController
@RequestMapping("luggage/all")
public class LuggageController {

    LuggageService luggageService;

    @PostMapping
//    @ResponseBody
    LuggageResultDTO getSeatsForPersona(@RequestBody LuggageForTripDurationAndersonaDTO luggage) {
        return luggageService.getLuggageForPersonalPreferernces(TripType.valueOf(luggage.getDuration()));
    }

    public LuggageService getLuggageService() {
        return luggageService;
    }

    @Autowired
    public void setLuggageService(LuggageService luggageService) {
        this.luggageService = luggageService;
    }
}
