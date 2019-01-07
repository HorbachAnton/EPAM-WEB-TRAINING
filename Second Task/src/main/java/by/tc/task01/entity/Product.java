package by.tc.task01.entity;

public class Product {

    private int id;

    Product() {
	this.id = id + 1;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Product other = (Product) obj;
	if (id != other.id) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Product [id=" + id + "]";
    }

}
