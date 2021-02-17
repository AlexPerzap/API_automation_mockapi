package academyapi.tests;

import academyapi.pojo.User;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class emailDuplicationAfterPojoInitTest extends BaseTest{

    @Test(priority = 2)
    public void emailDuplicationAfterPojoInitTest() {
        Response getRandomDataResponse = coreApi().getRandomData();
        coreApi().responseCodeValidation(getRandomDataResponse,200);
        JSONArray dataReceived = new JSONArray(getRandomDataResponse.getBody().asString());
        Map<String, Boolean> emails = new HashMap<String, Boolean>();
        for (int i = 0; i < dataReceived.length(); i++) {
            JSONObject obj = dataReceived.getJSONObject(i);
            if (emails.get(obj.get("email")) != null) {
                log.info("Duplicated email: " + obj.get("email"));
                continue;
            } else {
                emails.put((String) obj.get("email"),true);
                User pojo = new User(
                        (String) obj.get("firstName"),
                        (String) obj.get("lastName"),
                        (String) obj.get("accountNumber"),
                        (String) obj.get("amount"),
                        (String) obj.get("transactionType"),
                        (String) obj.get("email"),
                        (Boolean) obj.get("active"),
                        (String) obj.get("country"),
                        (String) obj.get("telephone"));
                Response postResponse = coreApi().postANewAccount(pojo);
                coreApi().responseCodeValidation(postResponse,201);
            }
        }
    }

}
