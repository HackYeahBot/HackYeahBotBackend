package pl.hackyeah.bot.hackyeahbot.email;

public interface EmailService {

    void sendConfirmationEmail(String to, String flightClass, double cost);
}
