package co.com.telefonica.ws.common.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseErrorHandler {
    private int code;
    private String message;
    private Object response;
}
