package report.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import report.post.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
