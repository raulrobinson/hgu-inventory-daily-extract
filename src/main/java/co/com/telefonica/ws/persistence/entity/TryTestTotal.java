package co.com.telefonica.ws.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TryTestTotal {

    @Id
    @Column(name = "TOTAL_RECORDS")
    private String totalRecords;

}
