package pl.hackyeah.bot.hackyeahbot.configuration.loader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.hackyeah.bot.hackyeahbot.booking.extras.controller.ExtrasRepository;
import pl.hackyeah.bot.hackyeahbot.booking.extras.entity.Extras;

import java.util.List;

@Component
public class InitialExtrasLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final List<Extras> EXTRAS_TO_LOAD =
            List.of(
                    new Extras("Additional meal", "DINNER_EXTRAS", "Delicious meal great for long flight!"),
                    new Extras("WI-FI Onboard", "WIFI_EXTRAS", "Provided access to WI-FI."),
                    new Extras("Stroller", "STROLLER_EXTRAS", "Increased travel comfort for your kid.")
            );

    private boolean isDataAlreadyLoaded = false;
    private ExtrasRepository extrasRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(isDataAlreadyLoaded) {
            return;
        }

        EXTRAS_TO_LOAD.stream().forEach(this::createExtrasIfNotFound);

        isDataAlreadyLoaded = true;
    }

    private void createExtrasIfNotFound(Extras extras) {

        boolean exist = extrasRepository.existsExtrasByLabel(extras.getLabel());

        if (!exist) {
            persistSeat(extras);
        }
    }

    private Extras persistSeat(Extras seat) {
        return extrasRepository.save(seat);
    }

    @Autowired
    public void setExtrasRepository(ExtrasRepository seatsRepository) {
        this.extrasRepository = seatsRepository;
    }
}
