package pl.hackyeah.bot.hackyeahbot.booking.luggage.entity.dto;

import java.util.List;

public class LuggageResultDTO {
    List<LuggageInformationDTO> allLuggage;
    LuggageInformationDTO highlightedLuggage;

    public LuggageResultDTO(List<LuggageInformationDTO> allLuggage, LuggageInformationDTO highlightedLuggage) {
        this.allLuggage = allLuggage;
        this.highlightedLuggage = highlightedLuggage;
    }

    public List<LuggageInformationDTO> getAllLuggage() {
        return allLuggage;
    }

    public void setAllLuggage(List<LuggageInformationDTO> allLuggage) {
        this.allLuggage = allLuggage;
    }

    public LuggageInformationDTO getHighlightedLuggage() {
        return highlightedLuggage;
    }

    public void setHighlightedLuggage(LuggageInformationDTO highlightedLuggage) {
        this.highlightedLuggage = highlightedLuggage;
    }
}
