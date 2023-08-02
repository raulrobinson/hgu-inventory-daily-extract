package co.com.telefonica.ws.persistence.repository;

import co.com.telefonica.ws.persistence.entity.InfSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfSubscriberRepository extends JpaRepository<InfSubscriber, String> {
}
