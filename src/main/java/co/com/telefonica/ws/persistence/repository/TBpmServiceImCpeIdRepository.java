package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.TBpmServiceImCpeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TBpmServiceImCpeIdRepository extends JpaRepository<TBpmServiceImCpeId, String> {
}
