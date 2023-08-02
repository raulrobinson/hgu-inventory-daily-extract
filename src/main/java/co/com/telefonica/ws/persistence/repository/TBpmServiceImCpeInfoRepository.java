package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.TBpmServiceImCpeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TBpmServiceImCpeInfoRepository extends JpaRepository<TBpmServiceImCpeInfo, String> {
}
