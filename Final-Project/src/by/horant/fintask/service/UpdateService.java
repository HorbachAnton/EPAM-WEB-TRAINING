package by.horant.fintask.service;

import by.horant.fintask.entity.UpdateProfileData;

/**
 * The user of this interface undertakes to implement the service part for
 * updating user data. These include updating the password, email and personal
 * data (for example, first and second name).
 * 
 * @author Anton Horbach
 *
 */
public interface UpdateService {

    /**
     * Updates user profile(for example, first and second name).
     * 
     * @param email      email user whose data we want to update.
     * @param updateData an object of class UpdateProfileData which encapsulates the
     *                   necessary data for updating.
     * @return true - if the update was successful, false - if the update wasn't
     *         successful.
     * @throws ServiceException
     */
    boolean updateProfile(String email, UpdateProfileData updateData) throws ServiceException;

    /**
     * Updates user password.
     * 
     * @param email    email user whose data we want to update.
     * @param password new user password.
     * @return true - if the update was successful, false - if the update wasn't
     *         successful.
     * @throws ServiceException
     */
    boolean updatePassword(String email, String password) throws ServiceException;

    /**
     * Updates user email.
     * 
     * @param newEmail new email user whose data we want to update.
     * @param oldEmail old email user whose data we want to update.
     * @return true - if the update was successful, false - if the update wasn't
     *         successful.
     * @throws ServiceException
     */
    boolean updateEmail(String newEmail, String oldEmail) throws ServiceException;

}
