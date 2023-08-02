package co.com.telefonica.ws.services;

import co.com.telefonica.ws.persistence.repository.*;
import co.com.telefonica.ws.ui.dto.CustomResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HguServiceImpl implements HguService {

    private final TryTestRepository tryTestRepository;
    private final TryTestTotalRepository tryTestTotalRepository;
    private final HguRepository hguRepository;

    @Autowired
    public HguServiceImpl(TryTestRepository tryTestRepository, TryTestTotalRepository tryTestTotalRepository, HguRepository hguRepository) {
        this.tryTestRepository = tryTestRepository;
        this.tryTestTotalRepository = tryTestTotalRepository;
        this.hguRepository = hguRepository;
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
        var require = tryTestTotalRepository.countAllByTryTestTotal();
        if (require == null) {
            log.error("Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Found total={}", require);
        return new ResponseEntity<>(require, HttpStatus.OK);
    }

    @Override
    public Page<CustomResult> getPaginatedResults(int page,
                                                  int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return hguRepository.findResultsWithPagination(pageable);
    }

    // public ResponseEntity<Object> mainHguExtract(int pageSize) {
    //     var totalRecords = Integer.parseInt(tryTestTotalRepository.countAllByTryTestTotal().getTotalRecords());
    //     double pages = (double) totalRecords / pageSize;
    //     if (pages % 1 > 0) {
    //         pages = Math.ceil(pages);
    //     }
    //     for (int i = 0; i < pages; i++) {
    //         List<TryTest> list = new ArrayList<>();
    //         for ()
    //     }
    // }

}
