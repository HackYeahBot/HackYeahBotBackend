package pl.hackyeah.bot.hackyeahbot.authorization;

import java.sql.Timestamp;
import java.util.Date;

public class Token {
    private String tokenContent;
    private Date tokenExpirationDate;

    public Token(String tokenContent, Date tokenExpirationDate) {
        this.tokenContent = tokenContent;
        this.tokenExpirationDate = tokenExpirationDate;
    }

    public String getTokenContent() {
        return tokenContent;
    }

    public void setTokenContent(String tokenContent) {
        this.tokenContent = tokenContent;
    }

    public Date getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(Timestamp tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }
}
