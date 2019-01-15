package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.FindedProduct;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ProductService;
import by.tc.task01.service.ServiceFactory;

public class Main {

    public static void main(String[] args) {
	FindedProduct product;

	ServiceFactory factory = ServiceFactory.getInstance();
	ProductService service = factory.getProductService();

	Criteria<Oven> criteriaOven = new Criteria<>();
	criteriaOven.add(Oven.CAPACITY, 33);

	product = service.find(criteriaOven);

	PrintFindedProductInfo.print(product);

	criteriaOven = new Criteria<>();
	criteriaOven.add(Oven.HEIGHT, 200);
	criteriaOven.add(Oven.DEPTH, 300);

	product = service.find(criteriaOven);

	PrintFindedProductInfo.print(product);

	Criteria<TabletPC> criteriaTabletPC = new Criteria<>();
	criteriaTabletPC.add(TabletPC.COLOR, "BLUE");
	criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
	criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);

	product = service.find(criteriaTabletPC);

	PrintFindedProductInfo.print(product);

    }

}
