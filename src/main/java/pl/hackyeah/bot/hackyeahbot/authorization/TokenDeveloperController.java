package pl.hackyeah.bot.hackyeahbot.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hackyeah.bot.hackyeahbot.email.EmailService;

@RestController
public class TokenDeveloperController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/token")
    public Token getToken() {
        return tokenService.getBearerToken();
    }

    @GetMapping("/mail")
    public Token getMail() {
        emailService.sendConfirmationEmail("klopron@gmail.com", "TEST CLASS", 500);
        return tokenService.getBearerToken();
    }


}
