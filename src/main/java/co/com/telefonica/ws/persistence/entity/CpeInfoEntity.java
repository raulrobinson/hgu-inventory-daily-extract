package co.com.telefonica.ws.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "T_BPM_SERVICEIM_CPE_INFO", schema = "SOM")
public class CpeInfoEntity {

    @Id
    @Column(name = "CPEID")
    private String cpeid;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "SERIALNUMBER")
    private String serialnumber;

}
