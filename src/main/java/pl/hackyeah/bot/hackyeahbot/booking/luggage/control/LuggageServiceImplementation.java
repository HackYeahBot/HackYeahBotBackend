package pl.hackyeah.bot.hackyeahbot.booking.luggage.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.*;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.dto.LuggageInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.dto.LuggageResultDTO;

import java.util.Arrays;
import java.util.List;

@Service
public class LuggageServiceImplementation implements LuggageService {

    @Autowired
    LuggageRepository luggageRepository;

    @Override
    public LuggageResultDTO getLuggageForPersonalPreferences(LuggageBookingParameters bookingParameters){
        TripDuration tripDuration = bookingParameters.getTripDuration();

        switch (tripDuration) {
            case SHORT:
                return getSmallBag();
            case MEDIUM:
                return getMediumBag();
            case LONG:
                return getLargeBag();
        }
        return getLargeBag();
    }

    private LuggageResultDTO getSmallBag(){
        return new LuggageResultDTO(getAllBags(), new LuggageInformationDTO(LuggageType.SMALL));
    }

    private LuggageResultDTO getMediumBag(){
        return new LuggageResultDTO(getAllBags(), new LuggageInformationDTO(LuggageType.MEDIUM));
    }

    private LuggageResultDTO getLargeBag(){
        return new LuggageResultDTO(getAllBags(), new LuggageInformationDTO(LuggageType.LARGE));
    }

    private List<LuggageInformationDTO> getAllBags(){
        return Arrays.asList(
                new LuggageInformationDTO(LuggageType.SMALL),
                new LuggageInformationDTO(LuggageType.MEDIUM),
                new LuggageInformationDTO(LuggageType.LARGE));
    }

    public LuggageRepository getLuggageRepository() {
        return luggageRepository;
    }

    public void setLuggageRepository(LuggageRepository luggageRepository) {
        this.luggageRepository = luggageRepository;
    }
}
