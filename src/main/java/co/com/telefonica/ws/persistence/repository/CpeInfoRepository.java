package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.CpeInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CpeInfoRepository extends JpaRepository<CpeInfoEntity, Long> {

    List<CpeInfoEntity> findByModelIn(List<String> models);

    Page<CpeInfoEntity> findByModelIn(List<String> models, Pageable pageable);

}
