package by.tc.task01.entity;

public class Refrigerator extends Appliance {

    private static final double DEFAULT_WEIGHT = 0;
    private static final double DEFAULT_FREEZER_CAPACITY = 0;
    private static final double DEFAULT_OVERALL_CAPACITY = 0;
    private static final double DEFAULT_HEIGHT = 0;
    private static final double DEFAULT_WIDTH = 0;
    private double weight;
    private double freezer_capacity;
    private double overall_capacity;
    private double height;
    private double width;

    public Refrigerator() {
	super();
	this.weight = DEFAULT_WEIGHT;
	this.freezer_capacity = DEFAULT_FREEZER_CAPACITY;
	this.overall_capacity = DEFAULT_OVERALL_CAPACITY;
	this.height = DEFAULT_HEIGHT;
	this.width = DEFAULT_WIDTH;
    }

    public Refrigerator(double weight, double freezer_capacity, double overall_capacity, double height, double width) {
	super();
	this.weight = weight;
	this.freezer_capacity = freezer_capacity;
	this.overall_capacity = overall_capacity;
	this.height = height;
	this.width = width;
    }

    public Refrigerator(double weight, double freezer_capacity, double overall_capacity, double height, double width,
	    double power_consumption) {
	super(power_consumption);
	this.weight = weight;
	this.freezer_capacity = freezer_capacity;
	this.overall_capacity = overall_capacity;
	this.height = height;
	this.width = width;
    }

    public Refrigerator(Refrigerator refrigerator) {
	super(refrigerator.getPower_consumption());
	this.weight = refrigerator.weight;
	this.freezer_capacity = refrigerator.freezer_capacity;
	this.overall_capacity = refrigerator.overall_capacity;
	this.height = refrigerator.height;
	this.width = refrigerator.width;
    }

    public double getWeight() {
	return weight;
    }

    public void setWeight(double weight) {
	this.weight = weight;
    }

    public double getFreezer_capacity() {
	return freezer_capacity;
    }

    public void setFreezer_capacity(double freezer_capacity) {
	this.freezer_capacity = freezer_capacity;
    }

    public double getOverall_capacity() {
	return overall_capacity;
    }

    public void setOverall_capacity(double overall_capacity) {
	this.overall_capacity = overall_capacity;
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
	temp = Double.doubleToLongBits(freezer_capacity);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(height);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(overall_capacity);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(weight);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(width);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Refrigerator other = (Refrigerator) obj;
	if (Double.doubleToLongBits(freezer_capacity) != Double.doubleToLongBits(other.freezer_capacity))
	    return false;
	if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
	    return false;
	if (Double.doubleToLongBits(overall_capacity) != Double.doubleToLongBits(other.overall_capacity))
	    return false;
	if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
	    return false;
	if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Refrigerator [weight=" + weight + ", freezer_capacity=" + freezer_capacity + ", overall_capacity="
		+ overall_capacity + ", height=" + height + ", width=" + width + "]";
    }

}
