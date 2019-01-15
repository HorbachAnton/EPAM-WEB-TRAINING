package by.tc.task01.service.impl;

import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.FindedProductDAO;
import by.tc.task01.entity.FindedProduct;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ProductService;
import by.tc.task01.service.validation.CriteriaValidator;

public class ProductServiceImpl implements ProductService {

    public <E> FindedProduct find(Criteria<E> criteria) {
	if (!CriteriaValidator.valid(criteria)) {
	    return null;
	}

	DAOFactory factory = DAOFactory.getInstance();
	FindedProductDAO findedProDAO = factory.getFindedProductDAO();

	return findedProDAO.find(criteria);
    }

}

