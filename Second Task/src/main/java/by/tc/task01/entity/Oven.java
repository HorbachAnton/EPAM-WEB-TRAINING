package by.tc.task01.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Oven extends Appliance {

    private static final double DEFAULT_WEIGHT = 0;
    private static final double DEFAULT_CAPACITY = 0;
    private static final double DEFAULT_DEPTH = 0;
    private static final double DEFAULT_HEIGHT = 0;
    private static final double DEFAULT_WIDTH = 0;

    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

    private double weight;
    private double capacity;
    private double depth;
    private double height;
    private double width;

    public Oven() {
	super();
	weight = DEFAULT_WEIGHT;
	capacity = DEFAULT_CAPACITY;
	depth = DEFAULT_DEPTH;
	height = DEFAULT_HEIGHT;
	width = DEFAULT_WIDTH;
    }

    public Oven(double weight, double capacity, double depth, double height, double width) {
	super();
	this.weight = weight;
	this.capacity = capacity;
	this.depth = depth;
	this.height = height;
	this.width = width;
    }

    public Oven(double weight, double capacity, double depth, double height, double width, double powerConsumption) {
	super(powerConsumption);
	this.weight = weight;
	this.capacity = capacity;
	this.depth = depth;
	this.height = height;
	this.width = width;
    }

    public Oven(Oven oven) {
	super(oven.getPowerConsumption());
	this.weight = oven.weight;
	this.capacity = oven.capacity;
	this.depth = oven.depth;
	this.height = oven.height;
	this.width = oven.width;
    }

    public double getWeight() {
	return weight;
    }

    public void setWeight(double weight) {
	this.weight = weight;
    }

    public double getCapacity() {
	return capacity;
    }

    public void setCapacity(double capacity) {
	this.capacity = capacity;
    }

    public double getDepth() {
	return depth;
    }

    public void setDepth(double depth) {
	this.depth = depth;
    }

    public double getHeight() {
	return height;
    }

    public void setHeight(double height) {
	this.height = height;
    }

    public double getWidth() {
	return width;
    }

    public void setWidth(double width) {
	this.width = width;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).appendSuper(super.hashCode()).append(capacity)
		.append(depth).append(height).append(weight).append(width).toHashCode();
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
	
	Oven other = (Oven) obj;

	return new EqualsBuilder().append(this.capacity, other.capacity).append(this.depth, other.depth)
		.append(this.height, other.height).append(this.weight, other.weight).append(this.width, other.width)
		.isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("weight", weight).append("capacity", capacity).append("depth", depth)
		.append("height", height).append("width", width).toString();
    }

}
