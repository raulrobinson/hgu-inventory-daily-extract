package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.BpmInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HguRepository extends JpaRepository<BpmInfo, String > {

    @Query(value = "with BPM_INFO as (\n" +
            "   select /* full(a1) parallel(a1,10) materialize */ a1.*, a2.ACCESSID, a2.CUSTOMERID\n" +
            "   from som.T_BPM_SERVICEIM_CPE_INFO a1\n" +
            "   inner join som.t_bpm_serviceim_cpeid a2 on a1.cpeid = a2.cpeid \n" +
            "   where a1.model IN('3505VW','RTF8115VW','GPT-2741GNAC')\n" +
            ")\n" +
            "select d.service_number, a.serialnumber, b.accessid, e.id_type, e.id_number \n" +
            "from BPM_INFO a\n" +
            "inner join SOM.SERVICEIM_ACCESSID b on a.accessid = b.accessid and b.status <> '0' and b.cfscode = 'CFS_Broadband'\n" +
            "inner join DWHODS.INF_CUSTOMER c on b.customerid = c.cust_code\n" +
            "inner join DWHODS.INF_SUBSCRIBER d on b.subscriberid = d.subs_id and d.prod_code = '3200001'\n" +
            "inner join DWHODS.INF_PARTY_CERTIFICATE e on c.party_id = e.party_id", nativeQuery = true)
    Page<Object> findHguByCustomQuery(Pageable pageable);

}
