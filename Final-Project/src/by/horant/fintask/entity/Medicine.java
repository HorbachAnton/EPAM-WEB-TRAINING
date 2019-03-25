package by.horant.fintask.entity;

import java.io.Serializable;

/**
 * Class Medicine is entity class, which encapsulates in itself all medicine
 * information. 
 * 
 * @author Anton Horbach
 *
 */
public class Medicine implements Serializable {

    private static final long serialVersionUID = 5391578435782265496L;

    private int id;
    private String name;
    private String description;
    private String type;
    private String dosage;
    private boolean isNeedPrescription;

    /**
     * Class constructor.
     */
    public Medicine() {

    }

    /**
     * Class constructor specifying medicine id, name, description, type, dosage and
     * the need for a recipe when ordering.
     * 
     * @param id                 medicine number in integer format
     * @param name               medicine name
     * @param description        medicine description
     * @param type               medicine type
     * @param dosage             medicine dosage
     * @param isNeedPrescription a flag indicating whether or not a prescription is
     *                           needed when ordering this medicine.
     */
    public Medicine(int id, String name, String description, String type, String dosage, boolean isNeedPrescription) {
	this.id = id;
	this.name = name;
	this.description = description;
	this.type = type;
	this.dosage = dosage;
	this.isNeedPrescription = isNeedPrescription;
    }

    /**
     * Returns medicine id.
     * 
     * @return medicine id.
     */
    public int getId() {
	return id;
    }

    /**
     * Sets medicine id.
     * 
     * @param id medicine id.
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Returns medicine name.
     * 
     * @return medicine name,
     */
    public String getName() {
	return name;
    }

    /**
     * Sets medicine name.
     * 
     * @param name medicine name.
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Returns medicine description.
     * 
     * @return medicine description.
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets medicine description.
     * 
     * @param description medicine description.
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Returns medicine type.
     * 
     * @return medicine type.
     */
    public String getType() {
	return type;
    }

    /**
     * Sets medicine type.
     * 
     * @param type medicine type.
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Returns medicine dosage.
     * 
     * @return medicine dosage.
     */
    public String getDosage() {
	return dosage;
    }

    /**
     * Sets medicine dosage.
     * 
     * @param dosage medicine dosage.
     */
    public void setDosage(String dosage) {
	this.dosage = dosage;
    }

    /**
     * Returns a flag indicating whether or not a prescription is needed when
     * ordering this medicine.
     * 
     * @return a flag indicating whether or not a prescription is needed when
     *         ordering this medicine
     */
    public boolean isNeedPrescription() {
	return isNeedPrescription;
    }

    /**
     * Sets a flag indicating whether or not a prescription is needed when ordering
     * this medicine.
     * 
     * @param isNeedPrescription a flag indicating whether or not a prescription is
     *                           needed when ordering this medicine
     */
    public void setNeedPrescription(boolean isNeedPrescription) {
	this.isNeedPrescription = isNeedPrescription;
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((dosage == null) ? 0 : dosage.hashCode());
	result = prime * result + id;
	result = prime * result + (isNeedPrescription ? 1231 : 1237);
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
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
	Medicine other = (Medicine) obj;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (dosage == null) {
	    if (other.dosage != null)
		return false;
	} else if (!dosage.equals(other.dosage))
	    return false;
	if (id != other.id)
	    return false;
	if (isNeedPrescription != other.isNeedPrescription)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (type == null) {
	    if (other.type != null)
		return false;
	} else if (!type.equals(other.type))
	    return false;
	return true;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
	return "Medicine [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", dosage="
		+ dosage + ", isNeedPrescription=" + isNeedPrescription + "]";
    }

}
