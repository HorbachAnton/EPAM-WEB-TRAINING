package by.horant.fintask.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Prescription implements Serializable {

    private static final long serialVersionUID = 5632603224293017881L;

    private int id;
    private User recipient;
    private LocalDateTime expirationDate;
    private List<Medicine> prescribedMedications;

    public Prescription() {

    }

    public Prescription(int id, User recipient, LocalDateTime expirationDate, List<Medicine> prescribedMedications) {
	this.id = id;
	this.recipient = recipient;
	this.expirationDate = expirationDate;
	this.prescribedMedications = prescribedMedications;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public User getRecipient() {
	return recipient;
    }

    public void setRecipient(User recipient) {
	this.recipient = recipient;
    }

    public LocalDateTime getExpirationDate() {
	return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
	this.expirationDate = expirationDate;
    }

    public List<Medicine> getPrescribedMedications() {
	return prescribedMedications;
    }

    public void setPrescribedMedications(List<Medicine> prescribedMedications) {
	this.prescribedMedications = prescribedMedications;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
	result = prime * result + id;
	result = prime * result + ((prescribedMedications == null) ? 0 : prescribedMedications.hashCode());
	result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
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
	Prescription other = (Prescription) obj;
	if (expirationDate == null) {
	    if (other.expirationDate != null)
		return false;
	} else if (!expirationDate.equals(other.expirationDate))
	    return false;
	if (id != other.id)
	    return false;
	if (prescribedMedications == null) {
	    if (other.prescribedMedications != null)
		return false;
	} else if (!prescribedMedications.equals(other.prescribedMedications))
	    return false;
	if (recipient == null) {
	    if (other.recipient != null)
		return false;
	} else if (!recipient.equals(other.recipient))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Prescription [id=" + id + ", recipient=" + recipient + ", expirationDate=" + expirationDate
		+ ", prescribedMedications=" + prescribedMedications + "]";
    }

}
