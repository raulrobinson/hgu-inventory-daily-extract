package co.com.telefonica.ws.services;

import org.springframework.http.ResponseEntity;

public interface HguService {
    Long findCountModel(String model);

    ResponseEntity<Object> findHguByCustomQuery(int pageSize,
                                                int pageNumber);
}
