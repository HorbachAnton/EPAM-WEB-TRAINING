package by.tc.task01.entity;

public class Appliance extends Product {

    private static final double DEFAULT_POWER_CONSUMPTION = 0;
    private double powerConsumption;

    public Appliance() {
	powerConsumption = DEFAULT_POWER_CONSUMPTION;
    }

    public Appliance(double powerConsumption) {
	this.powerConsumption = powerConsumption;
    }

    public Appliance(Appliance appliance) {
	this.powerConsumption = appliance.powerConsumption;
    }

    public double getPowerConsumption() {
	return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
	this.powerConsumption = powerConsumption;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(powerConsumption);
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
	Appliance other = (Appliance) obj;
	if (Double.doubleToLongBits(powerConsumption) != Double.doubleToLongBits(other.powerConsumption)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Appliance [powerConsumption=" + powerConsumption + "]";
    }

}
