package by.tc.task01.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class FindedProduct {

    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

    private List<String> finded;

    public FindedProduct() {
	finded = new ArrayList<>();
    }

    public FindedProduct(final List<String> finded) {
	this.finded = finded;
    }

    public FindedProduct(final FindedProduct findedPro) {
	this.finded = findedPro.finded;
    }

    public void add(final String str) {
	finded.add(str);
    }

    public List<String> getFinded() {
	return finded;
    }

    public void setFinded(final List<String> finded) {
	this.finded = finded;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).append(finded).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
	
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

	return new EqualsBuilder().append(this.finded, other.finded).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("finded", finded).toString();
    }

}
