package by.horant.task3.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GeneralFood extends Food implements Serializable{

    private static final long serialVersionUID = -4047171491524121259L;
    
    public static final int VALUE_FOR_HASH_1 = 1;
    public static final int VALUE_FOR_HASH_2 = 31;

    private String generalPortion;
    private double generalPrice;

    public GeneralFood() {
	super();
    }

    public GeneralFood(String generalPortion, double generalPrice) {
	this();
	this.generalPortion = generalPortion;
	this.generalPrice = generalPrice;
    }

    public GeneralFood(GeneralFood food) {
	this(food.generalPortion, food.generalPrice);
    }

    public String getGeneralPortion() {
	return generalPortion;
    }

    public void setGeneralPortion(String generalPortion) {
	this.generalPortion = generalPortion;
    }

    public double getGeneralPrice() {
	return generalPrice;
    }

    public void setGeneralPrice(int generalPrice) {
	this.generalPrice = generalPrice;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).appendSuper(super.hashCode())
		.append(generalPortion).append(generalPrice).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

	if (this == obj) {
	    return true;
	}

	if (!super.equals(obj)) {
	    return false;
	}

	if (getClass() != obj.getClass()) {
	    return false;
	}

	GeneralFood other = (GeneralFood) obj;

	return new EqualsBuilder().append(this.generalPortion, other.generalPortion)
		.append(this.generalPrice, other.generalPrice).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).appendSuper(super.toString()).append("generalPortion", generalPortion)
		.append("generalPrice", generalPrice).toString();
    }

}
