package com.example.Insure.My.Team.Service;

import com.example.Insure.My.Team.DTO.ClientAddDTO;
import com.example.Insure.My.Team.Models.Client;
import com.example.Insure.My.Team.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        List<Client> clientList=new ArrayList<>();
        for(Client client: clientRepository.findAll()){
            clientList.add(client);
        }
        return clientList;
    }

    public String addClient(ClientAddDTO clientAddDTO) {

        Client client= new Client();
            client.setName(clientAddDTO.getName());
            client.setAddress(clientAddDTO.getAddress());
            client.setContactNo(clientAddDTO.getContactNo());
            client.setDateOfBirth(clientAddDTO.getDateOfBirth());
        clientRepository.save(client);

        return "Client added successfully";
    }

    public Client getClientById(int id){
        Client client=clientRepository.findById(id);
        return client;
    }

    public String updateClientAddress(int id, String address){
        Client client=clientRepository.findById(id);
        client.setAddress(address);
        clientRepository.save(client);
        return "Updated successfully";
    }

    public String deleteClientById(int id){
        clientRepository.deleteById(id);
        return "Id deleted successfully";
    }

}
