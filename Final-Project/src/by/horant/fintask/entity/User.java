package by.horant.fintask.entity;

import java.io.Serializable;

import by.horant.fintask.entity.enumeration.Roles;

/**
 * Class User is entity class, which encapsulates in itself all user
 * information.
 * 
 * @author Anton Horbach
 *
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1646459556345904320L;

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private Roles role;

    /**
     * Class constructor.
     */
    public User() {

    }

    /**
     * Class constructor specifying user id, email, password, first and second name
     * and user role in systems.
     * 
     * @param id         user id
     * @param email      user email
     * @param password   user password
     * @param firstName  user first name
     * @param secondName user second name
     * @param role       user role in systems
     */
    public User(int id, String email, String password, String firstName, String secondName, Roles role) {
	this.id = id;
	this.email = email;
	this.password = password;
	this.firstName = firstName;
	this.secondName = secondName;
	this.role = role;
    }

    /**
     * Returns user id.
     * 
     * @return user id
     */
    public int getId() {
	return id;
    }

    /**
     * Sets user id.
     * 
     * @param id user id
     */
    public void setId(int id) {
	this.id = id;
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
     * Returns user first name.
     * 
     * @return user first name
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * Sets user first name.
     * 
     * @param firstName user first name
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * Returns user second name.
     * 
     * @return user second name.
     */
    public String getSecondName() {
	return secondName;
    }

    /**
     * Sets user second name.
     * 
     * @param secondName user second name.
     */
    public void setSecondName(String secondName) {
	this.secondName = secondName;
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
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + id;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
	return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	User other = (User) obj;
	if (email == null) {
	    if (other.email != null) {
		return false;
	    }
	} else if (!email.equals(other.email)) {
	    return false;
	}
	if (firstName == null) {
	    if (other.firstName != null) {
		return false;
	    }
	} else if (!firstName.equals(other.firstName))
	    return false;
	if (id != other.id)
	    return false;
	if (password == null) {
	    if (other.password != null) {
		return false;
	    }
	} else if (!password.equals(other.password))
	    return false;
	if (role != other.role)
	    return false;
	if (secondName == null) {
	    if (other.secondName != null) {
		return false;
	    }
	} else if (!secondName.equals(other.secondName))
	    return false;
	return true;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
	return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
		+ ", secondName=" + secondName + ", role=" + role + "]";
    }

}
