package by.tc.task01.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Computer implements Product {

    private static final double DEFAULT_BATTERY_CAPACITY = 0;
    private static final double DEFAULT_MEMORY_ROM = 0;
    
    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

    private double batteryCapacity;
    private double memoryRom;

    public Computer() {
	super();
	batteryCapacity = DEFAULT_BATTERY_CAPACITY;
	memoryRom = DEFAULT_MEMORY_ROM;
    }

    public Computer(final double batteryCapacity, final double memoryRom) {
	super();
	this.batteryCapacity = batteryCapacity;
	this.memoryRom = memoryRom;
    }

    public Computer(final Computer computer) {
	this.batteryCapacity = computer.batteryCapacity;
	this.memoryRom = computer.memoryRom;
    }

    public double getBatteryCapacity() {
	return batteryCapacity;
    }

    public void setBatteryCapacity(final double batteryCapacity) {
	this.batteryCapacity = batteryCapacity;
    }

    public double getMemoryRom() {
	return memoryRom;
    }

    public void setMemoryRom(final double memoryRom) {
	this.memoryRom = memoryRom;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).append(batteryCapacity).append(memoryRom)
		.toHashCode();
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
	
	Computer other = (Computer) obj;

	return new EqualsBuilder().append(this.batteryCapacity, other.batteryCapacity)
		.append(this.memoryRom, other.memoryRom).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("battery capacity", batteryCapacity).append("memory rom", memoryRom)
		.toString();
    }

}
