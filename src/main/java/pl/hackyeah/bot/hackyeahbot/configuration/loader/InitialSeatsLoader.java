package pl.hackyeah.bot.hackyeahbot.configuration.loader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.hackyeah.bot.hackyeahbot.booking.seats.control.SeatRepository;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.Seat;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.TravelClass;

import java.util.List;

@Component
public class InitialSeatsLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final String BUSINESS_BENEFITS = "Cosy place, extra meal, free coffee and all benefits of premium economic";
    private static final String PREMIUM_ECONOMIC_BENEFITS = "Additional space and tv screen";
    private static final String BUSINESS = TravelClass.BUSINESS.getTravelClassName();
    private static final String ECONOMIC = TravelClass.ECONOMIC.getTravelClassName();
    private static final String PREMIUM_ECONOMIC = TravelClass.PREMIUM_ECONOMIC.getTravelClassName();

    private static final List<Seat> SEATS_TO_LOAD =
            List.of(
                    new Seat(true, 10, 1, ECONOMIC, 220),
                    new Seat(true, 12, 2, ECONOMIC, 220),
                    new Seat(true, 13, 2, ECONOMIC, 220),
                    new Seat(true, 1, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                    new Seat(true, 1, 2, BUSINESS, 500, BUSINESS_BENEFITS),
                    new Seat(true, 1, 4, BUSINESS, 500, BUSINESS_BENEFITS),
                    new Seat(true, 2, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                    new Seat(true, 3, 6, BUSINESS, 500, BUSINESS_BENEFITS),
                    new Seat(true, 8, 4, PREMIUM_ECONOMIC, 360, PREMIUM_ECONOMIC_BENEFITS),
                    new Seat(true, 7, 1, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS),
                    new Seat(true, 6, 6, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS)

            );

    private boolean isDataAlreadyLoaded = false;
    private SeatRepository seatRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(isDataAlreadyLoaded) {
            return;
        }


        //przeiterować po każdym i sprawdzić czy już istnieje
        //chyba że da się jakoś bulkowo
        SEATS_TO_LOAD.stream().forEach(this::createSeatIfNotFound);

        isDataAlreadyLoaded = true;
    }

    private void createSeatIfNotFound(Seat seat) {

        boolean exist = seatRepository.existsSeatByBookedAndXAndYAndPrice(seat.getBooked(), seat.getX(), seat.getY(), seat.getPrice());

        if (!exist) {
            persistSeat(seat);
        }
    }

    private Seat persistSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Autowired
    public void setSeatRepository(SeatRepository seatsRepository) {
        this.seatRepository = seatsRepository;
    }
}
