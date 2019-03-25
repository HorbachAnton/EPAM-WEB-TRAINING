package by.horant.fintask.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.horant.fintask.entity.enumeration.OrderComleteStages;

/**
 * Class Order is entity class, which encapsulates in itself all order
 * information.
 * 
 * @author Anton Horbach
 *
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -3103026815995987629L;

    private int id;
    private User customer;
    private OrderComleteStages completeStage;
    private List<Prescription> prescriptions;
    private List<Medicine> purchasedMedications;

    /**
     * Class constructor.
     */
    public Order() {
	prescriptions = new ArrayList<>();
	purchasedMedications = new ArrayList<>();
    }

    /**
     * Class constructor specifying id order, user object, order completion stage,
     * prescription objects and purchased medicine objects.
     * 
     * @param id                   order number in integer format
     * @param customer             the object of the user who placed the order
     * @param completeStage        current order stage
     * @param prescriptions        list of prescriptions for the ordered medicines
     * @param purchasedMedications list of ordered medicines
     */
    public Order(int id, User customer, OrderComleteStages completeStage, List<Prescription> prescriptions,
	    List<Medicine> purchasedMedications) {
	this.id = id;
	this.customer = customer;
	this.completeStage = completeStage;
	this.prescriptions = prescriptions;
	this.purchasedMedications = purchasedMedications;
    }

    /**
     * Adds the medicine object to the medicine list for this order.
     * 
     * @param medicine the medicine object that you want to add.
     */
    public void addMedicine(Medicine medicine) {
	purchasedMedications.add(medicine);
    }

    /**
     * Removes the medicine object from the medicine list for this order.
     * 
     * @param medicine the medicine object that you want to remove.
     */
    public void removeMedicine(Medicine medicine) {
	purchasedMedications.remove(medicine);
    }

    /**
     * Adds the prescription object to the prescription list for this order.
     * 
     * @param prescription the prescription object that you want to add.
     */
    public void addPrescription(Prescription prescription) {
	prescriptions.add(prescription);
    }

    /**
     * Removes the prescription object from the prescription list for this order.
     * 
     * @param prescription the prescription object that you want to remove.
     */
    public void removePrescription(Prescription prescription) {
	prescriptions.remove(prescription);
    }

    /**
     * Returns order id.
     * 
     * @return order id.
     */
    public int getId() {
	return id;
    }

    /**
     * Sets order id.
     * 
     * @param id order id.
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Returns the object of the user who placed the order.
     * 
     * @return the object of the user who placed the order.
     */
    public User getCustomer() {
	return customer;
    }

    /**
     * Sets the object of the user who placed the order.
     * 
     * @param customer the object of the user who placed the order.
     */
    public void setCustomer(User customer) {
	this.customer = customer;
    }

    /**
     * Returns current order stage.
     * 
     * @return current order stage.
     */
    public OrderComleteStages getCompleteStage() {
	return completeStage;
    }

    /**
     * Sets current order stage.
     * 
     * @param completeStage current order stage
     */
    public void setCompleteStage(OrderComleteStages completeStage) {
	this.completeStage = completeStage;
    }

    /**
     * Returns list of prescriptions for the ordered medicines.
     * 
     * @return list of prescriptions for the ordered medicines.
     */
    public List<Prescription> getPrescriptions() {
	return prescriptions;
    }

    /**
     * Sets list of prescriptions for the ordered medicines.
     * 
     * @param prescriptions list of prescriptions for the ordered medicines.
     */
    public void setPrescriptions(List<Prescription> prescriptions) {
	this.prescriptions = prescriptions;
    }

    /**
     * Returns list of ordered medicines.
     * 
     * @return list of ordered medicines.
     */
    public List<Medicine> getPurchasedMedications() {
	return purchasedMedications;
    }

    /**
     * Sets list of ordered medicines.
     * 
     * @param purchasedMedications list of ordered medicines.
     */
    public void setPurchasedMedications(List<Medicine> purchasedMedications) {
	this.purchasedMedications = purchasedMedications;
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((customer == null) ? 0 : customer.hashCode());
	result = prime * result + id;
	result = prime * result + ((completeStage == null) ? 0 : completeStage.hashCode());
	result = prime * result + ((prescriptions == null) ? 0 : prescriptions.hashCode());
	result = prime * result + ((purchasedMedications == null) ? 0 : purchasedMedications.hashCode());
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
	Order other = (Order) obj;
	if (customer == null) {
	    if (other.customer != null)
		return false;
	} else if (!customer.equals(other.customer))
	    return false;
	if (id != other.id)
	    return false;
	if (completeStage != other.completeStage)
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

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
	return "Order [id=" + id + ", customer=" + customer + ", completeStage=" + completeStage + ", prescriptions="
		+ prescriptions + ", purchasedMedications=" + purchasedMedications + "]";
    }

}
