package com.airalo.api.orders;

import com.airalo.api.authentication.OAuth;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderImplTest {
    private OrderImpl order;

    @Before
    public void configure() {
        OAuth.createToken();
        order = new OrderImpl();
    }

    @Test
    public void submitTest() {
        var response = order.submit(6, "merhaba-7days-1gb", "Testing submit order");
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("success", response.jsonPath().get("meta.message"));
    }

    @Test
    public void listTest() {
        int packageCount = 0;
        int page = 1;
        String next;

        try {
            do {
                var response = order.getList(page++);
                var jsonBody = new JSONObject(response.getBody().asString());
                JSONArray data = jsonBody.getJSONArray("data");

                for (var packageId : data) {
                    var dataJsonObject = (JSONObject) packageId;
                    if (dataJsonObject.has("package_id") && "merhaba-7days-1gb".equals(dataJsonObject.get("package_id"))) {
                        packageCount++;
                    }
                }

                next = jsonBody.getJSONObject("links").optString("next", null);
                if (next == null) {
                    Assert.assertEquals(6, packageCount);
                }

                Assert.assertEquals(200, response.getStatusCode());
            } while (next != null);
        } catch (Exception exception) {
            Assert.fail();
        }
    }
}