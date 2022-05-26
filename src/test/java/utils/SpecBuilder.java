package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SpecBuilder {


    public static RequestSpecification requestSpecification() throws IOException {

        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        return new RequestSpecBuilder().addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).setBaseUri(ReadData.readData("Base_url")).setContentType(ContentType.JSON).build();

    }

    public static RequestSpecification requestSpecification(String token, String tenantId) throws IOException {

        return new RequestSpecBuilder().addRequestSpecification(requestSpecification()).addHeaders(RequestUtils.setHeader(token,tenantId)).build();

    }

    public static ResponseSpecification responseSpecification(int status) {
        return new ResponseSpecBuilder().expectStatusCode(status).build();
    }


}

