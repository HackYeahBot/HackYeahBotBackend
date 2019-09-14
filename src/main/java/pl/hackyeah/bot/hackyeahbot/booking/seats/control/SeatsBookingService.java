package pl.hackyeah.bot.hackyeahbot.booking.seats.control;

import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatsResultDTO;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

public interface SeatsBookingService {

    SeatsResultDTO getSeatsForPersona(UserPersona userPersona);
}
