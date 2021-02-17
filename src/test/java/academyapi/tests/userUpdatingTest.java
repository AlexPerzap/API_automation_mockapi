package academyapi.tests;

import academyapi.pojo.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class userUpdatingTest extends BaseTest {
    @Test(priority = 3)
    public void userUpdatingTest() {
        User pojo = new User(
                "Pepito",
                "Pérez",
                "0980980",
                "654.0",
                "payment",
                "updatedEmail@gmail.com",
                true,
                "Colombia",
                "0980980");
        Response response = coreApi().updateAnAccount("1", pojo);
        coreApi().responseCodeValidation(response,200);
    }
}
