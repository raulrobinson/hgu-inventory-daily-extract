package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.ServiceImAccessId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceImAccessIdRepository extends JpaRepository<ServiceImAccessId, String> {
}
