package by.tc.task01.entity;

public class Computer extends Product {

    private static final double DEFAULT_BATTERY_CAPACITY = 0;
    private static final double DEFAULT_MEMORY_ROM = 0;
    private double batteryCapacity;
    private double memoryRom;

    public Computer() {
	super();
	batteryCapacity = DEFAULT_BATTERY_CAPACITY;
	memoryRom = DEFAULT_MEMORY_ROM;
    }

    public Computer(double batteryCapacity, double memoryRom) {
	super();
	this.batteryCapacity = batteryCapacity;
	this.memoryRom = memoryRom;
    }

    public Computer(Computer computer) {
	this.batteryCapacity = computer.batteryCapacity;
	this.memoryRom = computer.memoryRom;
    }

    public double getBatteryCapacity() {
	return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
	this.batteryCapacity = batteryCapacity;
    }

    public double getMemoryRom() {
	return memoryRom;
    }

    public void setMemoryRom(double memoryRom) {
	this.memoryRom = memoryRom;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(batteryCapacity);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(memoryRom);
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
	Computer other = (Computer) obj;
	if (Double.doubleToLongBits(batteryCapacity) != Double.doubleToLongBits(other.batteryCapacity)) {
	    return false;
	}
	if (Double.doubleToLongBits(memoryRom) != Double.doubleToLongBits(other.memoryRom)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Computer [battery_capacity=" + batteryCapacity + ", memory_rom=" + memoryRom + "]";
    }

}
