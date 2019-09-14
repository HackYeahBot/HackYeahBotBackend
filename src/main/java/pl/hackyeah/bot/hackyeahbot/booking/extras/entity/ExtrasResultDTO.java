package pl.hackyeah.bot.hackyeahbot.booking.extras.entity;

import java.util.Set;

public class ExtrasResultDTO {

    private Set<ExtrasInformationDTO> highlightedExtras;
    private Set<ExtrasInformationDTO> regularExtras;

    public ExtrasResultDTO() {
    }

    public ExtrasResultDTO(Set<ExtrasInformationDTO> highlightedExtras, Set<ExtrasInformationDTO> regularExtras) {
        this.highlightedExtras = highlightedExtras;
        this.regularExtras = regularExtras;
    }

    public Set<ExtrasInformationDTO> getHighlightedExtras() {
        return highlightedExtras;
    }

    public void setHighlightedExtras(Set<ExtrasInformationDTO> highlightedExtras) {
        this.highlightedExtras = highlightedExtras;
    }

    public Set<ExtrasInformationDTO> getRegularExtras() {
        return regularExtras;
    }

    public void setRegularExtras(Set<ExtrasInformationDTO> regularExtras) {
        this.regularExtras = regularExtras;
    }
}
