package co.com.telefonica.ws.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "T_BPM_SERVICEIM_CPEID", schema = "SOM")
public class CpeidEntity {

    @Id
    @Column(name = "CPEID")
    private String cpeid;

    @Column(name = "ACCESSID")
    private String accessid;

    @Column(name = "CUSTOMERID")
    private String customerid;

}
