package pl.hackyeah.bot.hackyeahbot.authorization;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Service
public class TokenServiceImpl implements TokenService {

    public static final String API_URL = "https://api.lot.com/flights-dev/v2/auth/token/get";
    private Token currentToken;

    public TokenServiceImpl() {
//        currentToken = this.requestToken();
    }

//    public Token requestToken(){
    public TokenAcquireDTO requestToken(){
//        if(checkIfCurrentTokenIsStillValid())

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Api-Key", "9YFNNKS31u9gCFKPetPWdAAjEXnED0B3K18AeYgg");

        HttpEntity<String> entity = new HttpEntity<>("{\"secret_key\":\"2przp49a52\"}", headers);


        TokenAcquireDTO acquiredToken = restTemplate.postForObject(API_URL, entity, TokenAcquireDTO.class);

        return acquiredToken;
    }
}
