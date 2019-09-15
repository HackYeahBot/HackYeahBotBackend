package pl.hackyeah.bot.hackyeahbot.booking.extras.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.Extras;

public interface ExtrasRepository extends JpaRepository<Extras, Long> {

    boolean existsExtrasByLabel(String label);
}
