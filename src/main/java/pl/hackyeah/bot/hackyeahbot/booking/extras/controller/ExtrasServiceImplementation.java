package pl.hackyeah.bot.hackyeahbot.booking.extras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasBookingParameters;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasInformationDTO;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.TravelClass;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.LMT;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExtrasServiceImplementation implements ExtrasService {

    @Autowired
    ExtrasRepository extrasRepository;

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
        Set<ExtrasInformationDTO> highlightedExtras = getHighlightedExtras("DINNER");
        Set<ExtrasInformationDTO> regularExtras = getRegularExtras("WIFI_EXTRAS", "STROLLER_EXTRAS");
//        Set<ExtrasInformationDTO> highlightedExtras = Set.of(DINNER_EXTRAS);
//        Set<ExtrasInformationDTO> regularExtras = Set.of(WIFI_EXTRAS, STROLLER_EXTRAS);

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }

    private ExtrasResultDTO getExtrasForFamily() {
        Set<ExtrasInformationDTO> highlightedExtras = getHighlightedExtras("STROLLER_EXTRAS");
        Set<ExtrasInformationDTO> regularExtras = getRegularExtras("WIFI_EXTRAS", "DINNER_EXTRAS");
//        Set<ExtrasInformationDTO> highlightedExtras = Set.of(STROLLER_EXTRAS);
//        Set<ExtrasInformationDTO> regularExtras = Set.of(WIFI_EXTRAS, DINNER_EXTRAS);

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }

    private ExtrasResultDTO getExtrasForUncategorized() {
        Set<ExtrasInformationDTO> highlightedExtras = getHighlightedExtras("WIFI_EXTRAS");
        Set<ExtrasInformationDTO> regularExtras = getRegularExtras("DINNER_EXTRAS", "STROLLER_EXTRAS");
//        Set<ExtrasInformationDTO> highlightedExtras = Set.of(WIFI_EXTRAS);
//        Set<ExtrasInformationDTO> regularExtras = Set.of(DINNER_EXTRAS, STROLLER_EXTRAS);

        return new ExtrasResultDTO(highlightedExtras, regularExtras);
    }

    private Set<ExtrasInformationDTO> getHighlightedExtras(String highlighted) {
        return extrasRepository.findAll().stream().filter(extra -> extra.getName().contains(highlighted))
                .map(extras -> new ExtrasInformationDTO(extras.getName(), extras.getDescription()))
                .collect(Collectors.toSet());
    }

    private Set<ExtrasInformationDTO> getRegularExtras(String... extras) {
        return extrasRepository.findAll().stream()
                .filter(extra -> {
                    for (String extraRegular :extras){
                        if(extra.getName().contains(extraRegular))
                            return true;
                    }
                    return false;
                })
                .map(extrasToMap -> new ExtrasInformationDTO(extrasToMap.getName(), extrasToMap.getDescription()))
                .collect(Collectors.toSet());
    }

    public ExtrasRepository getExtrasRepository() {
        return extrasRepository;
    }

    public void setExtrasRepository(ExtrasRepository extrasRepository) {
        this.extrasRepository = extrasRepository;
    }

}
