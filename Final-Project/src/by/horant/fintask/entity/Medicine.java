package by.horant.fintask.entity;

import java.io.Serializable;

public class Medicine implements Serializable {

    private static final long serialVersionUID = 5391578435782265496L;

    private int id;
    private String name;
    private String description;
    private String type;
    private String dosage;
    private boolean isNeedPrescription;

    public Medicine() {

    }

    public Medicine(int id, String name, String description, String type, String dosage, boolean isNeedPrescription) {
	this.id = id;
	this.name = name;
	this.description = description;
	this.type = type;
	this.dosage = dosage;
	this.isNeedPrescription = isNeedPrescription;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getDosage() {
	return dosage;
    }

    public void setDosage(String dosage) {
	this.dosage = dosage;
    }

    public boolean isNeedPrescription() {
	return isNeedPrescription;
    }

    public void setNeedPrescription(boolean isNeedPrescription) {
	this.isNeedPrescription = isNeedPrescription;
    }

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

    @Override
    public String toString() {
	return "Medicine [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", dosage="
		+ dosage + ", isNeedPrescription=" + isNeedPrescription + "]";
    }

}
