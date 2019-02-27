package by.horant.fintask.entity;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    private static final long serialVersionUID = -3103026815995987629L;

    private int id;
    private User customer;
    private List<Prescription> prescriptions;
    private List<Medicine> purchasedMedications;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public User getCustomer() {
	return customer;
    }

    public void setCustomer(User customer) {
	this.customer = customer;
    }

    public List<Prescription> getPrescriptions() {
	return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
	this.prescriptions = prescriptions;
    }

    public List<Medicine> getPurchasedMedications() {
	return purchasedMedications;
    }

    public void setPurchasedMedications(List<Medicine> purchasedMedications) {
	this.purchasedMedications = purchasedMedications;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((customer == null) ? 0 : customer.hashCode());
	result = prime * result + id;
	result = prime * result + ((prescriptions == null) ? 0 : prescriptions.hashCode());
	result = prime * result + ((purchasedMedications == null) ? 0 : purchasedMedications.hashCode());
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
	Order other = (Order) obj;
	if (customer == null) {
	    if (other.customer != null)
		return false;
	} else if (!customer.equals(other.customer))
	    return false;
	if (id != other.id)
	    return false;
	if (prescriptions == null) {
	    if (other.prescriptions != null)
		return false;
	} else if (!prescriptions.equals(other.prescriptions))
	    return false;
	if (purchasedMedications == null) {
	    if (other.purchasedMedications != null)
		return false;
	} else if (!purchasedMedications.equals(other.purchasedMedications))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Order [id=" + id + ", customer=" + customer + ", prescriptions=" + prescriptions
		+ ", purchasedMedications=" + purchasedMedications + "]";
    }

}
