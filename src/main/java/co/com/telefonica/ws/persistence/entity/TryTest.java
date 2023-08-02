package co.com.telefonica.ws.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TryTest {

    @Id
    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "access_id")
    private String accessId;

    @Column(name = "customer_id")
    private String customerId;

}
