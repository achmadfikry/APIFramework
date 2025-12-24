package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(){
        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setName("Backline House");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setAddress("30, side layout, cohen 09");
        addPlace.setWebsite("https://rahulshettyacademy.com");
        addPlace.setLanguage("French-IN");

        List<String> list = new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        addPlace.setTypes(list);

        Location location = new Location();
        location.setLat(-38.283494);
        location.setLng(33.437362);
        addPlace.setLocation(location);

        return addPlace;
    }
    public AddPlace addPlacePayloadWith(String name, String language, String address){
        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setName(name);
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setAddress(address);
        addPlace.setWebsite("https://rahulshettyacademy.com");
        addPlace.setLanguage(language);

        List<String> list = new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        addPlace.setTypes(list);

        Location location = new Location();
        location.setLat(-38.283494);
        location.setLng(33.437362);
        addPlace.setLocation(location);

        return addPlace;
    }

    public String deletePlacePlayload(String place_id){
        return "{\n" +
                "    \"place_id\": \""+place_id+"\"\n" +
                "}\n";
    }
}
