package by.horant.fintask.service;

/**
 * The user of this interface undertakes to implement the service part of the
 * functionality for interacting with the recipe. This includes methods such as
 * requesting a recipe, approving recipe and unapproving recipe.
 * 
 * @author Anton Horbach
 *
 */
public interface PrescriptionService {

    /**
     * Creates a request for a recipe.
     * 
     * @param userId     user id requesting recipe.
     * @param medicineId id of the medicine for which the request is being created.
     * @return true - if request was created, false - if request wasn't created.
     * @throws ServiceException
     */
    boolean requestPrescription(int userId, int medicineId) throws ServiceException;

    /**
     * Approves a recipe request.
     * 
     * @param prescriptionId recipe id we want to approve
     * @return true - if request was approved, false - if request wasn't approved.
     * @throws ServiceException
     */
    boolean approvePrescription(int prescriptionId) throws ServiceException;

    /**
     * Unapproves a recipe request.
     * 
     * @param prescriptionId recipe id we want to unapprove.
     * @return true - if request was unapproved, false - if request wasn't
     *         unapproved.
     * @throws ServiceException
     */
    boolean unapprovePrescription(int prescriptionId) throws ServiceException;

}
