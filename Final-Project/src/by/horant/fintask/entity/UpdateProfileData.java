package by.horant.fintask.entity;

import java.io.Serializable;

public class UpdateProfileData implements Serializable {

    private static final long serialVersionUID = -2531564994047534603L;

    private String firstName;
    private String secondName;

    public UpdateProfileData() {

    }

    public UpdateProfileData(String firstName, String secondName) {
	this.firstName = firstName;
	this.secondName = secondName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getSecondName() {
	return secondName;
    }

    public void setSecondName(String secondName) {
	this.secondName = secondName;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
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

    @Override
    public String toString() {
	return "UpdateProfileData [firstName=" + firstName + ", secondName=" + secondName + "]";
    }

}
