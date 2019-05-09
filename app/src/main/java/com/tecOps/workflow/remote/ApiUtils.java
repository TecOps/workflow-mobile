package com.tecOps.workflow.remote;

public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BASE_URL = "http://192.168.1.101:8080/";
//    public static final String BASE_URL = "http://tecops-backend.herokuapp.com/";

    public static APIService getLoginAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

    public static APIService getEventAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}