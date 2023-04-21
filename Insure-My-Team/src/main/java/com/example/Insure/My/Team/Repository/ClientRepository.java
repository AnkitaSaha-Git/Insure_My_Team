package com.example.Insure.My.Team.Repository;


import com.example.Insure.My.Team.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
        Client findById(int id);
}
