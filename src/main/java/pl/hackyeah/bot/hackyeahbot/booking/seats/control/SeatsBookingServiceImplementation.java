package pl.hackyeah.bot.hackyeahbot.booking.seats.control;

import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatsResultDTO;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

import java.util.List;

@Service
public class SeatsBookingServiceImplementation implements SeatsBookingService {

    private static final String BUSINESS_BENEFITS = "Cosy place, extra meal, free coffee and all benefits of premium economic";
    private static final String PREMIUM_ECONOMIC_BENEFITS = "Additional space and tv screen";
    public static final String BUSINESS = "business";
    public static final String ECONOMIC = "economic";
    public static final String PREMIUM_ECONOMIC = "premium-economic";

    @Override
    public List<SeatsResultDTO> getSeatsForPersona(UserPersona userPersona) {
        List<SeatsResultDTO> seatsResultDTOS;

         switch (userPersona) {
            case FAMILY:
                seatsResultDTOS = getFamilySeats();
                break;
            case BUSINESS:
                seatsResultDTOS = getBusinessSeats();
                break;
            case LONG_FLY:
                seatsResultDTOS = getLongFlySeats();
                break;
            default:
                seatsResultDTOS = getDefaultSeats();
                break;
        }

        return seatsResultDTOS;
    }

    private List<SeatsResultDTO> getBusinessSeats() {

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


    }

    private List<SeatsResultDTO> getFamilySeats() {
    }

    private List<SeatsResultDTO> getLongFlySeats() {
    }

    private List<SeatsResultDTO> getDefaultSeats() {
    }
}
