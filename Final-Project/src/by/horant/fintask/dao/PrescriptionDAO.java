package by.horant.fintask.dao;

public interface PrescriptionDAO {

    boolean requestPrescription(int userId, int medicineId) throws DaoException;

    boolean approvePrescription(int prescriptionId) throws DaoException;

    boolean unapprovePrescription(int prescriptionId) throws DaoException;

}
