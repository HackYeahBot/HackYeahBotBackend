package pl.hackyeah.bot.hackyeahbot.booking.seats.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.Seat;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.SeatsResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.TravelClass;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatsBookingServiceImplementation implements SeatsBookingService {

    private static final String BUSINESS_BENEFITS = "Cosy place, extra meal, free coffee and all benefits of premium economic";
    private static final String PREMIUM_ECONOMIC_BENEFITS = "Additional space and tv screen";
    private static final String BUSINESS = TravelClass.BUSINESS.getTravelClassName();
    private static final String ECONOMIC = TravelClass.ECONOMIC.getTravelClassName();
    private static final String PREMIUM_ECONOMIC = TravelClass.PREMIUM_ECONOMIC.getTravelClassName();

    @Autowired
    SeatRepository seatRepository;

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

        List<Seat> availableSeats = findAllAvailableSeats();

        List<SeatInformationDTO> highlightedSeats = availableSeats.stream()
                .filter(seat -> seat.getSeatClass().equals(BUSINESS))
                .map(seat -> new SeatInformationDTO(seat.getX(), seat.getY(), seat.getSeatClass(), seat.getPrice(), seat.getBenefits())).collect(Collectors.toList());

        List<SeatInformationDTO> regularSeats = availableSeats.stream()
                .filter(seat -> seat.getSeatClass().equals(ECONOMIC) || seat.getSeatClass().equals(PREMIUM_ECONOMIC))
                .map(seat -> new SeatInformationDTO(seat.getX(), seat.getY(), seat.getSeatClass(), seat.getPrice(), seat.getBenefits())).collect(Collectors.toList());

        return new SeatsResultDTO(highlightedSeats, regularSeats);
    }

    private SeatsResultDTO getFamilySeats() {
        List<Seat> availableSeats = findAllAvailableSeats();

        List<SeatInformationDTO> highlightedSeats = availableSeats.stream()
                .filter(seat -> seat.getSeatClass().equals(ECONOMIC))
                .map(seat -> new SeatInformationDTO(seat.getX(), seat.getY(), seat.getSeatClass(), seat.getPrice(), seat.getBenefits())).collect(Collectors.toList());

        List<SeatInformationDTO> regularSeats = availableSeats.stream()
                .filter(seat -> seat.getSeatClass().equals(BUSINESS) || seat.getSeatClass().equals(BUSINESS_BENEFITS))
                .map(seat -> new SeatInformationDTO(seat.getX(), seat.getY(), seat.getSeatClass(), seat.getPrice(), seat.getBenefits())).collect(Collectors.toList());

        return new SeatsResultDTO(highlightedSeats, regularSeats);
    }

    private SeatsResultDTO getLongFlySeats() {

        List<Seat> availableSeats = findAllAvailableSeats();

        List<SeatInformationDTO> highlightedSeats = availableSeats.stream()
                .filter(seat -> seat.getSeatClass().equals(BUSINESS) || seat.getSeatClass().equals(PREMIUM_ECONOMIC))
                .map(seat -> new SeatInformationDTO(seat.getX(), seat.getY(), seat.getSeatClass(), seat.getPrice(), seat.getBenefits())).collect(Collectors.toList());

        List<SeatInformationDTO> regularSeats = availableSeats.stream()
                .filter(seat -> seat.getSeatClass().equals(ECONOMIC))
                .map(seat -> new SeatInformationDTO(seat.getX(), seat.getY(), seat.getSeatClass(), seat.getPrice(), seat.getBenefits())).collect(Collectors.toList());

        return new SeatsResultDTO(highlightedSeats, regularSeats);
    }

    private SeatsResultDTO getDefaultSeats() {
        List<Seat> availableSeats = findAllAvailableSeats();

        List<SeatInformationDTO> highlightedSeats = Collections.emptyList();

        List<SeatInformationDTO> regularSeats = availableSeats.stream()
                .map(seat -> new SeatInformationDTO(seat.getX(), seat.getY(), seat.getSeatClass(), seat.getPrice(), seat.getBenefits())).collect(Collectors.toList());


        return new SeatsResultDTO(highlightedSeats, regularSeats);

    }

    private List<Seat> findAllAvailableSeats() {
        return seatRepository.findByBooked(true);
    }

    public SeatRepository getSeatRepository() {
        return seatRepository;
    }

    public void setSeatRepository(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }
}
