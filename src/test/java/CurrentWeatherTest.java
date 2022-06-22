
import APITests.City;
import Models.DataProvidersForAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import APISettings.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
public class CurrentWeatherTest extends DataProvidersForAPI {

    @Test(dataProvider = "DataProviderCoordinates")
    public void getWheatherByCoordinates(float coordinates[]){
        RestAssured.baseURI = APISetup.baseUrl + APISetup.weather;

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




}
