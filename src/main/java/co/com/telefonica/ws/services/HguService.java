package co.com.telefonica.ws.services;

import co.com.telefonica.ws.persistence.entity.BpmInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HguService {
    ResponseEntity<List<BpmInfo>> findHguByCustomQuery(int pageSize,
                                                       int pageNumber);
}
