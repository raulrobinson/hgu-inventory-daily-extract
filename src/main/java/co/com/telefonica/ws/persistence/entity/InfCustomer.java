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
@Table(name = "INF_CUSTOMER", schema = "DWHODS")
public class InfCustomer {

    @Column(name = "cust_code")
    private String custCode;

    @Column(name = "party_id")
    private String partyId;

}