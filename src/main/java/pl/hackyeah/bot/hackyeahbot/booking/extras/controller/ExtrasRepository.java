package pl.hackyeah.bot.hackyeahbot.booking.extras.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.Extras;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.Seat;

public interface ExtrasRepository extends JpaRepository<Extras, Long> {
}
