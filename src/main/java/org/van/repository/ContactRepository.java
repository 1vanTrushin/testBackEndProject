package org.van.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.van.model.Contact;

import java.util.List;


public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findContactsByClient_Id(Long id);
    List<Contact> findContactsByCategoryAndClient_Id(String type, Long id);

}
