package Models;
import APIModels.City;
import APIModels.Coord;
import org.testng.annotations.DataProvider;

public class DataProvidersForAPI {
    @DataProvider
    public Object[][] DataProviderCoordinates(){
        return new Object[][]{
                {new float[]{ 30.5974F, 50.3998F}}
                ,{new float[]{30.5974F, 50.3998F}}

        };
    }

    @DataProvider
    public Object[][] DataProviderCitesNames(){
        return new Object[][]{
                {"London"}
                ,{"Kyiv"}
                ,{"Rivne"}
        };
    }
    @DataProvider
    public Object[][] DataProviderCites(){
        return new Object[][]{
                {new City("London", new Coord(51.5085, -0.1257), "GB")}
                ,{new City("Kyiv", new Coord(50.4333, 30.5167), "UA")}
                ,{new City("Rivne", new Coord(50.6231, 26.2274), "UA")}
        };
    }
}
