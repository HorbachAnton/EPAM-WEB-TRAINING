package by.tc.task01.entity;

public class Oven extends Appliance {

    private static final double DEFAULT_WEIGHT = 0;
    private static final double DEFAULT_CAPACITY = 0;
    private static final double DEFAULT_DEPTH = 0;
    private static final double DEFAULT_HEIGHT = 0;
    private static final double DEFAULT_WIDTH = 0;
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
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(capacity);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(depth);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(height);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(weight);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(width);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
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
	if (Double.doubleToLongBits(capacity) != Double.doubleToLongBits(other.capacity)) {
	    return false;
	}
	if (Double.doubleToLongBits(depth) != Double.doubleToLongBits(other.depth)) {
	    return false;
	}
	if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
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
	return "Oven [weight=" + weight + ", capacity=" + capacity + ", depth=" + depth + ", height=" + height
		+ ", width=" + width + "]";
    }

}
