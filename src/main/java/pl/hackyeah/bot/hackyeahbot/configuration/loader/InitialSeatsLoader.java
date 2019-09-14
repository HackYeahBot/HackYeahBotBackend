package pl.hackyeah.bot.hackyeahbot.configuration.loader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class InitialSeatsLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean isDataAlreadyLoaded = false;
//    private SeatsRepository seatsRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        if(isDataAlreadyLoaded) {
//            return;
//        }
//
////        Set<Seat> seatsToLoad = Set.of(
////                /*
////                    Tutaj wszystkie siedzenie jakie chcemy dodać do bazy
////
////
////                 */
////        )
//
//
//
//        //przeiterować po każdym i sprawdzić czy już istnieje
//        //chyba że da się jakoś bulkowo
//        seatsToLoad.stream().forEach(this::createSeatIfNotFoundOrReturnExisting);
//
//        isDataAlreadyLoaded = true;
    }

//    private Seat createSeatIfNotFoundOrReturnExisting(Seat seat) {
//
//        //jakoś sprawdzamy czy istnieje, findOptional albo existsBy
//        Optional<Seat> createdSeat = seatRepository.findOptionalByXYAndAnotherInformation(seat);
//        return createdSeat.orElseGet(() -> persistSeat(//informacje potrzebne do stworzenia));
//    }
//
//    private Seat persistSeat(//informacje do stworzenia) {
//                             Seat seat = new Seat();
//
//         //tutaj ustawiamy wszystkie atrybuty do ustawienia
//
//        return seatRepository.save(seat);
//    }
//
//    @Autowired
//    public void setSeatsRepository(SeatsRepository seatsRepository) {
//        this.seatsRepository = seatsRepository;
//    }
}
