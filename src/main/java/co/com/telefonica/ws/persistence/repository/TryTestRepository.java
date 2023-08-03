package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.TryTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TryTestRepository extends JpaRepository<TryTest, String> {

    @Query(value = "SELECT a1.SERIALNUMBER AS serial_number, a2.ACCESSID AS access_id, a2.CUSTOMERID AS customer_id " +
            "FROM SOM.T_BPM_SERVICEIM_CPE_INFO a1 " +
            "INNER JOIN SOM.T_BPM_SERVICEIM_CPEID a2 ON a1.CPEID = a2.CPEID " +
            "WHERE a1.MODEL IN('3505VW','RTF8115VW','GPT-2741GNAC') " +
            "ORDER BY a2.CUSTOMERID " +
            "FETCH FIRST :lotSize ROWS ONLY"
            , nativeQuery = true)
    List<TryTest> findCustomTryTest10RowsOnly(int lotSize);

}
