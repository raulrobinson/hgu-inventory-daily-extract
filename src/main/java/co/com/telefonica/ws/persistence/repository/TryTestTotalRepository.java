package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.TryTestTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TryTestTotalRepository extends JpaRepository<TryTestTotal, String> {

    @Query(value = "SELECT SUM(TOTAL_COUNT) AS TOTAL_RECORDS FROM (" +
            "SELECT COUNT(1) AS TOTAL_COUNT " +
            "FROM SOM.T_BPM_SERVICEIM_CPE_INFO a1 " +
            "INNER JOIN SOM.T_BPM_SERVICEIM_CPEID a2 ON a1.cpeid = a2.cpeid " +
            "WHERE a1.model IN('3505VW','RTF8115VW','GPT-2741GNAC') " +
            "GROUP BY a1.SERIALNUMBER, a2.ACCESSID, a2.CUSTOMERID) subquery"
            , nativeQuery = true)
    TryTestTotal countAllByTryTestTotal();
}
