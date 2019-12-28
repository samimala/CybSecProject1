package sec.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Accounts;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
