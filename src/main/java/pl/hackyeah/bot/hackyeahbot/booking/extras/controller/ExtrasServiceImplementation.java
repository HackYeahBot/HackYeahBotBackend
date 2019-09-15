package pl.hackyeah.bot.hackyeahbot.booking.extras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.Extras;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasBookingParameters;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.TravelClass;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExtrasServiceImplementation implements ExtrasService {

    @Autowired
    ExtrasRepository extrasRepository;

    @Override
    public ExtrasResultDTO getExtrasForPersonalPreferences(ExtrasBookingParameters bookingParameters) {
        TravelClass travelClass = bookingParameters.getTravelClass();
        UserPersona userPersona = bookingParameters.getUserPersona();

        ExtrasResultDTO extrasResultDTO;

        if(UserPersona.FAMILY.equals(userPersona)) {
            extrasResultDTO = getExtrasForFamily();
        } else if(TravelClass.BUSINESS.equals(travelClass)) {
            extrasResultDTO = getExtrasForBusiness();
        } else {
            extrasResultDTO = getExtrasForUncategorized();
        }

        return extrasResultDTO;
    }

    private ExtrasResultDTO getExtrasForBusiness() {
        Set<ExtrasInformationDTO> highlightedExtras = getHighlightedExtras("DINNER_EXTRAS");
        Set<ExtrasInformationDTO> regularExtras = getRegularExtras("WIFI_EXTRAS", "STROLLER_EXTRAS");

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }

    private ExtrasResultDTO getExtrasForFamily() {
        Set<ExtrasInformationDTO> highlightedExtras = getHighlightedExtras("STROLLER_EXTRAS");
        Set<ExtrasInformationDTO> regularExtras = getRegularExtras("WIFI_EXTRAS", "DINNER_EXTRAS");

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }

    private ExtrasResultDTO getExtrasForUncategorized() {
        Set<ExtrasInformationDTO> highlightedExtras = getHighlightedExtras("WIFI_EXTRAS");
        Set<ExtrasInformationDTO> regularExtras = getRegularExtras("DINNER_EXTRAS", "STROLLER_EXTRAS");

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }

    private Set<ExtrasInformationDTO> getHighlightedExtras(String highlighted) {
        return extrasRepository.findAll()
                .stream()
                .filter(extra -> extra.getLabel().contains(highlighted))
                .map(this::mapToDto)
                .collect(Collectors.toSet());
    }

    private Set<ExtrasInformationDTO> getRegularExtras(String... extras) {
        return extrasRepository.findAll().stream()
                .filter(extra -> {
                    for (String extraRegular :extras){
                        if(extra.getLabel().contains(extraRegular))
                            return true;
                    }
                    return false;
                })
                .map(this::mapToDto)
                .collect(Collectors.toSet());
    }

    private ExtrasInformationDTO mapToDto(Extras extras) {
        return new ExtrasInformationDTO(extras.getName(), extras.getDescription());
    }

    public ExtrasRepository getExtrasRepository() {
        return extrasRepository;
    }

    public void setExtrasRepository(ExtrasRepository extrasRepository) {
        this.extrasRepository = extrasRepository;
    }

}
