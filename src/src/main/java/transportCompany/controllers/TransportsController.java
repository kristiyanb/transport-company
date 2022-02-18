package transportCompany.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import transportCompany.dao.TransportDao;
import transportCompany.models.Transport;

@RestController
@RequestMapping("/transports")
public class TransportsController {
    private TransportDao transportDao;

    public TransportsController(TransportDao transportDao) {
        this.transportDao = transportDao;
    }

    @GetMapping
    public List<Transport> getAll() {
        return this.transportDao.all();
    }

    @PostMapping
    public void create(@RequestBody Transport client) {
        this.transportDao.add(client);
    }

    @PutMapping
    public void update(@RequestBody Transport client) {
        this.transportDao.update(client);
    }

    @DeleteMapping
    public void delete(@RequestBody Transport client) {
        this.transportDao.delete(client);
    }

    @GetMapping
    @RequestMapping("/searchByDestination")
    public List<Transport> searchByDestination(@RequestParam String destination) {
        return this.transportDao.searchByDestination(destination);
    }
}
