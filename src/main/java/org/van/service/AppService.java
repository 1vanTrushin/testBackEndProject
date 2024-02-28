package org.van.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.van.exceptios.DataNotFoundException;
import org.van.model.Client;
import org.van.model.Contact;
import org.van.model.dto.ClientDTO;
import org.van.model.dto.ContactDTO;
import org.van.repository.ClientRepository;
import org.van.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppService {


    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    /**
     * Save client to database
     *
     * @param clientDTO Validated client data
     * @return Saved client
     */
    public Client addNewClient(ClientDTO clientDTO) {

        Client client = Client.builder()
                .firstName(clientDTO.getFirstName())
                .lastName(clientDTO.getLastName())
                .build();

        return clientRepository.save(client);
    }


    /**
     * Get all clients from database
     *
     * @return List of clients
     */

    public List<Client> getClients() {
        return clientRepository.findAll();

    }

    /**
     * Get client by client ID in database
     *
     * @param clientId Client ID
     * @return Client entity
     */

    public Optional<Client> getClientById(Long clientId) {

        Client client = clientRepository.findById(clientId).orElse(null);

        if (client == null) throw new DataNotFoundException("Client with id " + clientId + " not found");

        return clientRepository.findById(clientId);
    }

    /**
     * Add contact to client by Id
     *
     * @param clientId Client ID
     * @param contact  contact entity
     * @return client
     */
    public Client addContactToClient(Long clientId, ContactDTO contact) {

        Client client = clientRepository.findById(clientId).orElse(null);

        if (client == null) throw new DataNotFoundException("Client with id " + clientId + " not found");

        Contact c = Contact.builder()
                .client(client)
                .category(contact.getCategory())
                .contact(contact.getContact())
                .build();

        client.addContact(contactRepository.save(c));

        return clientRepository.save(client);
    }


    /**
     * get all contacts by client id
     *
     * @param clientId client Id
     * @return list of contacts
     */
    public List<Contact> getContacts(Long clientId) {

        return contactRepository.findContactsByClient_Id(clientId);
    }


    /**
     * get all specific type contacts by client ID
     *
     * @param clientId client Id
     * @param type     contact type
     * @return list of contacts
     */
    public List<Contact> getContactsByType(Long clientId, String type) {

        return contactRepository.findContactsByCategoryAndClient_Id(type, clientId);

    }

}
