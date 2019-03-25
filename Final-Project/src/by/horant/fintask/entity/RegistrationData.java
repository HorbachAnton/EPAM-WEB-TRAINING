package by.horant.fintask.entity;

import java.io.Serializable;

import by.horant.fintask.entity.enumeration.Roles;

/**
 * Class RegistrationData is entity class, which encapsulates in itself user
 * email, password and role. The encapsulated email and password is entered by
 * the user on the registration page, from where it is sent to the server.
 * 
 * @author Anton Horbach
 *
 */
public class RegistrationData implements Serializable {

    private static final long serialVersionUID = -8573050296164729085L;

    private String email;
    private String password;
    private Roles role;

    /**
     * Class constructor.
     */
    public RegistrationData() {

    }

    /**
     * Class constructor specifying user email specified during registration, user
     * password specified during registration and user role in systems.
     * 
     * @param email    user email specified during registration
     * @param password user password specified during registration
     * @param role     user role in systems
     */
    public RegistrationData(String email, String password, Roles role) {
	this.email = email;
	this.password = password;
	this.role = role;
    }

    /**
     * Returns user email.
     * 
     * @return user email.
     */
    public String getEmail() {
	return email;
    }

    /**
     * Sets user email.
     * 
     * @param email user email.
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Returns user password.
     * 
     * @return user password.
     */
    public String getPassword() {
	return password;
    }

    /**
     * Sets user password.
     * 
     * @param password user password.
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Returns user role.
     * 
     * @return user role.
     */
    public Roles getRole() {
	return role;
    }

    /**
     * Sets user role.
     * 
     * @param role user role.
     */
    public void setRole(Roles role) {
	this.role = role;
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     */
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

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
	return "RegistrationData [email=" + email + ", password=" + password + ", role=" + role + "]";
    }

}
