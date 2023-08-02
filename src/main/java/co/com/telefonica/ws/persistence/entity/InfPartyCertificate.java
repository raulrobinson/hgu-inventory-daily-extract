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
@Table(name = "INF_PARTY_CERTIFICATE", schema = "DWHODS")
public class InfPartyCertificate {

    @Column(name = "party_id")
    private String partyId;

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_number")
    private String idNumber;

}
