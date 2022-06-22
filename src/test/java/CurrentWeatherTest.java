
import APIModels.City;
import Models.DataProvidersForAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import APISettings.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
public class CurrentWeatherTest extends DataProvidersForAPI {

    @Test(dataProvider = "DataProviderCoordinates")
    public void getWheatherByCoordinates(float coordinates[]){
        RestAssured.baseURI = APISetup.baseUrl + APISetup.weatherByCoord;

        given()
                .param("appid",APISetup.getAPIkey())
                .param("lon",coordinates[0])
                .param("lat",coordinates[1])
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("coord.lon", equalTo ( coordinates[0] ))
                .body("coord.lat", equalTo ( coordinates[1] ))
        ;
    }

    @Test(dataProvider = "DataProviderCites")
    public void getWheatherByCityName(City expectedCity){
        RestAssured.baseURI = APISetup.baseUrl + APISetup.weatherByCoord;

        given()
                .param("appid",APISetup.getAPIkey())
                .param("lon",expectedCity.getCoord().getLon())
                .param("lat",expectedCity.getCoord().getLat())
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("coord.lon", equalTo ( expectedCity.getCoord().getLon() ))
                .body("coord.lat", equalTo ( expectedCity.getCoord().getLat() ))
        ;
    }


}
