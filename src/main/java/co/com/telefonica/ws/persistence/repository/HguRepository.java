package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.BpmInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HguRepository extends JpaRepository<BpmInfo, String > {

    @Query(value = "WITH BPM_INFO AS (\n" +
            "      SELECT a1.CPEID, a1.SERIALNUMBER, a2.ACCESSID, a2.CUSTOMERID \n" +
            "      FROM SOM.T_BPM_SERVICEIM_CPE_INFO a1 \n" +
            "            INNER JOIN SOM.T_BPM_SERVICEIM_CPEID a2 \n" +
            "                  ON a1.CPEID = a2.CPEID \n" +
            "                  WHERE a1.MODEL IN('3505VW','RTF8115VW','GPT-2741GNAC')\n" +
            ") SELECT d.SERVICE_NUMBER, a.SERIALNUMBER, b.ACCESSID, e.ID_TYPE, e.ID_NUMBER \n" +
            "FROM BPM_INFO a \n" +
            "      INNER JOIN SOM.SERVICEIM_ACCESSID b \n" +
            "            ON a.ACCESSID = b.ACCESSID \n" +
            "            AND b.STATUS <> '0' \n" +
            "            AND b.CFSCODE = 'CFS_Broadband' \n" +
            "      INNER JOIN DWHODS.INF_CUSTOMER c \n" +
            "            ON b.CUSTOMERID = c.CUST_CODE \n" +
            "      INNER JOIN DWHODS.INF_SUBSCRIBER d \n" +
            "            ON b.SUBSCRIBERID = d.SUBS_ID \n" +
            "            AND d.PROD_CODE = '3200001' \n" +
            "      INNER JOIN DWHODS.INF_PARTY_CERTIFICATE e \n" +
            "            ON c.PARTY_ID = e.PARTY_ID", nativeQuery = true)
    Page<Object> findHguByCustomQuery(Pageable pageable);

}
