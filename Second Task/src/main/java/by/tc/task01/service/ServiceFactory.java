package by.tc.task01.service;

import by.tc.task01.service.impl.ProductServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ProductService productService = new ProductServiceImpl();
	
	private ServiceFactory() {}

	public ProductService getProductService() {

		return productService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

}
