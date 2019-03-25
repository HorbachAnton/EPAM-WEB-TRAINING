package by.horant.fintask.entity;

import java.io.Serializable;
import java.time.LocalDate;

import by.horant.fintask.entity.enumeration.ApprovedStages;
import by.horant.fintask.entity.enumeration.UsedStages;

/**
 * Class Prescription is entity class, which encapsulates in itself all
 * prescription information.
 * 
 * @author Anton Horbach
 *
 */
public class Prescription implements Serializable {

    private static final long serialVersionUID = 5632603224293017881L;

    private int id;
    private User recipient;
    private LocalDate issueDate;
    private ApprovedStages approvedStage;
    private UsedStages usedStage;
    private Medicine prescribedMedication;

    /**
     * Class constructor.
     */
    public Prescription() {

    }

    /**
     * Class constructor specifying prescription id, recipient object of this
     * prescription, date of receipt of the recipe, recipe approval stage, recipe
     * used stage and medicine object for which a prescription is issued.
     * 
     * @param id                   prescription number in integer format
     * @param recipient            the recipient's object on whose face the
     *                             prescription is written.
     * @param issueDate            date of receipt of the recipe
     * @param approvedStage        recipe approval stage
     * @param usedStage            recipe used stage
     * @param prescribedMedication medicine object for which a prescription is
     *                             issued
     */
    public Prescription(int id, User recipient, LocalDate issueDate, ApprovedStages approvedStage, UsedStages usedStage,
	    Medicine prescribedMedication) {
	this.id = id;
	this.recipient = recipient;
	this.issueDate = issueDate;
	this.approvedStage = approvedStage;
	this.usedStage = usedStage;
	this.prescribedMedication = prescribedMedication;
    }

    /**
     * Returns prescription id.
     * 
     * @return prescription id.
     */
    public int getId() {
	return id;
    }

    /**
     * Sets prescription id.
     * 
     * @param id prescription id.
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Returns object of class User on whose face prescription is written.
     * 
     * @return object of class User on whose face prescription is written.
     */
    public User getRecipient() {
	return recipient;
    }

    /**
     * Sets object of class User on whose face prescription is written.
     * 
     * @param recipient object of class User on whose face prescription is written.
     */
    public void setRecipient(User recipient) {
	this.recipient = recipient;
    }

    /**
     * Returns date of receipt of the recipe.
     * 
     * @return date of receipt of the recipe.
     */
    public LocalDate getIssueDate() {
	return issueDate;
    }

    /**
     * Sets date of receipt of the recipe.
     * 
     * @param issueDate date of receipt of the recipe.
     */
    public void setIssueDate(LocalDate issueDate) {
	this.issueDate = issueDate;
    }

    /**
     * Returns current recipe approval stage.
     * 
     * @return current recipe approval stage.
     */
    public ApprovedStages getApprovedStage() {
	return approvedStage;
    }

    /**
     * Sets current recipe approval stage.
     * 
     * @param approvedStage current recipe approval stage.
     */
    public void setApprovedStage(ApprovedStages approvedStage) {
	this.approvedStage = approvedStage;
    }

    /**
     * Returns current recipe used stage.
     * 
     * @return current recipe used stage.
     */
    public UsedStages getUsedStage() {
	return usedStage;
    }

    /**
     * Sets current recipe used stage.
     * 
     * @param usedStage current recipe used stage.
     */
    public void setUsedStage(UsedStages usedStage) {
	this.usedStage = usedStage;
    }

    /**
     * Returns medicine object for which a prescription is issued.
     * 
     * @return medicine object for which a prescription is issued.
     */
    public Medicine getPrescribedMedication() {
	return prescribedMedication;
    }

    /**
     * Sets medicine object for which a prescription is issued.
     * 
     * @param prescribedMedication medicine object for which a prescription is
     *                             issued.
     */
    public void setPrescribedMedication(Medicine prescribedMedication) {
	this.prescribedMedication = prescribedMedication;
    }

    /**
     * Returns a hash code value for the object.
     */
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

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
	return "Prescription [id=" + id + ", recipient=" + recipient + ", issueDate=" + issueDate + ", approvedStage="
		+ approvedStage + ", usedStage=" + usedStage + ", prescribedMedication=" + prescribedMedication + "]";
    }

}
