package com.rogtejada.core.challenge.service;



import com.rogtejada.core.challenge.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientManager {
    private static ClientManager instance;

    private List<Client>  clientList = new ArrayList<>();

    private ClientManager(){
    }

    public static synchronized ClientManager getInstance(){
        if(instance == null){
            instance = new ClientManager();
        }
        return instance;
    }

    public void addClient(Client client){
        clientList.add(client);
    }

    public int generateNumberOfClients(){
        return clientList.size();
    }
}
