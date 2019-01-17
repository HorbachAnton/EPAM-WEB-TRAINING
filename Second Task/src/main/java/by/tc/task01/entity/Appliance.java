package by.tc.task01.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Appliance implements Product {

    private static final double DEFAULT_POWER_CONSUMPTION = 0;
    
    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

    private double powerConsumption;

    public Appliance() {
	powerConsumption = DEFAULT_POWER_CONSUMPTION;
    }

    public Appliance(final double powerConsumption) {
	this.powerConsumption = powerConsumption;
    }

    public Appliance(final Appliance appliance) {
	this.powerConsumption = appliance.powerConsumption;
    }

    public double getPowerConsumption() {
	return powerConsumption;
    }

    public void setPowerConsumption(final double powerConsumption) {
	this.powerConsumption = powerConsumption;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).append(powerConsumption).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
	
	if (this == obj) {
	    return true;
	}
	
	if (obj == null) {
	    return false;
	}
	
	if (getClass() != obj.getClass()) {
	    return false;
	}
	
	Appliance other = (Appliance) obj;

	return new EqualsBuilder().append(this.powerConsumption, other.powerConsumption).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("power consumption", powerConsumption).toString();
    }

}
