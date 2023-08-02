package co.com.telefonica.ws.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BPM_INFO")
public class BpmInfo {

    @Column(name = "SERVICE_NUMBER")
    private String serviceNumber;

    @Id
    @Column(name = "SERIALNUMBER")
    private String serialNumber;

    @Column(name = "ACCESSID")
    private String accessId;

    @Column(name = "ID_TYPE")
    private String idType;

    @Column(name = "ID_NUMBER")
    private String idNumber;

}
