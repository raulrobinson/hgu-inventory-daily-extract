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
    private String cpeId;

    @Column(name = "EQUIPMENT_TYPE")
    private String equipmentType;

    @Id
    @Column(name = "SERIALNUMBER")
    private String serialNumber;

    @Column(name = "CASID")
    private String casId;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "SAPCODE")
    private String sapCode;

    @Column(name = "TVCARD")
    private String tvCard;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "TV_SETUPBOX_NUMBER")
    private String tvSetupBoxNumber;

    @Column(name = "SAP_DISTRIBUTION_CENTER")
    private String sapDistributionCenter;

    @Column(name = "VOICE_SERVICE_NUMBER")
    private String voiceServiceNumber;

    @Column(name = "BB_SERVICE_NUMBER")
    private String bbServiceNumber;

    @Column(name = "TV_SERVICE_NUMBER")
    private String tvServiceNumber;

    @Column(name = "DTH_SERVICE_NUMBER")
    private String dthServiceNumber;

    @Column(name = "VOICE_SUB_ID")
    private String voiceSubId;

    @Column(name = "BB_SUB_ID")
    private String bbSubId;

    @Column(name = "TV_SUB_ID")
    private String tvSubId;

    @Column(name = "DTH_SUB_ID")
    private String dthSubId;

    @Column(name = "ACCESSID")
    private String accessId;

    @Column(name = "CUSTOMERID")
    private String customerId;

}
