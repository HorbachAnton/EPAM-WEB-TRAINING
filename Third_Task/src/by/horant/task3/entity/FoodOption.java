package by.horant.task3.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class FoodOption implements Comparable<FoodOption>, Serializable {

    private static final long serialVersionUID = -5656867751828844726L;
    
    public static final int VALUE_FOR_HASH_1 = 1;
    public static final int VALUE_FOR_HASH_2 = 31;

    private int optionNumber;
    private String optionDescription;
    private String optionPortion;
    private double optionPrice;

    public FoodOption() {

    }

    public FoodOption(int optionNumber, String optionDescription, String optionPortion, double optionPrice) {
	this.optionNumber = optionNumber;
	this.optionDescription = optionDescription;
	this.optionPortion = optionPortion;
	this.optionPrice = optionPrice;
    }

    public FoodOption(FoodOption option) {
	this(option.optionNumber, option.optionDescription, option.optionPortion, option.optionPrice);
    }

    public int getOptionNumber() {
	return optionNumber;
    }

    public void setOptionNumber(int optionNumber) {
	this.optionNumber = optionNumber;
    }

    public String getOptionDescription() {
	return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
	this.optionDescription = optionDescription;
    }

    public String getOptionPortion() {
	return optionPortion;
    }

    public void setOptionPortion(String optionPortion) {
	this.optionPortion = optionPortion;
    }

    public double getOptionPrice() {
	return optionPrice;
    }

    public void setOptionPrice(double optionPrice) {
	this.optionPrice = optionPrice;
    }

    @Override
    public int compareTo(FoodOption option) {
	return new CompareToBuilder().append(this.optionNumber, option.optionNumber)
		.append(this.optionDescription, option.optionDescription)
		.append(this.optionPortion, option.optionPortion).append(this.optionPrice, option.optionPrice)
		.toComparison();
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).append(optionNumber).append(optionDescription)
		.append(optionPortion).append(optionPrice).toHashCode();
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

	FoodOption other = (FoodOption) obj;

	return new EqualsBuilder().append(this.optionNumber, other.optionNumber)
		.append(this.optionDescription, other.optionDescription).append(this.optionPortion, other.optionPortion)
		.append(this.optionPrice, other.optionPrice).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("optionNumber", optionNumber)
		.append("optionDescription", optionDescription).append("optionPortion", optionPortion)
		.append("optionPrice", optionPrice).toString();
    }

}
