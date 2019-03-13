package by.horant.fintask.service;

public interface PrescriptionService {
    
    boolean requestPrescription(int userId, int medicineId) throws ServiceException;

}
