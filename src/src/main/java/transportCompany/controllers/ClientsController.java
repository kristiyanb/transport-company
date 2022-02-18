package transportCompany.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import transportCompany.dao.ClientDao;
import transportCompany.models.Client;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    private ClientDao clientDao;

    public ClientsController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping
    public List<Client> getAll() {
        return this.clientDao.all();
    }

    @PostMapping
    public void create(@RequestBody Client client) {
        this.clientDao.add(client);
    }

    @PutMapping
    public void update(@RequestBody Client client) {
        this.clientDao.update(client);
    }

    @DeleteMapping
    public void delete(@RequestBody Client client) {
        this.clientDao.delete(client);
    }
}
