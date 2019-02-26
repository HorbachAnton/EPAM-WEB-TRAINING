package by.horant.fintask.dao.util;

import by.horant.fintask.entity.enumeration.Roles;

public class RolesIdentifier {
    
    private RolesIdentifier() {
	
    }
    
    public static Roles defineByIndex(int identifierRole) {
	Roles role = null;
	if (Roles.ADMIN.getIdentifier() == identifierRole) {
	    role = Roles.ADMIN;
	} else if (Roles.USER.getIdentifier() == identifierRole) {
	    role = Roles.USER;
	} else if (Roles.PHARMACIST.getIdentifier() == identifierRole) {
	    role = Roles.PHARMACIST;
	} else if (Roles.DOCTOR.getIdentifier() == identifierRole) {
	    role = Roles.DOCTOR;
	} else {
	    
	}
	return role;
    }

}
