package pl.hackyeah.bot.hackyeahbot.user.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hackyeah.bot.hackyeahbot.user.control.UserService;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    UserService userService;

    @GetMapping("/persona")
    List<UserPersona> getUserPersonas() {
        return userService.getUserPersonas();
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
