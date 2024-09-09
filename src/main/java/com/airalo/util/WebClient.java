package com.airalo.util;

import com.airalo.commons.URL;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class WebClient {

    private static final RequestSpecification request;

    static {
        RestAssured.baseURI = URL.BASE_API;
        request = RestAssured.given();
    }

    public static RequestSpecification request() {
        return request;
    }
}