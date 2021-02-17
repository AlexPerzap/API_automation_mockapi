package academyapi.tests;

import academyapi.util.BaseUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import academyapi.api.CoreAPI;

public class BaseTest {

    private CoreAPI coreAPI;
    protected Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setUpClass(){
        coreAPI = new CoreAPI(BaseUrl.USERS_URL.getUrl());
    }

    public CoreAPI coreApi() {
        return coreAPI;
    }

}
