package by.horant.fintask.service;

import by.horant.fintask.service.impl.ClientServiceImpl;

public class ServiceProvider {

    private ClientService clientService = new ClientServiceImpl();

    private ServiceProvider() {

    }

    private static class ServiceProviderHolder {
	private static final ServiceProvider instance = new ServiceProvider();
    }

    public static ServiceProvider getInstance() {
	return ServiceProviderHolder.instance;
    }

    protected Object readResolve() {
	return getInstance();
    }

    public ClientService getClientService() {
	return clientService;
    }

}
