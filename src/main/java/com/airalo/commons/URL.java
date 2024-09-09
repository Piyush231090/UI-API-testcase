package com.airalo.commons;

public class URL {
    // Base URL for the Airalo Partners API
    public static final String BASE_API = "https://sandbox-partners-api.airalo.com";
    public static final String BASE_UI = "https://www.airalo.com/";

    public static class PATH {
        // Endpoint for getting OAuth tokens
        public static final String TOKEN = "/v2/token";
        // Endpoint for submitting orders
        public static final String ORDER = "/v2/orders";
        // Endpoint for retrieving a list of SIMs
        public static final String LIST = "/v2/sims";
    }
}