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

    @GetMapping
    private List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping
    private String addClient(@RequestBody ClientAddDTO clientAddDTO){
        return clientService.addClient(clientAddDTO);
    }

    @GetMapping("/{id}")
    private Client getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @PutMapping("/{id}")
    private String updateClientAddress(@PathVariable int id, @RequestParam("add") String address){
        return  clientService.updateClientAddress(id,address);
    }

    //Used exception handling in case of incorrect id
    @DeleteMapping("/{id}")
    public String deleteClientById(@PathVariable int id) {
        try {
            return clientService.deleteClientById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
