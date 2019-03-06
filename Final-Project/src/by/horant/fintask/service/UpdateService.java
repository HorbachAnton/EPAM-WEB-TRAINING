package by.horant.fintask.service;

import by.horant.fintask.entity.UpdateProfileData;

public interface UpdateService {
    
    boolean updateProfile(String email, UpdateProfileData updateData) throws ServiceException;
    
    boolean updatePassword();
    
    boolean updateEmail();

}
