package by.horant.fintask.dao;

public interface PrescriptionDAO {

    boolean requestPrescription(int userId, int medicineId) throws DaoException;

}
