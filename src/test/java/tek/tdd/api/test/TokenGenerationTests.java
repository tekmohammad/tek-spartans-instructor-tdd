package tek.tdd.api.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.ApiTestsBase;

import java.util.HashMap;
import java.util.Map;

public class TokenGenerationTests extends ApiTestsBase {
    private static final Logger LOGGER = LogManager.getLogger(TokenGenerationTests.class);

    //Create a test validate token generated with supervisor User
    @Test(dataProvider = "credentials")
    public void generateValidToken(String username, String password) {
        RequestSpecification requestSpecification = getDefaultRequest();
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);

        requestSpecification.body(body);

        //Send request to /api/token
        Response response = requestSpecification.when().post("/api/token");
        response.then().statusCode(200);

        LOGGER.info("Response is {}", response.asPrettyString());
    }

    @DataProvider(name = "credentials")
    private String[][] credentials() {
        return new String[][]{
                {"supervisor", "tek_supervisor"},
                {"operator_readonly", "Tek4u2024"},

        };
    }

    //Activity generate token with operator user
//    username: operator_readonly
//    password: Tek4u2024
}
