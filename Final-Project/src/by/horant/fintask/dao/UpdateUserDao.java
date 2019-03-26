package by.horant.fintask.dao;

import by.horant.fintask.entity.UpdateProfileData;

/**
 * The user of this interface undertakes to implement the functionality of
 * updating user data in the database. This includes updating your password,
 * email, and personal information (for example, first and last name).
 * 
 * @author Anton Horbach
 *
 */
public interface UpdateUserDao {

    /**
     * Updates user profile(for example, first and second name).
     * 
     * @param email      email user whose data we want to update.
     * @param updateData an object of class UpdateProfileData which encapsulates the
     *                   necessary data for updating.
     * @return true - if the update was successful, false - if the update wasn't
     *         successful.
     * @throws DaoException
     */
    boolean updateProfile(String email, UpdateProfileData updateData) throws DaoException;

    /**
     * Updates user password.
     * 
     * @param email    email user whose data we want to update.
     * @param password new user password.
     * @return true - if the update was successful, false - if the update wasn't
     *         successful.
     * @throws DaoException
     */
    boolean updatePassword(String email, String password) throws DaoException;

    /**
     * Updates user email.
     * 
     * @param newEmail new email user whose data we want to update.
     * @param oldEmail old email user whose data we want to update.
     * @return true - if the update was successful, false - if the update wasn't
     *         successful.
     * @throws DaoException
     */
    boolean updateEmail(String newEmail, String oldEmail) throws DaoException;

}
