package pl.hackyeah.bot.hackyeahbot.user.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.hackyeah.bot.hackyeahbot.user.control.UserPersonalProfileService;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersona;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserPersonaDTO;
import pl.hackyeah.bot.hackyeahbot.user.entity.UserToClasifyDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@RestController
public class UserPersonalProfileController {

    @Autowired
    UserPersonalProfileService userPersonalProfileService;

    @GetMapping("/user-personal-profile")
    UserPersonaDTO getUserPersonas(@RequestBody UserToClasifyDTO userToClasifyDTO) {

        adjustSearchedUserProfile(userToClasifyDTO);

        final int indexOFMLSolution = userPersonalProfileService.getIndexOFMLSolution();
        if(indexOFMLSolution == 0){
            return new UserPersonaDTO(UserPersona.BUSINESS.toString());
        }else if(indexOFMLSolution == 1){
            return new UserPersonaDTO(UserPersona.FAMILY.toString());
        }else if(indexOFMLSolution == 2){
            return new UserPersonaDTO(UserPersona.LONG_FLY.toString());
        } else {
            return new UserPersonaDTO(UserPersona.FAMILY.toString());
        }
    }

    private void adjustSearchedUserProfile(@RequestBody UserToClasifyDTO userToClasifyDTO) {
        try {
            Path path = Paths.get("src/main/static/profile_unclassified.arff");
            Stream<String> lines = Files.lines(path);
            List<String> replaced = lines.collect(Collectors.toList());
            replaced.set(replaced.size() - 1,
                    userToClasifyDTO.getFrom() + "," +
                    userToClasifyDTO.getTo() + "," +
                    userToClasifyDTO.getAdultsNumber() + "," +
                    userToClasifyDTO.getChildNumber() + "," +
                    userToClasifyDTO.getDuration() + ",?");
            Files.write(path, replaced);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserPersonalProfileService getUserPersonalProfileService() {
        return userPersonalProfileService;
    }

    public void setUserPersonalProfileService(UserPersonalProfileService userPersonalProfileService) {
        this.userPersonalProfileService = userPersonalProfileService;
    }
}
