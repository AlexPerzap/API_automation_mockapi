package academyapi.tests;

import academyapi.pojo.User;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostingAnAlreadyExistingEmailTest extends BaseTest{
    @Test(priority = 4)
    public void PostingAnAlreadyExistingEmailTest() {
        Response getResponse = coreApi().getAllAccounts();
        getResponse.prettyPrint();
        coreApi().responseCodeValidation(getResponse,200);
        JSONArray dataReceived = new JSONArray(getResponse.getBody().asString());
        Map<String, Boolean> emails = new HashMap<String, Boolean>();
        String email = "Jermaine60@gmail.com";
        for (int i = 0; i < dataReceived.length(); i++) {
            JSONObject obj = dataReceived.getJSONObject(i);
            emails.put((String) obj.get("email"),true);
        }
        if(emails.get(email)) {
            log.info("Error: there is already a register with the email you are trying to use.");
        } else {
            User pojo = new User(
                    "John",
                    "Smith",
                    "0980981",
                    "654.7",
                    "payment",
                    email,
                    true,
                    "Colombia",
                    "0980982");
            Response postResponse = coreApi().postANewAccount(pojo);
            coreApi().responseCodeValidation(postResponse,201);
        }
    }
}
