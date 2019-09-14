package pl.hackyeah.bot.hackyeahbot.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static pl.hackyeah.bot.hackyeahbot.email.danger.CommonDangerInThatRegion.getCommonDangerInfoInRegion;
import static pl.hackyeah.bot.hackyeahbot.email.vaccine.NecessaryVaccinesInTrip.getNecessaryVaccinesInTrip;
import static pl.hackyeah.bot.hackyeahbot.email.weather.WeatherExtras.getExtrasInCaseOfWeather;

@Service
public class EmailServiceImpl implements EmailService {


    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void sendConfirmationEmail(String to, String flightClass, double cost){
        MimeMessage message = emailSender.createMimeMessage();
        String title = "Flight confirmation";
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);

            helper.setSubject(title);

            String body = generateConfirmMessageBody(flightClass, cost);
            helper.setText(body, true);

        }
        catch(MessagingException e){
        }

        emailSender.send(message);
    }

    private String generateConfirmMessageBody(String flightClass, double cost){
        return "You have just been robbed by flight company <br>" +
                "WEATHER INFO: <br>" +
                getExtrasInCaseOfWeather() +
                "<br>" +
                "DANGER INFO:" +
                getCommonDangerInfoInRegion("LONDON") +
                "<br>" +
                "VACCINES INFO: <br>" +
                getNecessaryVaccinesInTrip("LONDON") +
                "<br>" +
                "";
    }

}
