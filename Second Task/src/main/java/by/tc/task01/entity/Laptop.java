package by.tc.task01.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Laptop extends Computer {

    private static final String DEFAULT_OC = "";
    private static final double DEFAULT_SYSTEM_MEMORY = 0;
    private static final double DEFAULT_CPU = 0;
    private static final double DEFAULT_DISPLAY_INCHS = 0;
    
    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

    private String oc;
    private double systemMemory;
    private double cpu;
    private double displayInchs;

    public Laptop() {
	super();
	oc = DEFAULT_OC;
	systemMemory = DEFAULT_SYSTEM_MEMORY;
	cpu = DEFAULT_CPU;
	displayInchs = DEFAULT_DISPLAY_INCHS;
    }

    public Laptop(final String oc, final double systemMemory, final double cpu, final double displayInchs) {
	super();
	this.oc = oc;
	this.systemMemory = systemMemory;
	this.cpu = cpu;
	this.displayInchs = displayInchs;
    }

    public Laptop(final String oc, final double systemMemory, final double cpu, final double displayInchs,
	    final double batteryCapacity, final double memoryRom) {
	super(batteryCapacity, memoryRom);
	this.oc = oc;
	this.systemMemory = systemMemory;
	this.cpu = cpu;
	this.displayInchs = displayInchs;
    }

    public Laptop(final Laptop laptop) {
	super(laptop.getBatteryCapacity(), laptop.getMemoryRom());
	this.oc = laptop.oc;
	this.systemMemory = laptop.systemMemory;
	this.cpu = laptop.cpu;
	this.displayInchs = laptop.displayInchs;
    }

    public String getOc() {
	return oc;
    }

    public void setOc(final String oc) {
	this.oc = oc;
    }

    public double getSystemMemory() {
	return systemMemory;
    }

    public void setSystemMemory(final double systemMemory) {
	this.systemMemory = systemMemory;
    }

    public double getCpu() {
	return cpu;
    }

    public void setCpu(final double cpu) {
	this.cpu = cpu;
    }

    public double getDisplayInchs() {
	return displayInchs;
    }

    public void setDisplayInchs(final double displayInchs) {
	this.displayInchs = displayInchs;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).appendSuper(super.hashCode()).append(oc)
		.append(displayInchs).append(cpu).append(systemMemory).toHashCode();
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
	
	Laptop other = (Laptop) obj;

	return new EqualsBuilder().append(this.oc, other.oc).append(this.cpu, other.cpu)
		.append(this.displayInchs, other.displayInchs).append(this.systemMemory, other.systemMemory).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("OC", oc).append("CPU", cpu).append("display inches", displayInchs)
		.append("system memory", systemMemory).toString();
    }

}
