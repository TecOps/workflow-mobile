package com.tecOps.workflow.remote;

public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BASE_URL = "https://tecops-backend.herokuapp.com/";

    public static APIService getLoginAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

    public static APIService getEventAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}