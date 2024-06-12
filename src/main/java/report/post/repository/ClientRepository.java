package report.post.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import report.post.domain.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Client> findByName(String name);
}
