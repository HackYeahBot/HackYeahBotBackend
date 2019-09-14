package pl.hackyeah.bot.hackyeahbot.booking.seats.boundary;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatsResultDTO;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

import java.util.List;

@RestController("booking/seats")
public class SeatsBookingController {

    @PostMapping
    List<SeatsResultDTO> getSeatsForPersona(@RequestBody UserPersona userPersona) {

    }
}
