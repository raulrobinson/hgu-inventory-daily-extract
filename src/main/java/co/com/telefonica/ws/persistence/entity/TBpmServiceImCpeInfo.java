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
@Table(name = "T_BPM_SERVICEIM_CPE_INFO", schema = "SOM")
public class TBpmServiceImCpeInfo {

    @Column(name = "cpeid")
    private String cpeId;

    @Column(name = "model")
    private String model;

    @Column(name = "serialnumber")
    private String serialNumber;

}
