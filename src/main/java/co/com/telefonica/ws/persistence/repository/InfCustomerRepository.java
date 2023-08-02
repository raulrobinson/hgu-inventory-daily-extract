package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.InfCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfCustomerRepository extends JpaRepository<InfCustomer, String> {
}
