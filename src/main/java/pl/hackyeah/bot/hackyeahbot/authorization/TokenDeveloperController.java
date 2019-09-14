package pl.hackyeah.bot.hackyeahbot.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenDeveloperController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/token")
    public Token getToken() {
        return tokenService.getBearerToken();
    }

}
