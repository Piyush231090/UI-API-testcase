package com.airalo.api.orders;

import io.restassured.response.Response;

public interface Orders {

    /**
     This endpoint allows you to submit an order to the Airalo Partners API.
     Provide the required information, such as quantity and package ID, and include optional description if needed.
    */
    Response submit(int quantity, String packageId, String description);

    /**
        This endpoint allows you to retrieve a list of your orders from the Airalo Partners API.
        By using various filters, you can customize the results to match specific criteria.
        The access token, obtained from the "Request Access Token" endpoint, should be included in the request.
     */
    Response getList();
}
