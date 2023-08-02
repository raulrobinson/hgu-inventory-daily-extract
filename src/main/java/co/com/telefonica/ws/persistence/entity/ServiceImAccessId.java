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
@Table(name = "SERVICEIM_ACCESSID", schema = "SOM")
public class ServiceImAccessId {

    @Column(name = "accessid")
    private String accessId;

    @Column(name = "customerid")
    private String customerId;

    @Column(name = "status")
    private String status;

    @Column(name = "cfscode")
    private String cfsCode;

    @Id
    @Column(name = "subscriberid")
    private String subscriberId;

}
