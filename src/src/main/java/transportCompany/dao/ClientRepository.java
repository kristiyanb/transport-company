package transportCompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import transportCompany.models.*;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}

