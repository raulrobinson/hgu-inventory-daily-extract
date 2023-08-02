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

    @Id
    @Column(name = "serialnumber")
    private String serialNumber;

    @Column(name = "service_number")
    private String serviceNumber;

    @Column(name = "accessid")
    private String accessId;

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_number")
    private String idNumber;

}
