package com.tecOps.workflow.remote;

public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BASE_URL = "http://172.19.54.77:8080/user/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}