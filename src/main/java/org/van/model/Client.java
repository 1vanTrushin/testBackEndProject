package org.van.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "client",
            cascade = CascadeType.ALL
    )
    private List<Contact> contacts = new ArrayList<>();


    public void addContact(Contact contact) {
        contacts.add(contact);
    }


    public void removeContact(Contact item) {
        contacts.remove(item);
    }


}
