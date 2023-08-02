package co.com.telefonica.ws.services;

import org.springframework.http.ResponseEntity;

public interface HguService {
    ResponseEntity<Object> findCustomTBPM(int lotSize);
    ResponseEntity<Object> findCountModel();
}
