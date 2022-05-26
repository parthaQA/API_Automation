package enums;

public enum APIEndPoints {

    deleteVisits("/sites/visits"),
    generateToken("/v1/api/token/idToken"),
    reprocessJob("/site/job/reprocess");
    private String endPoints;

    APIEndPoints(String endPoints) {
        this.endPoints = endPoints;
    }

    public String getEndpoints(){

        return endPoints;
    }
}
