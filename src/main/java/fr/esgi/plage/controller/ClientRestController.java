package fr.esgi.plage.controller;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.dto.ClientDto;
import fr.esgi.plage.exception.ClientExisteDejaException;
import fr.esgi.plage.exception.ClientInexistantException;
import fr.esgi.plage.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/")
@RestController
@AllArgsConstructor
public class ClientRestController {

    private final ClientService clientService;

    @GetMapping("clients")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PostMapping("client")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client postClient(@RequestBody ClientDto client) {
        return clientService.createClient(client);
    }

    @PutMapping("client")
    public Client putClient(@RequestBody ClientDto client) {
        return clientService.modifyClient(client);
    }

    @DeleteMapping("client/{id}")
    public boolean deleteClient(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }

    @ExceptionHandler(ClientExisteDejaException.class)
    @ResponseStatus(code= HttpStatus.CONFLICT)
    public String traiterClientDejaPresent(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(ClientInexistantException.class)
    @ResponseStatus(code= HttpStatus.CONFLICT)
    public String traiterClientInexistant(Exception e) {
        return e.getMessage();
    }
}
