package com.xpzones.net;

import com.xpzones.constants.Constants;

public class NetConfig {

    /**
     * H5界面
     */
    public class Html {

    }

    /**
     * 网络请求Url
     */
    public static class Url {

        //自己服务器IP
        public static String MY_SERVICE_URL = "http://appapi.xspatium.com";

        //服务器地址
        interface BaseUrl {
            String SERVER_DEVELOP = "http://appapi.xspatium.com";
            String SERVER_TEST = "";
            String SERVER_PRODUCTION = "";
        }

        /**
         * 返回服务器基础地址
         */
        static String getBaseUrl() {
            switch (Constants.SERVER_TYPE) {
                case Constants.ServerType.SERVER_DEVELOP:
                    return BaseUrl.SERVER_DEVELOP;
                case Constants.ServerType.SERVER_TEST:
                    return BaseUrl.SERVER_TEST;
                case Constants.ServerType.SERVER_PRODUCTION:
                    return BaseUrl.SERVER_PRODUCTION;
            }
            return BaseUrl.SERVER_PRODUCTION;
        }

        static String GetMallAreaByDistictCode = getBaseUrl() + "/api/area/GetMallAreaByDistictCode";

        static String AutoLogin = getBaseUrl() + "/api/userauth/V2_AutoLogin";
    }

}