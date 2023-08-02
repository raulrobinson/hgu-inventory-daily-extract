package co.com.telefonica.ws.services;

import co.com.telefonica.ws.ui.dto.CustomResult;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface HguService {
    ResponseEntity<Object> findCustomTBPM(int lotSize);
    ResponseEntity<Object> findCountModel();

    Page<CustomResult> getPaginatedResults(int page,
                                           int size);
}
