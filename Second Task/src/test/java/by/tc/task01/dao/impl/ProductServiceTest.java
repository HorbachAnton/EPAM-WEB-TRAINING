package by.tc.task01.dao.impl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria.Oven;
import by.tc.task01.service.ProductService;
import by.tc.task01.service.ServiceFactory;

public class ProductServiceTest {

    private static Criteria<Oven> criteriaOven;
    private static ProductService service;
    private static String[] expectedArray = {
	    "Oven : POWER_CONSUMPTION=1500, WEIGHT=12, CAPACITY=33, DEPTH=60, HEIGHT=45, WIDTH=68;" };

    @BeforeClass
    public static void setUpBeforeClass() {
	ServiceFactory factory = ServiceFactory.getInstance();
	service = factory.getProductService();
	criteriaOven = new Criteria<Oven>();
	criteriaOven.add(Oven.WIDTH, 68);
    }

    @Test
    public void testFind() {
	assertArrayEquals(expectedArray, service.find(criteriaOven).getFinded().toArray());
    }

}
