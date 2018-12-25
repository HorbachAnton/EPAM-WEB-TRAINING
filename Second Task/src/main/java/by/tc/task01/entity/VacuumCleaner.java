package by.tc.task01.entity;

public class VacuumCleaner extends Appliance {

    private static final String DEFAULT_FILTER_TYPE = "";
    private static final String DEFAULT_BAG_TYPE = "";
    private static final String DEFAULT_WAND_TYPE = "";
    private static final double DEFAULT_MOTOR_SPEED_REGULATION = 0;
    private static final double DEFAULT_CLEANING_WIDTH = 0;
    private String filter_type;
    private String bag_type;
    private String wand_type;
    private double motor_speed_regulation;
    private double cleaning_width;

    public VacuumCleaner() {
	super();
	this.filter_type = DEFAULT_FILTER_TYPE;
	this.bag_type = DEFAULT_BAG_TYPE;
	this.wand_type = DEFAULT_WAND_TYPE;
	this.motor_speed_regulation = DEFAULT_MOTOR_SPEED_REGULATION;
	this.cleaning_width = DEFAULT_CLEANING_WIDTH;
    }

    public VacuumCleaner(String filter_type, String bag_type, String wand_type, double motor_speed_regulation,
	    double cleaning_width) {
	super();
	this.filter_type = filter_type;
	this.bag_type = bag_type;
	this.wand_type = wand_type;
	this.motor_speed_regulation = motor_speed_regulation;
	this.cleaning_width = cleaning_width;
    }

    public VacuumCleaner(String filter_type, String bag_type, String wand_type, double motor_speed_regulation,
	    double cleaning_width, double power_consumption) {
	super(power_consumption);
	this.filter_type = filter_type;
	this.bag_type = bag_type;
	this.wand_type = wand_type;
	this.motor_speed_regulation = motor_speed_regulation;
	this.cleaning_width = cleaning_width;
    }

    public VacuumCleaner(VacuumCleaner vacCleaner) {
	super(vacCleaner.getPower_consumption());
	this.filter_type = vacCleaner.filter_type;
	this.bag_type = vacCleaner.bag_type;
	this.wand_type = vacCleaner.wand_type;
	this.motor_speed_regulation = vacCleaner.motor_speed_regulation;
	this.cleaning_width = vacCleaner.cleaning_width;
    }

    public String getFilter_type() {
	return filter_type;
    }

    public void setFilter_type(String filter_type) {
	this.filter_type = filter_type;
    }

    public String getBag_type() {
	return bag_type;
    }

    public void setBag_type(String bag_type) {
	this.bag_type = bag_type;
    }

    public String getWand_type() {
	return wand_type;
    }

    public void setWand_type(String wand_type) {
	this.wand_type = wand_type;
    }

    public double getMotor_speed_regulation() {
	return motor_speed_regulation;
    }

    public void setMotor_speed_regulation(double motor_speed_regulation) {
	this.motor_speed_regulation = motor_speed_regulation;
    }

    public double getCleaning_width() {
	return cleaning_width;
    }

    public void setCleaning_width(double cleaning_width) {
	this.cleaning_width = cleaning_width;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((bag_type == null) ? 0 : bag_type.hashCode());
	long temp;
	temp = Double.doubleToLongBits(cleaning_width);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((filter_type == null) ? 0 : filter_type.hashCode());
	temp = Double.doubleToLongBits(motor_speed_regulation);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((wand_type == null) ? 0 : wand_type.hashCode());
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
	VacuumCleaner other = (VacuumCleaner) obj;
	if (bag_type == null) {
	    if (other.bag_type != null)
		return false;
	} else if (!bag_type.equals(other.bag_type))
	    return false;
	if (Double.doubleToLongBits(cleaning_width) != Double.doubleToLongBits(other.cleaning_width))
	    return false;
	if (filter_type == null) {
	    if (other.filter_type != null)
		return false;
	} else if (!filter_type.equals(other.filter_type))
	    return false;
	if (Double.doubleToLongBits(motor_speed_regulation) != Double.doubleToLongBits(other.motor_speed_regulation))
	    return false;
	if (wand_type == null) {
	    if (other.wand_type != null)
		return false;
	} else if (!wand_type.equals(other.wand_type))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "VacuumCleaner [filter_type=" + filter_type + ", bag_type=" + bag_type + ", wand_type=" + wand_type
		+ ", motor_speed_regulation=" + motor_speed_regulation + ", cleaning_width=" + cleaning_width + "]";
    }

}
