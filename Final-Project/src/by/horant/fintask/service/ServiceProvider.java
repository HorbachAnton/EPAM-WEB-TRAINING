package by.horant.fintask.service;

import by.horant.fintask.service.impl.ClientServiceImpl;
import by.horant.fintask.service.impl.DataServiceImpl;
import by.horant.fintask.service.impl.UpdateServiceImpl;

public class ServiceProvider {

    private ClientService clientService = new ClientServiceImpl();
    private UpdateService updateService = new UpdateServiceImpl();
    private DataService dataService = new DataServiceImpl();

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

    public DataService getDataService() {
        return dataService;
    }

    public UpdateService getUpdateService() {
	return updateService;
    }

}
