package com.tecOps.workflow.remote;

public class ApiUtils {

    private ApiUtils() {
    }

//    public static final String BASE_URL = "http://192.168.43.216:8080/";
    public static final String BASE_URL = "http://www.mocky.io/v2/5ccd14eb2e0000ce0f1829b1/";

    public static APIService getLoginAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

    public static APIService getEventAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}