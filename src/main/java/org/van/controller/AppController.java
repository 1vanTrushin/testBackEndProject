package org.van.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.van.model.Client;
import org.van.model.Contact;
import org.van.model.dto.ClientDTO;
import org.van.model.dto.ContactDTO;
import org.van.service.AppService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;



    /**
     * Create new client
     * @param client Client
     * @return Saved client
     */

    @PostMapping("/client")
    public ResponseEntity<Client> addNewClient(@RequestBody @Valid ClientDTO client) {
        return new ResponseEntity<>(appService.addNewClient(client), HttpStatus.CREATED);
    }

    /**
     * Get client data by Id
     * @param clientId client Id
     * @return Client data
     */

    @GetMapping("/client/{clientId}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long clientId) {
        return new ResponseEntity<>(appService.getClientById(clientId), HttpStatus.OK);
    }

    /**
     * Get client list
     * @return List of clients
     */
    @GetMapping("/list/client")
    public ResponseEntity<List<Client>> getClientList() {
        return new ResponseEntity<>(appService.getClients(), HttpStatus.OK);
    }


    /**
     * Add new contact to client by id
     * @param clientId Client Id
     * @param contact contact data contains
     * @return Client data with saved contact data
     */
    @PostMapping("/contact/{clientId}")
    public ResponseEntity<Client> addNewContactToClient(@PathVariable Long clientId, @RequestBody  @Valid ContactDTO contact) {
        return new ResponseEntity<>(appService.addContactToClient(clientId, contact), HttpStatus.OK);

    }

    /**
     * Get list of contacts by client id
     * @param clientId client id
     * @return list of contacts
     */
    @GetMapping("/list/contact/{clientId}")
    public ResponseEntity<List<Contact>> getContactsByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(appService.getContacts(clientId), HttpStatus.OK);

    }

    /**
     * get contacts by client id and named type
     * @param clientId client id
     * @param type type of contact (email, phoneNumber.. )
     * @return list of contacts by type
     */
    @GetMapping("/list/contact/{clientId}/{type}")
    public ResponseEntity<List<Contact>> getContactsByType(@PathVariable Long clientId, @PathVariable String type) {
        return new ResponseEntity<>(appService.getContactsByType(clientId, type), HttpStatus.OK);

    }


}
