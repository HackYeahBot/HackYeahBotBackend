package pl.hackyeah.bot.hackyeahbot.email.weather;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class WeatherExtras {
    public static String getExtrasInCaseOfWeather(String city){

        WeatherType weatherType = getWeatherType(city);

        switch (weatherType) {
            case RAIN:
                return "Zamow taxe bo bendzie padac";
            case STORM:
                return "UWAZAJ BARDZO BO GRZMI";
            case WINDY:
                return "Potężna wichura łamie duże drzewa. Trzciną zaledwie tylko kołysze";
            case SUNNY:
                return "Pewnie nie chce Ci się iść z buta/jechać MKIEM. ZAMÓW TAKSE POLAKU";
        }
        return "";
    }

    private static WeatherType getWeatherType(String city) {
        WeatherDTO acquiredToken = getWeatherDTO(city);

        WeatherType weatherType = WeatherType.SUNNY;
        String weatherToFormat = acquiredToken.getWeather().get(0).getMain();
        if(weatherToFormat.contains("Cloud")){
            weatherType = WeatherType.WINDY;
        }else if(weatherToFormat.contains("Thunderstorm")){
            weatherType = WeatherType.STORM;
        }else if(weatherToFormat.contains("Clear")){
            weatherType = WeatherType.SUNNY;
        }else if(weatherToFormat.contains("Rain")){
            weatherType = WeatherType.RAIN;
        }
        return weatherType;
    }

    private static WeatherDTO getWeatherDTO(String city) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com");
        headers.set("x-rapidapi-key", "1627ae7762msh9cec2182c3ee3d7p116ab9jsnc76fc6e7864c");

        HttpEntity<String> entity = new HttpEntity<>("", headers);
        String url = "https://api.openweathermap.org/data/2.5/weather?appid=b957f99cf7f01dcbf1538f5cda89726d&q=" + city;
        return restTemplate.postForObject(url, entity, WeatherDTO.class);
    }
}
