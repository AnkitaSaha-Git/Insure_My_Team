package com.example.Insure.My.Team.Controller;

import com.example.Insure.My.Team.DTO.ClientAddDTO;
import com.example.Insure.My.Team.Models.Client;
import com.example.Insure.My.Team.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/getAll")
    private List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/add")
    private String addClient(@RequestBody ClientAddDTO clientAddDTO){
        return clientService.addClient(clientAddDTO);
    }

    @GetMapping("/get/{id}")
    private Client getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @PutMapping("/put/{id}")
    private String updateClientAddress(@PathVariable int id, @RequestBody String address){
        return  clientService.updateClientAddress(id,address);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClientById(@PathVariable int id){
        return clientService.deleteClientById(id);
    }
}
