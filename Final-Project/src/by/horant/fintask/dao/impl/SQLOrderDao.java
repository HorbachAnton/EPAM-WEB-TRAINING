package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.OrderDAO;
import by.horant.fintask.dao.util.ShutterDao;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.enumeration.ApprovedStages;
import by.horant.fintask.entity.enumeration.UsedStages;

public class SQLOrderDao implements OrderDAO {

    private static final String QUERY_GET_PRESCRIPTION = "SELECT * FROM prescriptions WHERE idPrescription = (SELECT Prescriptions_idPrescription FROM prescriptions_has_medicines where Prescriptions_Users_idUser = ? AND Medicines_idMedicine = ?) AND isApproved = ? AND isUsed = ?;";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public List<Medicine> checkRecipes(Order order) throws DaoException {
	List<Medicine> purshasedMedication = order.getPurchasedMedications();
	List<Medicine> medicationWithoutRecipes = new ArrayList<>();

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_GET_PRESCRIPTION);

	    st.setInt(1, order.getCustomer().getId());
	    st.setInt(3, ApprovedStages.APPROVED.getIdentifier());
	    st.setInt(4, UsedStages.UNUSED.getIdentifier());

	    for (Medicine medication : purshasedMedication) {
		st.setInt(2, medication.getId());
		rs = st.executeQuery();

		if (!rs.next() && medication.isNeedPrescription()) {
		    medicationWithoutRecipes.add(medication);
		}
	    }

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(rs, st, con);
	}

	return medicationWithoutRecipes;
    }

}
