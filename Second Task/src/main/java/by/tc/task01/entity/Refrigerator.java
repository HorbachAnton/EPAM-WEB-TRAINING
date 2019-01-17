package by.tc.task01.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Refrigerator extends Appliance {

    private static final double DEFAULT_WEIGHT = 0;
    private static final double DEFAULT_FREEZER_CAPACITY = 0;
    private static final double DEFAULT_OVERALL_CAPACITY = 0;
    private static final double DEFAULT_HEIGHT = 0;
    private static final double DEFAULT_WIDTH = 0;

    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

    private double weight;
    private double freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public Refrigerator() {
	super();
	this.weight = DEFAULT_WEIGHT;
	this.freezerCapacity = DEFAULT_FREEZER_CAPACITY;
	this.overallCapacity = DEFAULT_OVERALL_CAPACITY;
	this.height = DEFAULT_HEIGHT;
	this.width = DEFAULT_WIDTH;
    }

    public Refrigerator(final double weight, final double freezerCapacity, final double overallCapacity,
	    final double height, final double width) {
	super();
	this.weight = weight;
	this.freezerCapacity = freezerCapacity;
	this.overallCapacity = overallCapacity;
	this.height = height;
	this.width = width;
    }

    public Refrigerator(final double weight, final double freezerCapacity, final double overallCapacity,
	    final double height, final double width, final double powerConsumption) {
	super(powerConsumption);
	this.weight = weight;
	this.freezerCapacity = freezerCapacity;
	this.overallCapacity = overallCapacity;
	this.height = height;
	this.width = width;
    }

    public Refrigerator(final Refrigerator refrigerator) {
	super(refrigerator.getPowerConsumption());
	this.weight = refrigerator.weight;
	this.freezerCapacity = refrigerator.freezerCapacity;
	this.overallCapacity = refrigerator.overallCapacity;
	this.height = refrigerator.height;
	this.width = refrigerator.width;
    }

    public double getWeight() {
	return weight;
    }

    public void setWeight(final double weight) {
	this.weight = weight;
    }

    public double getFreezerCapacity() {
	return freezerCapacity;
    }

    public void setFreezerCapacity(final double freezerCapacity) {
	this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
	return overallCapacity;
    }

    public void setOverallCapacity(final double overallCapacity) {
	this.overallCapacity = overallCapacity;
    }

    public double getHeight() {
	return height;
    }

    public void setHeight(final double height) {
	this.height = height;
    }

    public double getWidth() {
	return width;
    }

    public void setWidth(final double width) {
	this.width = width;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).appendSuper(super.hashCode())
		.append(freezerCapacity).append(height).append(overallCapacity).append(weight).append(width)
		.toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {

	if (this == obj) {
	    return true;
	}

	if (!super.equals(obj)) {
	    return false;
	}

	if (getClass() != obj.getClass()) {
	    return false;
	}

	Refrigerator other = (Refrigerator) obj;

	return new EqualsBuilder().append(this.freezerCapacity, other.freezerCapacity).append(this.height, other.height)
		.append(this.overallCapacity, other.overallCapacity).append(this.weight, other.weight)
		.append(this.width, other.width).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("weight", weight).append("freezer_capacity", freezerCapacity)
		.append("overallCapacity", overallCapacity).append("height", height).append("width", width).toString();
    }

}
