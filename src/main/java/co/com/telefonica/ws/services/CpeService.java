package co.com.telefonica.ws.services;

import co.com.telefonica.ws.persistence.entity.CpeInfoEntity;
import co.com.telefonica.ws.persistence.repository.CpeInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CpeService {

    private final CpeInfoRepository cpeInfoRepository;

    @Autowired
    public CpeService(CpeInfoRepository cpeInfoRepository) {
        this.cpeInfoRepository = cpeInfoRepository;
    }

    public List<CpeInfoEntity> getCpeInfoList() {
        List<String> models = Arrays.asList("3505VW", "RTF8115VW", "GPT-2741GNAC");
        return cpeInfoRepository.findByModelIn(models);
    }

    public Page<CpeInfoEntity> getCpeInfoEntityByModel(int pageSize,
                                                       int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        List<String> models = Arrays.asList("3505VW", "RTF8115VW", "GPT-2741GNAC");
        return cpeInfoRepository.findByModelIn(models, pageRequest);
    }

}
