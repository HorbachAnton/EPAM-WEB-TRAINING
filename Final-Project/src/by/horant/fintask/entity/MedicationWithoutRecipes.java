package by.horant.fintask.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class MedicationWithoutRecipes is entity class, which encapsulates in itself
 * list of medicines without prescriptions.
 * 
 * @author Anton Horbach
 *
 */
public class MedicationWithoutRecipes implements Serializable {

    private static final long serialVersionUID = -5249605298254275001L;

    private List<Medicine> medicinesWithoutRecipes;

    /**
     * Class constructor
     */
    public MedicationWithoutRecipes() {
	medicinesWithoutRecipes = new ArrayList<>();
    }

    /**
     * Copy constructor
     * 
     * @param medicinesWithoutRecipes copied medicinesWithoutRecipes object
     */
    public MedicationWithoutRecipes(List<Medicine> medicinesWithoutRecipes) {
	this.medicinesWithoutRecipes = medicinesWithoutRecipes;
    }

    /**
     * Returns list of medicines without prescriptions.
     * 
     * @return list of medicines without prescriptions.
     */
    public List<Medicine> getMedicinesWithoutRecipes() {
	return medicinesWithoutRecipes;
    }

    /**
     * Sets list of medicines without prescriptions.
     * 
     * @param medicinesWithoutRecipes list of medicines without prescriptions.
     */
    public void setMedicinesWithoutRecipes(List<Medicine> medicinesWithoutRecipes) {
	this.medicinesWithoutRecipes = medicinesWithoutRecipes;
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((medicinesWithoutRecipes == null) ? 0 : medicinesWithoutRecipes.hashCode());
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
	MedicationWithoutRecipes other = (MedicationWithoutRecipes) obj;
	if (medicinesWithoutRecipes == null) {
	    if (other.medicinesWithoutRecipes != null)
		return false;
	} else if (!medicinesWithoutRecipes.equals(other.medicinesWithoutRecipes))
	    return false;
	return true;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
	return "MedicationWithoutRecipes [medicinesWithoutRecipes=" + medicinesWithoutRecipes + "]";
    }

}
