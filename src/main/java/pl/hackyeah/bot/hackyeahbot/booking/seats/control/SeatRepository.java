package pl.hackyeah.bot.hackyeahbot.booking.seats.control;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByBooked(Boolean booked);

    boolean existsSeatByBookedAndXAndYAndPrice(boolean isBooked, int x, int y, double price);
}
