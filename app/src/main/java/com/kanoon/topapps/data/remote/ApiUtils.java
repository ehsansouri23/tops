package com.kanoon.topapps.data.remote;

/**
 * Created by ehsan on 2/13/2018.
 */

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "http://insp.kanoon.ir/Top/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
