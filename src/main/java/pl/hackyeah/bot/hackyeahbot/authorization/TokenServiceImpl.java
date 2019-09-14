package pl.hackyeah.bot.hackyeahbot.authorization;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;


@Service
public class TokenServiceImpl implements TokenService {

    public static final String API_URL = "https://api.lot.com/flights-dev/v2/auth/token/get";
    public static final String API_KEY_HEADER = "X-Api-Key";
    public static final String API_KEY_VALUE = "9YFNNKS31u9gCFKPetPWdAAjEXnED0B3K18AeYgg";
    public static String SECRET_KEY = "{\"secret_key\":\"2przp49a52\"}";

    private Token currentToken;

    public TokenServiceImpl() {
        currentToken = requestNewToken();
    }

    public Token getBearerToken(){
        if(!checkIfCurrentTokenIsStillValid()) {
            this.currentToken = requestNewToken();
        }

        return currentToken;
    }

    private boolean checkIfCurrentTokenIsStillValid() {
        Date actualServerTimeStamp = new Date();
        final Date tokenExpirationDate = this.currentToken.getTokenExpirationDate();
        return actualServerTimeStamp.before(tokenExpirationDate);
    }

    private Token requestNewToken() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(API_KEY_HEADER, API_KEY_VALUE);

        final String secretKeyJson = SECRET_KEY;
        HttpEntity<String> entity = new HttpEntity<>(secretKeyJson, headers);

        TokenAcquireDTO acquiredToken = restTemplate.postForObject(API_URL, entity, TokenAcquireDTO.class);

        return mapToToken(acquiredToken);
    }

    private Token mapToToken(TokenAcquireDTO acquiredToken) {
        int tokenExpiresInSeconds = acquiredToken.getExpires_in();
        int tokenExpiresInMillisecond = tokenExpiresInSeconds * 1000;
        Date actualServerTimeStamp = new Date();
        actualServerTimeStamp.setTime(actualServerTimeStamp.getTime() + tokenExpiresInMillisecond);

        Token token = new Token(acquiredToken.getAccess_token(), actualServerTimeStamp);
        return token;
    }


}
