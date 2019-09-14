package pl.hackyeah.bot.hackyeahbot.user.control;

import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserPersona> getUserPersonas() {
        UserPersona[] userPersonas = UserPersona.values();
        List<UserPersona> userPersonaList = Arrays.asList(userPersonas);

        return new LinkedList<>(userPersonaList);
    }
}
