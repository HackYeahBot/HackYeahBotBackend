package pl.hackyeah.bot.hackyeahbot.booking.seats.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hackyeah.bot.hackyeahbot.booking.seats.control.SeatsBookingService;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatsResultDTO;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersonaDTO;

@RestController
@RequestMapping("booking/seats")
public class SeatsBookingController {

    SeatsBookingService seatsBookingService;

    @PostMapping
    SeatsResultDTO getSeatsForPersona(@RequestBody UserPersonaDTO userPersona) {
        //TODO: it should accept enum as requestBody
        return seatsBookingService.getSeatsForPersona(UserPersona.valueOf(userPersona.getUserPersona()));
    }

    public SeatsBookingService getSeatsBookingService() {
        return seatsBookingService;
    }

    @Autowired
    public void setSeatsBookingService(SeatsBookingService seatsBookingService) {
        this.seatsBookingService = seatsBookingService;
    }
}
