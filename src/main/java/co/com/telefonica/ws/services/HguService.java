package co.com.telefonica.ws.services;

import org.springframework.http.ResponseEntity;

public interface HguService {
    ResponseEntity<Object> findCustomTBPM();

    // ResponseEntity<Object> findCustomTBPM();
    //
    // ResponseEntity<Object> findCustomTBpmServiceImCpeInfo(int pageNumber,
    //                                                       int pageSize);
    //
    // Long findCountModel(String model);
    //
    // ResponseEntity<Object> findHguByCustomQuery(int pageSize,
    //                                            int pageNumber);
}
