package by.horant.fintask.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MedicationWithoutRecipes implements Serializable {

    private static final long serialVersionUID = -5249605298254275001L;

    private List<Medicine> medicinesWithoutRecipes;

    public MedicationWithoutRecipes() {
	medicinesWithoutRecipes = new ArrayList<>();
    }

    public MedicationWithoutRecipes(List<Medicine> medicinesWithoutRecipes) {
	this.medicinesWithoutRecipes = medicinesWithoutRecipes;
    }

    public List<Medicine> getMedicinesWithoutRecipes() {
	return medicinesWithoutRecipes;
    }

    public void setMedicinesWithoutRecipes(List<Medicine> medicinesWithoutRecipes) {
	this.medicinesWithoutRecipes = medicinesWithoutRecipes;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((medicinesWithoutRecipes == null) ? 0 : medicinesWithoutRecipes.hashCode());
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
	MedicationWithoutRecipes other = (MedicationWithoutRecipes) obj;
	if (medicinesWithoutRecipes == null) {
	    if (other.medicinesWithoutRecipes != null)
		return false;
	} else if (!medicinesWithoutRecipes.equals(other.medicinesWithoutRecipes))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "MedicationWithoutRecipes [medicinesWithoutRecipes=" + medicinesWithoutRecipes + "]";
    }

}
