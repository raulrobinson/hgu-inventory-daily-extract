package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.InfPartyCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfPartyCertificateRepository extends JpaRepository<InfPartyCertificate, String> {
}
