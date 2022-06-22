package APISettings;

public class APISetup {
    private static final String APIkey = "c2d5a16100938752b5140abd632f4beb";

    public static final String baseUrl = "https://api.openweathermap.org";
    public static final String weatherByCoord = "/data/2.5/weather?";
    public static final String forecast = "/data/2.5/forecast?";

    public static String getAPIkey() {
        return APIkey;
    }



}
