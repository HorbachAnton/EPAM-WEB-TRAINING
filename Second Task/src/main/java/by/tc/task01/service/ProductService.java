package by.tc.task01.service;

import by.tc.task01.entity.FindedProduct;
import by.tc.task01.entity.criteria.Criteria;

public interface ProductService {	
	
	<E> FindedProduct find(Criteria<E> criteria);
	
}
