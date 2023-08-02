package co.com.telefonica.ws.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_BPM_SERVICEIM_CPEID", schema = "SOM")
public class TBpmServiceImCpeId {

    @Column(name = "cpeid")
    private String cpeId;

    @Column(name = "ACCESSID")
    private String accessId;

    @Column(name = "CUSTOMERID")
    private String customerId;

}
