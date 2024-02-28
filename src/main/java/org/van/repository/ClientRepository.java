package org.van.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.van.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {


}
