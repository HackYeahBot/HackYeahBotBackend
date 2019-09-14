package pl.hackyeah.bot.hackyeahbot.booking.seats.entity;

import java.util.List;

public class SeatsResultDTO {

    List<SeatInformationDTO> highlightedSeats;

    List<SeatInformationDTO> regularSeats;

    public SeatsResultDTO(List<SeatInformationDTO> highlightedSeats, List<SeatInformationDTO> regularSeats) {
        this.highlightedSeats = highlightedSeats;
        this.regularSeats = regularSeats;
    }

    public List<SeatInformationDTO> getHighlightedSeats() {
        return highlightedSeats;
    }

    public void setHighlightedSeats(List<SeatInformationDTO> highlightedSeats) {
        this.highlightedSeats = highlightedSeats;
    }

    public List<SeatInformationDTO> getRegularSeats() {
        return regularSeats;
    }

    public void setRegularSeats(List<SeatInformationDTO> regularSeats) {
        this.regularSeats = regularSeats;
    }
}
