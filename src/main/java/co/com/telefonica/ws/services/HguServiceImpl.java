package co.com.telefonica.ws.services;

import co.com.telefonica.ws.persistence.entity.BpmInfo;
import co.com.telefonica.ws.persistence.repository.HguRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class HguServiceImpl implements HguService {

    private final HguRepository repository;

    @Autowired
    public HguServiceImpl(HguRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<List<BpmInfo>> findHguByCustomQuery(int pageSize,
                                                              int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<BpmInfo> require = repository.findHguByCustomQuery(pageRequest);
        if (require == null) {
            log.error("Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<BpmInfo> list = new ArrayList<>();
        for (BpmInfo item : require) {
            BpmInfo info = new BpmInfo();
            info.setIdType(item.getIdType());
            info.setIdNumber(item.getIdNumber());
            info.setAccessId(item.getAccessId());
            info.setServiceNumber(item.getServiceNumber());
            info.setSerialNumber(item.getSerialNumber());
            list.add(info);
        }
        log.info("Found totalPages={} with totalElements={}", require.getTotalPages(), require.getTotalElements());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
