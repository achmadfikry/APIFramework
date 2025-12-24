package resources;

//enum is a special class in java which has collection of contants or methods
public enum APIResources {
    AddPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    /*
    // It's same as this:
    String addPlaceAPI = "/maps/api/place/add/json";
    public String getAddPlaceAPI() {
        return addPlaceAPI;
    }
    */


    private String resource;

    //constructor
    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
