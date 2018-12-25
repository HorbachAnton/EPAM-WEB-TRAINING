package by.tc.task01.entity;

public class Appliance extends Product {

    private static final double DEFAULT_POWER_CONSUMPTION = 0;
    private double power_consumption;

    public Appliance() {
	power_consumption = DEFAULT_POWER_CONSUMPTION;
    }

    public Appliance(double power_consumption) {
	this.power_consumption = power_consumption;
    }

    public Appliance(Appliance appliance) {
	this.power_consumption = appliance.power_consumption;
    }
    
    public double getPower_consumption() {
	return power_consumption;
    }

    public void setPower_consumption(double power_consumption) {
	this.power_consumption = power_consumption;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(power_consumption);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Appliance other = (Appliance) obj;
	if (Double.doubleToLongBits(power_consumption) != Double.doubleToLongBits(other.power_consumption))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	return "Appliance [power_consumption=" + power_consumption + "]";
    }

}
