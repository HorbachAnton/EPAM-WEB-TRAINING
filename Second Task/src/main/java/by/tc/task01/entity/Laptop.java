package by.tc.task01.entity;

public class Laptop extends Computer {

    private static final String DEFAULT_OC = "";
    private static final double DEFAULT_SYSTEM_MEMORY = 0;
    private static final double DEFAULT_CPU = 0;
    private static final double DEFAULT_DISPLAY_INCHS = 0;
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

    public Laptop(String oc, double systemMemory, double cpu, double displayInchs) {
	super();
	this.oc = oc;
	this.systemMemory = systemMemory;
	this.cpu = cpu;
	this.displayInchs = displayInchs;
    }

    public Laptop(String oc, double systemMemory, double cpu, double displayInchs, double batteryCapacity,
	    double memoryRom) {
	super(batteryCapacity, memoryRom);
	this.oc = oc;
	this.systemMemory = systemMemory;
	this.cpu = cpu;
	this.displayInchs = displayInchs;
    }

    public Laptop(Laptop laptop) {
	super(laptop.getBatteryCapacity(), laptop.getMemoryRom());
	this.oc = laptop.oc;
	this.systemMemory = laptop.systemMemory;
	this.cpu = laptop.cpu;
	this.displayInchs = laptop.displayInchs;
    }

    public String getOc() {
	return oc;
    }

    public void setOc(String oc) {
	this.oc = oc;
    }

    public double getSystemMemory() {
	return systemMemory;
    }

    public void setSystemMemory(double systemMemory) {
	this.systemMemory = systemMemory;
    }

    public double getCpu() {
	return cpu;
    }

    public void setCpu(double cpu) {
	this.cpu = cpu;
    }

    public double getDisplayInchs() {
	return displayInchs;
    }

    public void setDisplayInchs(double displayInchs) {
	this.displayInchs = displayInchs;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(cpu);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(displayInchs);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((oc == null) ? 0 : oc.hashCode());
	temp = Double.doubleToLongBits(systemMemory);
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
	Laptop other = (Laptop) obj;
	if (Double.doubleToLongBits(cpu) != Double.doubleToLongBits(other.cpu)) {
	    return false;
	}
	if (Double.doubleToLongBits(displayInchs) != Double.doubleToLongBits(other.displayInchs)) {
	    return false;
	}
	if (oc == null) {
	    if (other.oc != null) {
		return false;
	    }
	} else if (!oc.equals(other.oc)) {
	    return false;
	}
	if (Double.doubleToLongBits(systemMemory) != Double.doubleToLongBits(other.systemMemory)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Laptop [oc=" + oc + ", system_memory=" + systemMemory + ", cpu=" + cpu + ", display_inchs="
		+ displayInchs + "]";
    }

}
