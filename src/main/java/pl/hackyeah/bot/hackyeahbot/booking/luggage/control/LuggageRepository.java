package pl.hackyeah.bot.hackyeahbot.booking.luggage.control;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.Luggage;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.Seat;

import java.util.List;

public interface LuggageRepository extends JpaRepository<Luggage, Long> {
    List<Luggage> findByLuggageType(String luggageType);
}
