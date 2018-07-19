package io.xdag.xdagwallet.api;

import io.xdag.common.http.ApiFactory;
import io.xdag.xdagwallet.api.xdagscan.XdagScanApi;

/**
 * created by lxm on 2018/7/6.
 *
 * desc :
 */
public class ApiServer {

    private static final String BASE_URL_XDAGSCAN = "http://13.251.91.123:8888/";


    public static XdagScanApi getApi() {
        return ApiFactory.getInstance().createApi(BASE_URL_XDAGSCAN, XdagScanApi.class);
    }
}
