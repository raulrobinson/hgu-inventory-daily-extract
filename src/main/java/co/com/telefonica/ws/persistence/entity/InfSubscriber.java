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
@Table(name = "INF_SUBSCRIBER", schema = "DWHODS")
public class InfSubscriber {

    @Column(name = "prod_code")
    private String prodCode;

    @Column(name = "subs_id")
    private String subsId;

    @Column(name = "service_number")
    private String serviceNumber;

}
