package pl.hackyeah.bot.hackyeahbot.booking.extras.controller;

import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasBookingParameters;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.TravelClass;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

import java.util.Set;

@Service
public class ExtrasServiceImplementation implements ExtrasService {

    private static final ExtrasInformationDTO DINNER_EXTRAS = new ExtrasInformationDTO("Dodatkowy posiłek", "Pyszny posiłek, który umili długi lot!");
    private static final ExtrasInformationDTO WIFI_EXTRAS = new ExtrasInformationDTO("WI-FI Onboard", "Zapewniony dostęp do pokładowego WI-FI.");
    private static final ExtrasInformationDTO STROLLER_EXTRAS = new ExtrasInformationDTO("Wózek dziecięcy", "Zwiększony komfort podróży dla Twojego dziecka.");

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
        Set<ExtrasInformationDTO> highlightedExtras = Set.of(DINNER_EXTRAS);
        Set<ExtrasInformationDTO> regularExtras = Set.of(WIFI_EXTRAS, STROLLER_EXTRAS);

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }

    private ExtrasResultDTO getExtrasForFamily() {
        Set<ExtrasInformationDTO> highlightedExtras = Set.of(STROLLER_EXTRAS);
        Set<ExtrasInformationDTO> regularExtras = Set.of(WIFI_EXTRAS, DINNER_EXTRAS);

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }

    private ExtrasResultDTO getExtrasForUncategorized() {
        Set<ExtrasInformationDTO> highlightedExtras = Set.of(WIFI_EXTRAS);
        Set<ExtrasInformationDTO> regularExtras = Set.of(DINNER_EXTRAS, STROLLER_EXTRAS);

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }
}
