package academyapi.api;

import academyapi.pojo.User;
import academyapi.util.BaseUrl;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class CoreAPI {

    protected Response response;
    protected String url;

    public CoreAPI(String url){
        this.url = url;
    }

    public Response getAllAccounts() {
        return given()
                .when()
                .get(url);
    }

    public Response getRandomData() {
        return given().when().get("https://602b2e9def26b40017f1405d.mockapi.io/mock/api/bank/randomUsers");
    }

    public Response postANewAccount(User user) {
        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(url);
    }

    public Response deleteAnAccount(String accountId) {
        return given()
                .contentType("application/json")
                .when()
                .delete(url + accountId);
    }

    public Response updateAnAccount(String accountId, User pojo) {
        return given()
                .contentType("application/json")
                .body(pojo)
                .when()
                .put(url + accountId);
    }

    public static void responseCodeValidation(Response response, int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }







}
