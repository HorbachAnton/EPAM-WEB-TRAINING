package by.tc.task01.entity;

public class Refrigerator extends Appliance {

    private static final double DEFAULT_WEIGHT = 0;
    private static final double DEFAULT_FREEZER_CAPACITY = 0;
    private static final double DEFAULT_OVERALL_CAPACITY = 0;
    private static final double DEFAULT_HEIGHT = 0;
    private static final double DEFAULT_WIDTH = 0;
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
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(freezerCapacity);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(height);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(overallCapacity);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(weight);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(width);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
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
	if (Double.doubleToLongBits(freezerCapacity) != Double.doubleToLongBits(other.freezerCapacity)) {
	    return false;
	}
	if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
	    return false;
	}
	if (Double.doubleToLongBits(overallCapacity) != Double.doubleToLongBits(other.overallCapacity)) {
	    return false;
	}
	if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight)) {
	    return false;
	}
	if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Refrigerator [weight=" + weight + ", freezer_capacity=" + freezerCapacity + ", overall_capacity="
		+ overallCapacity + ", height=" + height + ", width=" + width + "]";
    }

}
