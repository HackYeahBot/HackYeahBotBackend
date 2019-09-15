package pl.hackyeah.bot.hackyeahbot.user.entity;

public class UserPersonaDTO {

    private String userPersona;

    public UserPersonaDTO() {
    }

    public UserPersonaDTO(String userPersona) {
        this.userPersona = userPersona;
    }

    public String getUserPersona() {
        return userPersona;
    }

    public void setUserPersona(String userPersona) {
        this.userPersona = userPersona;
    }
}
