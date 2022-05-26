package stepsDefinitions;

import enums.APIEndPoints;
import utils.LogUtil;
import utils.ReadData;

import utils.SpecBuilder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Delete_Visits;
import pojos.Generate_token;
import pojos.Reprocess_Job;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class StepsDef extends SpecBuilder {

    public String token= "";
    RequestSpecification res, reqs;
    Generate_token generate_token = new Generate_token();
    Delete_Visits delete_visits = new Delete_Visits();
    Reprocess_Job reprocess_job = new Reprocess_Job();
    Response response, responseStatus;



    @Given("Generate token by passing payload email, password and tenantId")
    public void generate_Token_By_Passing_Payload_Email_Password_And_TenantId(DataTable dataTable) throws IOException {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        generate_token.setEmail(data.get(0).get("email"));
        generate_token.setPassword(data.get(0).get("password"));
        generate_token.setTenantId(data.get(0).get("tenantId"));
        res = given().baseUri(ReadData.readData("Token_url")).contentType(ContentType.JSON).body(generate_token);
    }


    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String endPoint, String method) {

        APIEndPoints apiEndPoints = APIEndPoints.valueOf(endPoint);

        switch (method)
        {
            case "POST":
                response = res.when().post(apiEndPoints.getEndpoints());
                break;
            case "PUT":
                response = res.when().put(apiEndPoints.getEndpoints());
                break;
            case "GET":
                response = res.when().get(apiEndPoints.getEndpoints());
                break;
            case "DELETE":
                response = res.when().delete(apiEndPoints.getEndpoints());
                break;
        }

    }

    @Then("the API gets response with status code {int}")
    public void the_API_Gets_Response_With_StatusCode(int statusCode) {
        responseStatus = response.then().spec(SpecBuilder.responseSpecification(statusCode)).extract().response();
        LogUtil.logInfo(responseStatus.getBody().asString());
    }

    @Then("user is able to fetch IdToken from response body")
    public void user_is_able_to_fetch_id_token_from_response_body() {
        generate_token = responseStatus.as(Generate_token.class);
        LogUtil.logInfo(generate_token.getIdToken());


    }


    @Given("User pass delete visits payload to http request")
    public void user_pass_delete_visits_payload_to_http_request(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        delete_visits.setSiteId(data.get(0).get("siteId"));
        delete_visits.setStartDate(data.get(0).get("startDate"));
        delete_visits.setEndDate(data.get(0).get("endDate"));
        delete_visits.setUser(data.get(0).get("user"));
        delete_visits.setComment(data.get(0).get("comment"));
    }

    @When("User pass the {string} tenant id and id token as headers in {string} http request")
    public void user_pass_the_tenant_id_and_id_token_as_headers_in_http_request(String tenantId, String request) throws IOException {

        switch (request)
        {
            case "delete_visits":
                res = given().spec(SpecBuilder.requestSpecification(generate_token.getIdToken(), tenantId)).body(delete_visits);
                break;
            case "reprocess_job":
                res = given().spec(SpecBuilder.requestSpecification(generate_token.getIdToken(), tenantId)).body(reprocess_job);
                break;

        }
    }



    @Given("User pass the reprocess job payload to http request")
    public void user_pass_the_reprocess_job_payload_to_http_request(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        reprocess_job.setSite_Id(data.get(0).get("site_id"));
        reprocess_job.setDate_range(data.get(0).get("date_range"));
        reprocess_job.setType(data.get(0).get("type"));

    }



}

