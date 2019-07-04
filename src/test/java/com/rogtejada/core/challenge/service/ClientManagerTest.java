package com.rogtejada.core.challenge.service;

import com.rogtejada.core.challenge.model.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientManagerTest {

    private ClientManager clientManager = ClientManager.getInstance();;

    @Test
    public void getInstance() {
        assertEquals(true, clientManager instanceof ClientManager);
    }

    @Test
    public void addClient() {
        clientManager.addClient(new Client());
        assertEquals(1, clientManager.generateNumberOfClients());
    }
}