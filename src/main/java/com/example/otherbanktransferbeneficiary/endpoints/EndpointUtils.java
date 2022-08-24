package com.example.otherbanktransferbeneficiary.endpoints;

public class EndpointUtils {

    //account add APIs
    public static final String ADD_ACCOUNT_BENEFICIARY = "/api/v1/account/user/{userId}/beneficiary";

    public static final String GET_ACCOUNT_BENEFICIARY = "/api/v1/account/user/{userId}/beneficiary/{beneficiaryId}";

    public static final String GET_ALL_ACCOUNT_BENEFICIARY = "/api/v1/account/user/{userId}/beneficiary";

    public static final String DELETE_ACCOUNT_BENEFICIARY = "/api/v1/account/user/{userId}/beneficiary/{beneficiaryId}";

    //card add APIs

    public static final String ADD_CARD_BENEFICIARY = "/api/v1/card/user/{userId}/beneficiary";

    public static final String GET_CARD_BENEFICIARY = "/api/v1/card/user/{userId}/beneficiary/{beneficiaryId}";

    public static final String GET_ALL_CARD_BENEFICIARY = "/api/v1/card/user/{userId}/beneficiary";

    public static final String DELETE_CARD_BENEFICIARY = "/api/v1/card/user/{userId}/beneficiary/{beneficiaryId}";

}
