package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.TBpmServiceImCpeInfo;
import co.com.telefonica.ws.ui.dto.CustomResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HguRepository extends JpaRepository<TBpmServiceImCpeInfo, String > {

    @Query(nativeQuery = true, value = "WITH BPM_INFO AS (SELECT a1.*, a2.ACCESSID, a2.CUSTOMERID " +
            "FROM SOM.T_BPM_SERVICEIM_CPE_INFO a1 " +
            "INNER JOIN SOM.T_BPM_SERVICEIM_CPEID a2 ON a1.cpeid = a2.cpeid " +
            "WHERE a1.model IN('3505VW','RTF8115VW','GPT-2741GNAC')" +
            ") SELECT d.service_number, a.serialnumber, b.accessid, e.id_type, e.id_number " +
            "FROM BPM_INFO a " +
            "INNER JOIN SOM.SERVICEIM_ACCESSID b ON a.accessid = b.accessid " +
            "AND b.status <> '0' AND b.cfscode = 'CFS_Broadband' " +
            "INNER JOIN DWHODS.INF_CUSTOMER c ON b.customerid = c.cust_code " +
            "INNER JOIN DWHODS.INF_SUBSCRIBER d ON b.subscriberid = d.subs_id " +
            "AND d.prod_code = '3200001' " +
            "INNER JOIN DWHODS.INF_PARTY_CERTIFICATE e ON c.party_id = e.party_id")
    Page<CustomResult> findResultsWithPagination(Pageable pageable);

}
