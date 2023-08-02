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
@Table(name = "T_BPM_SERVICEIM_CPE_INFO", schema = "SOM")
public class TBpmServiceImCpeInfo {

    @Column(name = "CPEID")
    private String CPEID;

    @Column(name = "EQUIPMENT_TYPE")
    private String EQUIPMENT_TYPE;

    @Id
    @Column(name = "SERIALNUMBER")
    private String SERIALNUMBER;

    @Column(name = "CASID")
    private String CASID;

    @Column(name = "BRAND")
    private String BRAND;

    @Column(name = "MODEL")
    private String MODEL;

    @Column(name = "SAPCODE")
    private String SAPCODE;

    @Column(name = "TVCARD")
    private String TVCARD;

    @Column(name = "MANUFACTURER")
    private String MANUFACTURER;

    @Column(name = "TV_SETUPBOX_NUMBER")
    private String TVSETUPBOXNUMBER;

    @Column(name = "SAP_DISTRIBUTION_CENTER")
    private String SAPDISTRIBUTIONCENTER;

    @Column(name = "VOICE_SERVICE_NUMBER")
    private String VOICESERVICENUMBER;

    @Column(name = "BB_SERVICE_NUMBER")
    private String BBSERVICENUMBER;

    @Column(name = "TV_SERVICE_NUMBER")
    private String TVSERVICENUMBER;

    @Column(name = "DTH_SERVICE_NUMBER")
    private String DTHSERVICENUMBER;

    @Column(name = "VOICE_SUB_ID")
    private String VOICESUBID;

    @Column(name = "BB_SUB_ID")
    private String BBSUBID;

    @Column(name = "TV_SUB_ID")
    private String TVSUBID;

    @Column(name = "DTH_SUB_ID")
    private String DTHSUBID;

    @Column(name = "ACCESSID")
    private String ACCESSID;

    @Column(name = "CUSTOMERID")
    private String CUSTOMERID;

}
