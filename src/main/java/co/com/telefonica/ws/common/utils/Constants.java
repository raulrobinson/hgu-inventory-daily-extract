package co.com.telefonica.ws.common.utils;

public class Constants {
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String RESPONSE_SUCCESS_TOTAL = "{} OK for Batch={}/{} Sent={} with LoadDate={} of Total={}";
    public static final String RESPONSE_ERROR_TOTAL = "{} Bad Request for Batch={}/{} Sent={} with LoadDate={} of Total={}";
    public static final String RESPONSE_ERROR_BATCH = ">>> REVIEW into Batch={}/{} with LoadDate={} of Total={}";
    private Constants(){ }
}
