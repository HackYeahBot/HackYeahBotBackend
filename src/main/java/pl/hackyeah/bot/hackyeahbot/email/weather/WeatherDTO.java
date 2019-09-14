package pl.hackyeah.bot.hackyeahbot.email.weather;

import java.util.List;

public class WeatherDTO {
    List<Weather> weather;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
