package academyapi.tests;

import academyapi.util.BaseUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import academyapi.api.CoreAPI;

public class BaseTest {

    private CoreAPI coreAPI;
    protected Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setUpClass(){
        coreAPI = new CoreAPI(BaseUrl.USERS_URL.getUrl());
        log.info("base test setup");
    }

    public CoreAPI coreApi() {
        return coreAPI;
    }

    @AfterClass
    public void waitForNextTest() {
        try {
            Thread.sleep(7000);
        } catch (Exception exception) {
            log.info("Cause is: " + exception.getCause());
            log.info("Message is: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

}
