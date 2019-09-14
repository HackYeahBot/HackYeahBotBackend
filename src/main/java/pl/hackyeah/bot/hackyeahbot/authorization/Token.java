package pl.hackyeah.bot.hackyeahbot.authorization;

import java.util.Date;

public class Token {
    private String tokenContent;
    private int durationTime;
    private Date tokenExpirationDate;

    public String getTokenContent() {
        return tokenContent;
    }

    public void setTokenContent(String tokenContent) {
        this.tokenContent = tokenContent;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public Date getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(Date tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }
}
