package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.PrescriptionDAO;
import by.horant.fintask.dao.util.ShutterDao;

public class SQLPrescriptionDao implements PrescriptionDAO {

    private static final String QUERY_REQUEST_PRESCRIPTION_PART_1 = "INSERT INTO prescriptions (`Users_idUser`) VALUES (?)";
    private static final String QUERY_REQUEST_PRESCRIPTION_PART_2 = "INSERT INTO prescriptions_has_medicines (`Prescriptions_idPrescription`, `Prescriptions_Users_idUser`, `Medicines_idMedicine`) VALUES (?, ?, ?);";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public boolean requestPrescription(int userId, int medicineId) throws DaoException {
	boolean result = false;

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_REQUEST_PRESCRIPTION_PART_1, Statement.RETURN_GENERATED_KEYS);

	    st.setInt(1, userId);
	    st.execute();

	    rs = st.getGeneratedKeys();

	    int prescriptionId = 0;

	    if (rs.next()) {
		prescriptionId = rs.getInt(1);
	    }

	    st.close();

	    st = con.prepareStatement(QUERY_REQUEST_PRESCRIPTION_PART_2);

	    st.setInt(1, prescriptionId);
	    st.setInt(2, userId);
	    st.setInt(3, medicineId);

	    st.executeUpdate();

	    result = true;

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(rs, st, con);
	}

	return result;
    }

}
