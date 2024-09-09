package com.airalo.api.orders;

import com.airalo.api.authentication.OAuth;
import com.airalo.commons.URL;
import com.airalo.util.WebClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

/**
 * Implementation of the Orders interface.
 * Provides methods to submit orders and retrieve order lists.
 */
public class OrderImpl implements Orders {

    /**
     * Submits an order with the given details.
     *
     * @param quantity    the quantity of the order
     * @param packageId   the package ID of the order
     * @param description the description of the order
     * @return the response from the server
     */
    @Override
    public Response submit(int quantity, String packageId, String description) {
        return createRequest()
                .formParams(Map.of(
                        "quantity", quantity,
                        "package_id", packageId,
                        "type", "sim",
                        "description", description
                ))
                .post(URL.BASE_API + URL.PATH.ORDER);
    }

    /**
     * Retrieves the list of orders without pagination.
     *
     * @return the response from the server
     */
    @Override
    public Response getList() {
        return createRequest()
                .get(URL.BASE_API + URL.PATH.LIST);
    }

    /**
     * Retrieves the list of orders with pagination.
     *
     * @param page the page number to retrieve
     * @return the response from the server
     */
    public Response getList(int page) {
        return createRequest()
                .param("page", page)
                .get(URL.BASE_API + URL.PATH.LIST);
    }

    /**
     * Creates a request with common headers.
     *
     * @return the request specification
     */
    private RequestSpecification createRequest() {
        return WebClient.request()
                .headers(Map.of(
                        "Accept", "application/json",
                        "Authorization", "Bearer " + OAuth.obtain()
                ));
    }
}