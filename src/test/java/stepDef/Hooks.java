package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        //write a code that will give you place id
        //execute this code only when place id is null
        StepDef stepDef = new StepDef();
        if(stepDef.place_id==null){
            stepDef.add_place_payload_with("Shetty", "French", "Asia");
            stepDef.user_calls_with_http_request("AddPlaceAPI", "POST");
            stepDef.verify_place_id_created_maps_to_using("Shetty", "getPlaceAPI");
        }
    }
}
