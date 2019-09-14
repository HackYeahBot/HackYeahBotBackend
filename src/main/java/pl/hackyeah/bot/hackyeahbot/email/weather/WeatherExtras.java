package pl.hackyeah.bot.hackyeahbot.email.weather;

public class WeatherExtras {
    public static String getExtrasInCaseOfWeather(){
        // call do serwisu
        WeatherType weatherType = WeatherType.WINDY;
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
}
