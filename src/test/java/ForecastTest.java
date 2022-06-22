import APIModels.City;
import APIModels.Coord;
import Models.DataProvidersForAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import APISettings.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class ForecastTest extends DataProvidersForAPI {

    @Test(dataProvider = "DataProviderCites")
    public void testForecastByCityName(City cityExpected) throws JsonProcessingException {
        RestAssured.baseURI = APISetup.baseUrl + APISetup.forecast;
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = given()
                .param("appid",APISetup.getAPIkey())
                .param("q",cityExpected.getName())
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                //.log().all()
                .body("city", notNullValue())
                .extract().response();

        City actualCity = objectMapper.treeToValue(response.as(JsonNode.class).get("city"), City.class);

        Assert.assertTrue(actualCity.getName().equals(cityExpected.getName()));
        Assert.assertTrue(actualCity.getCountry().equals(cityExpected.getCountry()));
        Assert.assertEquals(actualCity.getCoord().getLat(), cityExpected.getCoord().getLat());
        Assert.assertEquals(actualCity.getCoord().getLon(), cityExpected.getCoord().getLon());
    }

    @Test(dataProvider = "DataProviderCites")
    public void testForecastByCoordinates(City cityExpected) throws JsonProcessingException {
        RestAssured.baseURI = APISetup.baseUrl + APISetup.forecast;
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = given()
                .param("appid",APISetup.getAPIkey())
                .param("lon",cityExpected.getCoord().getLon())
                .param("lat",cityExpected.getCoord().getLat())
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                //.log().all()
                .body("city", notNullValue())
                .extract().response();

        City actualCity = objectMapper.treeToValue(response.as(JsonNode.class).get("city"), City.class);

        Assert.assertTrue(actualCity.getName().equals(cityExpected.getName()));
        Assert.assertTrue(actualCity.getCountry().equals(cityExpected.getCountry()));
        Assert.assertEquals(actualCity.getCoord().getLat(), cityExpected.getCoord().getLat());
        Assert.assertEquals(actualCity.getCoord().getLon(), cityExpected.getCoord().getLon());
    }



    @Test(dataProvider = "DataProviderCitesNames")
    public void testForecastByCityName2(String cityParam) throws JsonProcessingException {
        RestAssured.baseURI = APISetup.baseUrl + APISetup.forecast;
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = given()
                .param("appid",APISetup.getAPIkey())
                .param("q",cityParam)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                //.log().all()
                .body("city", notNullValue())
                .extract().response();

        City actualCity = objectMapper.treeToValue(response.as(JsonNode.class).get("city"), City.class);

        System.out.println(actualCity.getCoord().getLat() + " - " + actualCity.getCoord().getLon()+ " - " + actualCity.getCountry());

        Assert.assertTrue(actualCity.getName().equals(cityParam));
    }


}
