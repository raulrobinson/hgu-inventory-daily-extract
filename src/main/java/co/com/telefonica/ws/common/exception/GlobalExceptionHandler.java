package co.com.telefonica.ws.common.exception;

import co.com.telefonica.ws.common.utils.Shield;
import co.com.telefonica.ws.common.utils.Utilities;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.cert.CertificateException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ResponseErrorHandler> handleFeignException(FeignException ex) {
        int statusCode = ex.status();
        switch (statusCode) {
            case 403:
                log.error("403 Forbidden: " + ex.getMessage());
                return new ResponseEntity<>(ResponseErrorHandler.builder()
                        .code(403)
                        .message(Shield.blindStr("403 Forbidden"))
                        .build(), HttpStatus.FORBIDDEN);
            case 404:
                log.error("404 Not Found: " + ex.getMessage());
                return new ResponseEntity<>(ResponseErrorHandler.builder()
                        .code(404)
                        .message(Shield.blindStr("404 Not Found"))
                        .build(), HttpStatus.NOT_FOUND);
            case 503:
                log.error("503 Service Unavailable: " + ex.getMessage());
                return new ResponseEntity<>(ResponseErrorHandler.builder()
                        .code(503)
                        .message(Shield.blindStr("503 Service Unavailable"))
                        .build(), HttpStatus.SERVICE_UNAVAILABLE);
            case 504:
                log.error("504 Request Timeout: " + ex.getMessage());
                return new ResponseEntity<>(ResponseErrorHandler.builder()
                        .code(504)
                        .message(Shield.blindStr("504 Request Timeout"))
                        .build(), HttpStatus.REQUEST_TIMEOUT);
            default:
                log.error("409 Conflict Exist Register: " + ex.getMessage());
                return new ResponseEntity<>(ResponseErrorHandler.builder()
                        .code(409)
                        .message(Shield.blindStr("409 Conflict Exist Register"))
                        .build(), HttpStatus.CONFLICT);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ExceptionMessage> handleException(Exception ex,
                                                            HttpServletRequest request) {
        return new ResponseEntity<>(ExceptionMessage.builder()
                .timestamp(Utilities.timestampStr())
                .message(Shield.blindStr("Ocurrió un error en el servicio: " + ex.getMessage()))
                .path(Shield.blindStr(request.getRequestURI()))
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity<ExceptionMessage> handleNullPointerException(HttpServletRequest request) {
        return new ResponseEntity<>(ExceptionMessage.builder()
                .timestamp(Utilities.timestampStr())
                .message(Shield.blindStr("No existe el registro con " + request.getQueryString()))
                .path(Shield.blindStr(request.getRequestURI()))
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionMessage> handleNotFoundException(HttpServletRequest request) {
        return new ResponseEntity<>(ExceptionMessage.builder()
                .timestamp(Utilities.timestampStr())
                .message(Shield.blindStr("El recurso solicitado no fue encontrado: " + request.getQueryString()))
                .path(Shield.blindStr(request.getRequestURI()))
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ResponseEntity<ExceptionMessage> handleIOException(IOException ex,
                                                              HttpServletRequest request) {
        return new ResponseEntity<>(ExceptionMessage.builder()
                .timestamp(Utilities.timestampStr())
                .message(Shield.blindStr("Headers: " + ex.getMessage()))
                .path(Shield.blindStr(request.getRequestURI()))
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CertificateException.class)
    @ResponseBody
    public ResponseEntity<ExceptionMessage> handleCertificateException(CertificateException ex,
                                                              HttpServletRequest request) {
        return new ResponseEntity<>(ExceptionMessage.builder()
                .timestamp(Utilities.timestampStr())
                .message(Shield.blindStr("Headers: " + ex.getMessage()))
                .path(Shield.blindStr(request.getRequestURI()))
                .build(), HttpStatus.NOT_FOUND);
    }

}

