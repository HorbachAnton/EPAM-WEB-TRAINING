package by.tc.task01.entity;

import java.util.ArrayList;
import java.util.List;

public class FindedProduct {

    private List<String> finded;

    public FindedProduct() {
	finded = new ArrayList<String>();
    }

    public FindedProduct(List<String> finded) {
	this.finded = finded;
    }

    public FindedProduct(FindedProduct findedPro) {
	this.finded = findedPro.finded;
    }

    public void add(String str) {
	finded.add(str);
    }

    public List<String> getFinded() {
	return finded;
    }

    public void setFinded(List<String> finded) {
	this.finded = finded;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((finded == null) ? 0 : finded.hashCode());
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
	FindedProduct other = (FindedProduct) obj;
	if (finded == null) {
	    if (other.finded != null) {
		return false;
	    }
	} else if (!finded.equals(other.finded)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "FindedProduct [finded=" + finded + "]";
    }

}
