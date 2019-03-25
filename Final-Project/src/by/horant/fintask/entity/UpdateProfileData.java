package by.horant.fintask.entity;

import java.io.Serializable;

/**
 * Class UpdateProfileData is entity class, which encapsulates in itself new
 * user first and second name. The encapsulated data is entered by the user on
 * the profile update page, from where it is sent to the server.
 * 
 * @author Anton Horbach
 *
 */
public class UpdateProfileData implements Serializable {

    private static final long serialVersionUID = -2531564994047534603L;

    private String firstName;
    private String secondName;

    /**
     * Class constructor.
     */
    public UpdateProfileData() {

    }

    /**
     * Class constructor specifying new user first name and new user second name.
     * 
     * @param firstName  new user first name
     * @param secondName new user second name
     */
    public UpdateProfileData(String firstName, String secondName) {
	this.firstName = firstName;
	this.secondName = secondName;
    }

    /**
     * Returns new user first name.
     * 
     * @return new user first name.
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * Sets new user first name.
     * 
     * @param firstName new user first name.
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * Returns new user second name.
     * 
     * @return new user second name.
     */
    public String getSecondName() {
	return secondName;
    }

    /**
     * Sets new user second name.
     * 
     * @param secondName new user second name
     */
    public void setSecondName(String secondName) {
	this.secondName = secondName;
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
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
	UpdateProfileData other = (UpdateProfileData) obj;
	if (firstName == null) {
	    if (other.firstName != null)
		return false;
	} else if (!firstName.equals(other.firstName))
	    return false;
	if (secondName == null) {
	    if (other.secondName != null)
		return false;
	} else if (!secondName.equals(other.secondName))
	    return false;
	return true;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
	return "UpdateProfileData [firstName=" + firstName + ", secondName=" + secondName + "]";
    }

}
