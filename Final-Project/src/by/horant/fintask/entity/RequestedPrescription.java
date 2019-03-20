package by.horant.fintask.entity;

import java.io.Serializable;

public class RequestedPrescription implements Serializable {

    private static final long serialVersionUID = -1753644068335312855L;

    private int id;
    private String userFirstName;
    private String userSecondName;
    private String medicineName;

    public RequestedPrescription() {

    }

    public RequestedPrescription(int id, String userFirstName, String userSecondName, String medicineName) {
	this.id = id;
	this.userFirstName = userFirstName;
	this.userSecondName = userSecondName;
	this.medicineName = medicineName;
    }

    public RequestedPrescription(RequestedPrescription requestedPrescription) {
	this.id = requestedPrescription.id;
	this.userFirstName = requestedPrescription.userFirstName;
	this.userSecondName = requestedPrescription.userSecondName;
	this.medicineName = requestedPrescription.medicineName;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getUserFirstName() {
	return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
	this.userFirstName = userFirstName;
    }

    public String getUserSecondName() {
	return userSecondName;
    }

    public void setUserSecondName(String userSecondName) {
	this.userSecondName = userSecondName;
    }

    public String getMedicineName() {
	return medicineName;
    }

    public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((medicineName == null) ? 0 : medicineName.hashCode());
	result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
	result = prime * result + ((userSecondName == null) ? 0 : userSecondName.hashCode());
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
	RequestedPrescription other = (RequestedPrescription) obj;
	if (id != other.id)
	    return false;
	if (medicineName == null) {
	    if (other.medicineName != null)
		return false;
	} else if (!medicineName.equals(other.medicineName))
	    return false;
	if (userFirstName == null) {
	    if (other.userFirstName != null)
		return false;
	} else if (!userFirstName.equals(other.userFirstName))
	    return false;
	if (userSecondName == null) {
	    if (other.userSecondName != null)
		return false;
	} else if (!userSecondName.equals(other.userSecondName))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "RequestedPrescription [id=" + id + ", userFirstName=" + userFirstName + ", userSecondName="
		+ userSecondName + ", medicineName=" + medicineName + "]";
    }

}
