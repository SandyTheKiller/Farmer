package com.yoga.farmer.constants;

public class C {

    public static class device {
        public static String DEVICE_SERIAL = "unidentified";
        public static String VERSION_CODE = "0";
        public static String VERSION_NAME = "undefined";
        public static final int APP_ID = 31;
    }

    public static class about {
        public static final String URL_TERMS = "http://www.dsij.in/home/terms.aspx";
        public static final String URL_ABOUT_US = "http://www.dsij.in/about-us.aspx";
        public static final String URL_HELP_US = "https://www.dsij.in/DesktopModules/StockMarketGame/SMC-help/getting_started.html";
        public static final String URL_PRIVACY = "http://www.dsij.in/privacy-policy.aspx";
        public static final String URL_DISCLAIMER = "https://www.dsij.in/disclaimer";
        public static final String URL_PRIZES = "https://www.dsij.in/prizes";
        public static final String EMAIL_CONTACT_US = "rajeshp@dsij.in";
    }

    public static final String SHARE_SUBJECT = "Hey, ..............";

    public static class url {
        public static final String BASE_URL_DSIJ = "http://192.168.1.101";//VOLLEY
        //public static final String BASE_URL_DSIJ = "http://narayaneducationalpoint.com";//VOLLEY
        public static final String API_BASE_URL = "http://narayaneducationalpoint.com";//RETROFIT
    }

    public static class net {
        public static final int NETWORK_AVAILABLE = 1;
        public static final int NETWORK_CONNECTING = 2;
        public static final int NETWORK_DISCONNECTED = 3;

        public static class getHoldings {

            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetHoldingList";
            public static double totalMarketValue = 0;
            public static String mCashBalance = "1";
            public static final String TAG = "GetHoldingList";
        }

        public static class resetPortfolio {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/ResetPortfolio";
            public static final String TAG = "resetPortfolio";
        }

        public static class viewOtherPortfolio {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/ViewOtherPortfolio";
            public static final String TAG = "ViewOtherPortfolio";
        }

        public static class getAllJoinContest {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetAllJoinContestList";
            public static final String TAG = "getAllJoinContest";
        }

        public static class joinContest {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/JoinContest";
            public static final String TAG = "joinContest";
        }

        public static class getPortfolioMasterDetails {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetPortfolioMasterDetails";
            public static final String TAG = "Get PortfolioMasterDetails";
        }

        public static class getUserProfileDetails {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetUserProfileDetails";
            public static final String TAG = "Get UserProfileDetails";
        }

        public static class getChatHistory {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetChats";
            public static final String TAG = "Get ChatHistory";
        }

        public static class getChatScroll {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetChatScroll";
            public static final String TAG = "Get ChatScroll";
        }

        public static class InsertChat {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/InsertChat";
            public static final String TAG = "InsertChat";
            public static class error {
            }
        }

        public static class getPendingOrder {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetPendingOrders";
            public static final String TAG = "GetPendingOrders";
        }

        public static class cancelPendingOrder {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/CanclePendingOrder";
            public static final String TAG = "CanclePendingOrder";
        }

        public static class getWatchList {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetWatchlist";
            public static final String TAG = "GetWatchlist";
        }

        public static class insertWatchListCompany {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/InsertWatchListCompany";
            public static final String TAG = "InsertWatchListCompany";
        }

        public static class removeWatchListCompany {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/RemoveWatchListCompany";
            public static final String TAG = "InsertWatchListCompany";
        }

        public static class getTradingHistory {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetTradeHistory";
            public static final String TAG = "getTradingHistorys";
        }

        public static class getSoldHistory {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetSoldHistory";
            public static final String TAG = "GetSoldHistory";
        }

        public static class portfolioVsSensexPerformance {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/PortfolioVsSensexPerformance";
            public static final String TAG = "GetSoldHistory";
        }

        public static class getRankings {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/TopRankings";
            public static final String TAG = "TopRankings";
            public static boolean FLAG_CALL = true;
            public static String TAG_RANK_TYPE = "stdRank";
        }

        public static class getContestList {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetContestList";
            public static final String TAG = "GetContestList";
        }

        public static class getSelectedCompanyDetails {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetSelectedCompanyDetails";
            public static final String TAG = "GetSelectedCompanyDetails";
        }

        public static class getMyLevels {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetMyLevel";
            public static final String TAG = "GetSelectedCompanyDetails";
        }

        public static class getSearchCompany {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/SearchCompany";
            public static final String TAG = "SearchCompany";
        }

        public static class getCountry {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/GetCountry";
            public static final String TAG = "getCountry";
        }

        public static class getPlaceOrder {
            public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/PlaceOrder";
            public static final String TAG = "PlaceOrder";

        }

        public static class getLiveCalls {
            public static final String ENDPOINT = "/desktopmodules/services/api/MobileApp/GetLiveCall_DSIJ";
            public static final String TAG = "Get Live Calls";
        }

        public static class postLowRating {
            public static final String ENDPOINT = "/desktopmodules/services/api/MobileApp/SubmitLowRating_DSIJ";
            public static final String TAG = "Post Low Rating";
        }
    }

    public static class process {
        public static final int LOGIN_WITH_FACEBOOK = 2;
        public static final int LOGIN_WITH_GOOGLE = 102;
    }


    public static class tag {
        public static final String RESPONSE = " :: RESPONSE << ";
        public static final String ERROR = " :: ERROR !! ";
        public static final String ERROR_UNKNOWN = " ?? UNKNOWN ERROR ?? ";
        public static final String FAILED = " :: FAILED !! ";

        public static final String DB_TRANSACTION_WRITE = " $$ DB WRITE ";
        public static final String DB_SUCCESS = "SUCCESS ";
        public static final String DB_FAIL = "FAIL ";

        public static final String ERROR_TIMEOUT_MSG = "Something went wrong";
        public static final String ERROR_CHECK_INTERNET = "Please Check your Internet connection";
    }

    public static class loginWithPassword {

        public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/ValidateUser";

        public static final String TAG = "Login with Password";

        public static class error {
            public static final int INTERNAL_SERVER_ERROR = 410;
            public static final int INCORRECT_PASSWORD = 411;
            public static final int USER_LOCKED = 412;
            public static final int NOT_AUTHORISED = 413;
            public static final int SERVER_ERROR = 414;
            public static final int USERNAME_NOT_REGISTERED = 415;
            public static final int EMPTY_PARAMS = 416;

        }
    }

    public static class loginWithToken {

        public static final String ENDPOINT = "/desktopmodules/services/api/SMGWebAPI/CheckLogin";

        public static final String TAG = "Login with Token";

        public static class error {
            public static final int ALREADY_SIGNED_INTO_OTHER_DEVICE = 411;
            public static final int TOKEN_EXPIRED = 412;
            public static final int NOT_AUTHORISED = 413;
        }
    }

    public static class signUp {

        public static final String TAG = "Sign Up";

        public static class error {
            public static final int INTERNAL_SERVER_ERROR = 411;
            public static final int EMAIL_ALREADY_EXISTS = 412;
            public static final int ERROR_IN_SENDING_MAIL = 414;
            public static final int EMPTY_PARAMS = 416;

        }
    }

    public static class resetPassword {

        public static final String TAG = "Reset Password";

        public static class error {
            public static final int INVALID_USERNAME = 412;
            public static final int INTERNAL_SERVER_ERROR = 414;
            public static final int ERROR_IN_SENDING_EMAIL = 411;
            public static final int EMPTY_PARAMS = 416;

        }
    }

    public static class changePassword {

        public static final String TAG = "Reset Password";

        public static class error {
            public static final int INTERNAL_SERVER_ERROR = 410;
            public static final int INVALID_PASSWORD_FORMAT = 411;
            public static final int NOT_AUTHORISED = 413;
            public static final int EMPTY_PARAMS = 416;

        }
    }


    public class Config {

        public static final String TOPIC_GLOBAL = "global";

        public static final String REGISTRATION_COMPLETE = "registrationComplete";
        public static final String PUSH_NOTIFICATION = "pushNotification";
    }

    public static String productid = "115";
    public static String profileAvatar = "";
}
