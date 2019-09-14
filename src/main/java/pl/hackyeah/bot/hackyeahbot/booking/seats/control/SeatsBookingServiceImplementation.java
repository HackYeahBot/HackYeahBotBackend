package pl.hackyeah.bot.hackyeahbot.booking.seats.control;

import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatsResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.TravelClass;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

import java.util.Collections;
import java.util.List;

@Service
public class SeatsBookingServiceImplementation implements SeatsBookingService {

    private static final String BUSINESS_BENEFITS = "Cosy place, extra meal, free coffee and all benefits of premium economic";
    private static final String PREMIUM_ECONOMIC_BENEFITS = "Additional space and tv screen";
    private static final String BUSINESS = TravelClass.BUSINESS.getTravelClassName();
    private static final String ECONOMIC = TravelClass.ECONOMIC.getTravelClassName();
    private static final String PREMIUM_ECONOMIC = TravelClass.PREMIUM_ECONOMIC.getTravelClassName();

    @Override
    public SeatsResultDTO getSeatsForPersona(UserPersona userPersona) {
        SeatsResultDTO seatsResultDTOs;

         switch (userPersona) {
            case FAMILY:
                seatsResultDTOs = getFamilySeats();
                break;
            case BUSINESS:
                seatsResultDTOs = getBusinessSeats();
                break;
            case LONG_FLY:
                seatsResultDTOs = getLongFlySeats();
                break;
            default:
                seatsResultDTOs = getDefaultSeats();
                break;
        }

        return seatsResultDTOs;
    }

    private SeatsResultDTO getBusinessSeats() {

        List<SeatInformationDTO> highlightedSeats =
                List.of(
                        new SeatInformationDTO(1, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(1, 2, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(1, 4, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(2, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(3, 6, BUSINESS, 500, BUSINESS_BENEFITS)
                );

        List<SeatInformationDTO> regularSeats =
                List.of(
                        new SeatInformationDTO(10, 1, ECONOMIC, 220),
                        new SeatInformationDTO(12, 2, ECONOMIC, 220),
                        new SeatInformationDTO(13, 2, ECONOMIC, 220),
                        new SeatInformationDTO(8, 4, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS),
                        new SeatInformationDTO(7, 1, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS),
                        new SeatInformationDTO(6, 6, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS)
                );

        return new SeatsResultDTO(highlightedSeats, regularSeats);
    }

    private SeatsResultDTO getFamilySeats() {

        List<SeatInformationDTO> highlightedSeats =
                List.of(
                    new SeatInformationDTO(10, 1, ECONOMIC, 220),
                    new SeatInformationDTO(10, 2, ECONOMIC, 220),
                    new SeatInformationDTO(10, 3, ECONOMIC, 220)
                );

        List<SeatInformationDTO> regularSeats =
                List.of(
                        new SeatInformationDTO(1, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(1, 2, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(1, 4, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(2, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(3, 6, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(8, 4, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS),
                        new SeatInformationDTO(7, 1, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS),
                        new SeatInformationDTO(6, 6, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS)
                );

        return new SeatsResultDTO(highlightedSeats, regularSeats);
    }

    private SeatsResultDTO getLongFlySeats() {

        List<SeatInformationDTO> highlightedSeats =
                List.of(
                        new SeatInformationDTO(1, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(1, 2, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(1, 4, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(2, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(3, 6, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(8, 4, PREMIUM_ECONOMIC, 360, PREMIUM_ECONOMIC_BENEFITS),
                        new SeatInformationDTO(7, 1, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS),
                        new SeatInformationDTO(6, 6, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS)
                );

        List<SeatInformationDTO> regularSeats =
                List.of(
                        new SeatInformationDTO(10, 1, ECONOMIC, 220),
                        new SeatInformationDTO(12, 2, ECONOMIC, 220),
                        new SeatInformationDTO(13, 2, ECONOMIC, 220)
                );

        return new SeatsResultDTO(highlightedSeats, regularSeats);
    }

    private SeatsResultDTO getDefaultSeats() {

        List<SeatInformationDTO> highlightedSeats = Collections.emptyList();

        List<SeatInformationDTO> regularSeats =
                List.of(
                        new SeatInformationDTO(10, 1, ECONOMIC, 220),
                        new SeatInformationDTO(12, 2, ECONOMIC, 220),
                        new SeatInformationDTO(13, 2, ECONOMIC, 220),
                        new SeatInformationDTO(1, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(1, 2, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(1, 4, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(2, 1, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(3, 6, BUSINESS, 500, BUSINESS_BENEFITS),
                        new SeatInformationDTO(8, 4, PREMIUM_ECONOMIC, 360, PREMIUM_ECONOMIC_BENEFITS),
                        new SeatInformationDTO(7, 1, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS),
                        new SeatInformationDTO(6, 6, PREMIUM_ECONOMIC, 350, PREMIUM_ECONOMIC_BENEFITS)

                );

        return new SeatsResultDTO(highlightedSeats, regularSeats);

    }
}
