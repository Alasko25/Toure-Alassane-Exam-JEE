package com.example.gestioncredit.repository;

import com.example.gestioncredit.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testSaveAndFind() {
        // Création d'un client
        Client client = new Client("Dupont", "dupont@example.com");
        client = clientRepository.save(client);

        // Vérifie que le client est bien enregistré
        assertThat(client.getId()).isNotNull();

        // Recherche tous les clients
        List<Client> clients = clientRepository.findAll();
        assertThat(clients).isNotEmpty();
        assertThat(clients).extracting(Client::getNom).contains("Dupont");
    }
}
