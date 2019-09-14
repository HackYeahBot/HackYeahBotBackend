package pl.hackyeah.bot.hackyeahbot.booking.extras.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hackyeah.bot.hackyeahbot.booking.extras.controller.ExtrasService;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasBookingParameters;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasBookingParametersDTO;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.ExtrasResultDTO;
import pl.hackyeah.bot.hackyeahbot.booking.seats.entity.TravelClass;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

@RestController
@RequestMapping("booking/extras")
public class ExtrasController {

    private ExtrasService extrasService;

    @PostMapping
    ExtrasResultDTO getExtrasForChosenOptions(@RequestBody ExtrasBookingParametersDTO extrasParametersDTO) {
        ExtrasBookingParameters extrasParameters = mapToExtrasBookingParameters(extrasParametersDTO);

        return extrasService.getExtrasForPersonalPreferences(extrasParameters);
    }

    private ExtrasBookingParameters mapToExtrasBookingParameters(ExtrasBookingParametersDTO extrasDTO) {
        String userPersonaText = extrasDTO.getUserPersona();
        String travelClassText = extrasDTO.getTravelClass();

        UserPersona userPersona = UserPersona.valueOf(userPersonaText);
        TravelClass travelClass = TravelClass.getByName(travelClassText);

        return new ExtrasBookingParameters(userPersona, travelClass);
    }

    public ExtrasService getExtrasService() {
        return extrasService;
    }

    @Autowired
    public void setExtrasService(ExtrasService extrasService) {
        this.extrasService = extrasService;
    }
}
