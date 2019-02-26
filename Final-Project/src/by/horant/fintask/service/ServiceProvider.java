package by.horant.fintask.service;

import by.horant.fintask.service.impl.ClientServiceImpl;

public class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();

    private ClientService clientService = new ClientServiceImpl();

    private ServiceProvider() {

    }

    public ClientService getClientService() {
	return clientService;
    }

    public static ServiceProvider getInstance() {
	return instance;
    }

}
