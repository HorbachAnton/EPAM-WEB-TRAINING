package by.tc.task01.dao;

import by.tc.task01.entity.FindedProduct;
import by.tc.task01.entity.criteria.Criteria;

public interface FindedProductDAO {
	<E> FindedProduct find(Criteria<E> criteria);
}
