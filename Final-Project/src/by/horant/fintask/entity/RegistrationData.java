package by.horant.fintask.entity;

import java.io.Serializable;

import by.horant.fintask.entity.enumeration.Roles;

public class RegistrationData implements Serializable{

    private static final long serialVersionUID = -8573050296164729085L;
    
    private String email;
    private String password;
    private Roles role;

    public RegistrationData() {

    }

    public RegistrationData(String email, String password, Roles role) {
	this.email = email;
	this.password = password;
	this.role = role;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Roles getRole() {
	return role;
    }

    public void setRole(Roles role) {
	this.role = role;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	RegistrationData other = (RegistrationData) obj;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (password == null) {
	    if (other.password != null)
		return false;
	} else if (!password.equals(other.password))
	    return false;
	if (role != other.role)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "RegistrationData [email=" + email + ", password=" + password + ", role=" + role + "]";
    }

}
