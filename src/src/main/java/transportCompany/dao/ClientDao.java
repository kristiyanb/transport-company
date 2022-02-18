package transportCompany.dao;

import transportCompany.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientDao {
    @Autowired
    private ClientRepository repo;

    @Autowired
    private CompanyRepository companyRepo;

    public void add(Client client) {
        var existingCompany = this.companyRepo.findById(client.getCompany().getId()).get();
        client.setCompany(existingCompany);
        this.repo.save(client);
    }

    public void update(Client client) {
        Client dbEntity = this.repo.findById(client.getId()).get();
        dbEntity.setName(client.getName());
        this.repo.save(dbEntity);
    }

    public void delete(Client client) {
        this.repo.delete(client);
    }

    public List<Client> all() {
        return this.repo.findAll();
    }

    public Client find(long id) {
        return this.repo.findById(id).get();
    }
}
