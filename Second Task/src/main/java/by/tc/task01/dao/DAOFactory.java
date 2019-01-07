package by.tc.task01.dao;

import by.tc.task01.dao.impl.FindedProductDAOImpl;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private final FindedProductDAO findedProDAO = new FindedProductDAOImpl();

    private DAOFactory() {
    }

    public FindedProductDAO getFindedProductDAO() {
	return findedProDAO;
    }

    public static DAOFactory getInstance() {
	return INSTANCE;
    }
}
