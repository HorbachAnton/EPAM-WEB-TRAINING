package by.horant.fintask.entity;

import java.io.Serializable;
import java.time.LocalDate;

import by.horant.fintask.entity.enumeration.ApprovedStages;
import by.horant.fintask.entity.enumeration.UsedStages;

public class Prescription implements Serializable {

    private static final long serialVersionUID = 5632603224293017881L;

    private int id;
    private User recipient;
    private LocalDate issueDate;
    private ApprovedStages approvedStage;
    private UsedStages usedStage;
    private Medicine prescribedMedication;

    public Prescription() {

    }

    public Prescription(int id, User recipient, LocalDate issueDate, ApprovedStages approvedStage, UsedStages usedStage,
	    Medicine prescribedMedication) {
	this.id = id;
	this.recipient = recipient;
	this.issueDate = issueDate;
	this.approvedStage = approvedStage;
	this.usedStage = usedStage;
	this.prescribedMedication = prescribedMedication;
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

    public LocalDate getIssueDate() {
	return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
	this.issueDate = issueDate;
    }

    public ApprovedStages getApprovedStage() {
	return approvedStage;
    }

    public void setApprovedStage(ApprovedStages approvedStage) {
	this.approvedStage = approvedStage;
    }

    public UsedStages getUsedStage() {
	return usedStage;
    }

    public void setUsedStage(UsedStages usedStage) {
	this.usedStage = usedStage;
    }

    public Medicine getPrescribedMedication() {
	return prescribedMedication;
    }

    public void setPrescribedMedication(Medicine prescribedMedication) {
	this.prescribedMedication = prescribedMedication;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((approvedStage == null) ? 0 : approvedStage.hashCode());
	result = prime * result + id;
	result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
	result = prime * result + ((prescribedMedication == null) ? 0 : prescribedMedication.hashCode());
	result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
	result = prime * result + ((usedStage == null) ? 0 : usedStage.hashCode());
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
	if (approvedStage != other.approvedStage)
	    return false;
	if (id != other.id)
	    return false;
	if (issueDate == null) {
	    if (other.issueDate != null)
		return false;
	} else if (!issueDate.equals(other.issueDate))
	    return false;
	if (prescribedMedication == null) {
	    if (other.prescribedMedication != null)
		return false;
	} else if (!prescribedMedication.equals(other.prescribedMedication))
	    return false;
	if (recipient == null) {
	    if (other.recipient != null)
		return false;
	} else if (!recipient.equals(other.recipient))
	    return false;
	if (usedStage != other.usedStage)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Prescription [id=" + id + ", recipient=" + recipient + ", issueDate=" + issueDate + ", approvedStage="
		+ approvedStage + ", usedStage=" + usedStage + ", prescribedMedication=" + prescribedMedication + "]";
    }

}
