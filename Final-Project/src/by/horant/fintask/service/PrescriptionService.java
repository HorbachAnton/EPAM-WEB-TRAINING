package by.horant.fintask.service;

public interface PrescriptionService {

    boolean requestPrescription(int userId, int medicineId) throws ServiceException;

    boolean approvePrescription(int prescriptionId) throws ServiceException;

    boolean unapprovePrescription(int prescriptionId) throws ServiceException;

}
