package academyapi.tests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * First API test
 *
 * @author Brayhan.Criollo
 */
public class EndpointEmptinessTest extends BaseTest {

    @Test (priority = 1)
    public void endpointEmptinessTest() {
        Response getResponse = coreApi().getAllAccounts();
        System.out.println(coreApi().getAllAccounts().getStatusCode());
        coreApi().responseCodeValidation(getResponse,200);
        //getResponse.prettyPrint();

        JSONArray data = new JSONArray(getResponse.getBody().asString());
        for (int i = 0; i < data.length(); i++) {
            JSONObject obj = data.getJSONObject(i);
            log.info((String) obj.get("id"));
            Response deleteResponse = coreApi().deleteAnAccount((String) obj.get("id"));
            System.out.println(deleteResponse.getStatusCode());
            coreApi().responseCodeValidation(deleteResponse,200);
        }

            /*Assert.assertEquals(coreApi().getStatusCode_custom(), 200, "Connection error");
            coreApi().isEmpty();
            Thread.sleep(1000);*/

    }


}

