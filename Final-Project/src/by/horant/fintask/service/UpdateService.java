package by.horant.fintask.service;

import by.horant.fintask.entity.UpdateProfileData;

public interface UpdateService {
    
    boolean updateProfile(String email, UpdateProfileData updateData) throws ServiceException;
    
    boolean updatePassword(String email, String password) throws ServiceException; 
    
    boolean updateEmail(String newEmail, String oldEmail) throws ServiceException;

}
