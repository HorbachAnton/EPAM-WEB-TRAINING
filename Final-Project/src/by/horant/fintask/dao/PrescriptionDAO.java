package by.horant.fintask.dao;

/**
 * The user of this interface undertakes to implement the functionality of
 * interaction with the recipe through the database. This includes methods such
 * as requesting a recipe, approval of a recipe, and non-approval of a recipe.
 * 
 * @author Anton Horbach
 *
 */
public interface PrescriptionDAO {

    /**
     * Creates a request for a recipe.
     * 
     * @param userId     user id requesting recipe.
     * @param medicineId id of the medicine for which the request is being created.
     * @return true - if request was created, false - if request wasn't created.
     * @throws DaoException
     */
    boolean requestPrescription(int userId, int medicineId) throws DaoException;

    /**
     * Approves a recipe request.
     * 
     * @param prescriptionId recipe id we want to approve
     * @return true - if request was approved, false - if request wasn't approved.
     * @throws DaoException
     */
    boolean approvePrescription(int prescriptionId) throws DaoException;

    /**
     * Unapproves a recipe request.
     * 
     * @param prescriptionId recipe id we want to unapprove.
     * @return true - if request was unapproved, false - if request wasn't
     *         unapproved.
     * @throws DaoException
     */
    boolean unapprovePrescription(int prescriptionId) throws DaoException;

}
