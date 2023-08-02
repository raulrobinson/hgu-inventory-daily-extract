package co.com.telefonica.ws.services;

import co.com.telefonica.ws.persistence.repository.*;
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

    private final HguRepository repository;
    private final InfSubscriberRepository infSubscriberRepository;
    private final InfPartyCertificateRepository infPartyCertificateRepository;
    private final InfCustomerRepository infCustomerRepository;
    private final ServiceImAccessIdRepository serviceImAccessIdRepository;
    private final TBpmServiceImCpeInfoRepository tBpmServiceImCpeInfoRepository;
    private final TBpmServiceImCpeIdRepository tBpmServiceImCpeIdRepository;

    @Autowired
    public HguServiceImpl(HguRepository repository,
                          InfSubscriberRepository infSubscriberRepository,
                          InfPartyCertificateRepository infPartyCertificateRepository,
                          InfCustomerRepository infCustomerRepository,
                          ServiceImAccessIdRepository serviceImAccessIdRepository,
                          TBpmServiceImCpeInfoRepository tBpmServiceImCpeInfoRepository,
                          TBpmServiceImCpeIdRepository tBpmServiceImCpeIdRepository) {
        this.repository = repository;
        this.infSubscriberRepository = infSubscriberRepository;
        this.infPartyCertificateRepository = infPartyCertificateRepository;
        this.infCustomerRepository = infCustomerRepository;
        this.serviceImAccessIdRepository = serviceImAccessIdRepository;
        this.tBpmServiceImCpeInfoRepository = tBpmServiceImCpeInfoRepository;
        this.tBpmServiceImCpeIdRepository = tBpmServiceImCpeIdRepository;
    }

    @Override
    public Long findCountModel(String model) {
        return tBpmServiceImCpeInfoRepository.count();
    }

    @Override
    public ResponseEntity<Object> findHguByCustomQuery(int pageSize,
                                                       int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Object> require = repository.findHguByCustomQuery(pageRequest);
        if (require == null) {
            log.error("Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Found totalPages={} with totalElements={}", require.getTotalPages(), require.getTotalElements());
        return new ResponseEntity<>(require, HttpStatus.OK);
    }
}
