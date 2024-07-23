package com.screenplay.constants;

public class GeneralConstants {

    private GeneralConstants() {
        throw new IllegalStateException(UTILITY_CLASS_MESSAGE_EXCEPTION);
    }

    public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
    public static final String BEARER_HEADER = "Bearer ";
    public static final String STATUS_CODE = "status_code";
    public static final String STATUS_MESSAGE = "status_message";
    public static final String SCHEMA_PATH = "schema_path";
    public static final String UTILITY_CLASS_MESSAGE_EXCEPTION = "Utility class";
}


