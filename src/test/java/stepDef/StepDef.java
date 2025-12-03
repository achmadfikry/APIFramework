package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDef {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;

    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload")
    public void add_place_payload() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();

        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res = given()
                .spec(req)
                .body(data.addPlacePayload());

    }
    @When("user calls {string} with post http request")
    public void user_calls_with_post_http_request(String string) {
        response = res.when()
                .post("/maps/api/place/add/json")
                .then().spec(resspec).extract().response();
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(), 200);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        String resp =  response.asString();
        JsonPath jsonPath = JsonPath.from(resp);
        assertEquals(jsonPath.get(key).toString(), value);
    }

}
