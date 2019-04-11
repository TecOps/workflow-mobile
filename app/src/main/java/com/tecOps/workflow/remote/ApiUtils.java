package com.tecOps.workflow.remote;

public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BASE_URL = "http://172.19.40.77:8080/auth/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}