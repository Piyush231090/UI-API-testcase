package com.airalo.api.authentication;

import com.airalo.commons.URL;
import com.airalo.util.WebClient;

/**
 * The OAuth class handles the creation and retrieval of OAuth tokens.
 */
public class OAuth {

    private static String token;

    /**
     * Creates an OAuth token using client credentials.
     * The token is stored in a static variable for later retrieval.
     */
    public static void createToken() {
        String CLIENT_ID = "7e29e2facf83359855f746fc490443e6";
        String CLINT_SECRET = "e5NNajm6jNAzrWsKoAdr41WfDiMeS1l6IcGdhmbb";
        token = WebClient.request().header("Accept", "application/json")
                .formParam("client_id", CLIENT_ID)
                .formParam("client_secret", CLINT_SECRET)
                .formParam("grant_type", "client_credentials")
                .post(URL.BASE_API + URL.PATH.TOKEN).jsonPath().get("data.access_token");
    }

    /**
     * Retrieves the OAuth token.
     *
     * @return the OAuth token as a String
     */
    public static String obtain() {
        return token;
    }
}