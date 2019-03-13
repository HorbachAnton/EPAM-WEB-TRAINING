package by.horant.fintask.dao;

import by.horant.fintask.entity.UpdateProfileData;

public interface UpdateUserDao {

    boolean updateProfile(String email, UpdateProfileData updateData) throws DaoException;

    boolean updatePassword(String email, String password) throws DaoException;

    boolean updateEmail(String newEmail, String oldEmail) throws DaoException;

}
