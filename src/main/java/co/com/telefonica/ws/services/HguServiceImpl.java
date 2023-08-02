package co.com.telefonica.ws.services;

import co.com.telefonica.ws.persistence.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HguServiceImpl implements HguService {

    private final TryTestRepository tryTestRepository;

    @Autowired
    public HguServiceImpl(TryTestRepository tryTestRepository) {
        this.tryTestRepository = tryTestRepository;
    }

    @Override
    public ResponseEntity<Object> findCustomTBPM(int lotSize) {
        var require = tryTestRepository.findCustomTryTest10RowsOnly(lotSize);
        if (require == null) {
            log.error("Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Found total={}", require.size());
        return new ResponseEntity<>(require, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> findCountModel() {
        var require = tryTestRepository.countAllByTryTest();
        if (require == 0) {
            log.error("Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Found total={}", require);
        return new ResponseEntity<>(require, HttpStatus.OK);
    }

}
