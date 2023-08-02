package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.TBpmServiceImCpeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TBpmServiceImCpeInfoRepository extends JpaRepository<TBpmServiceImCpeInfo, String> {

    @Query(value = "SELECT a1.*,a2.ACCESSID,a2.CUSTOMERID " +
            "FROM SOM.T_BPM_SERVICEIM_CPE_INFO a1 " +
            "INNER JOIN SOM.T_BPM_SERVICEIM_CPEID a2 " +
            "ON a1.cpeid = a2.cpeid " +
            "WHERE a1.model " +
            "IN('3505VW','RTF8115VW','GPT-2741GNAC')", nativeQuery = true)
    Page<TBpmServiceImCpeInfo> findCustomTBpmServiceImCpeInfo(Pageable pageable);
}
