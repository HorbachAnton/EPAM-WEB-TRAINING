package by.tc.task01.entity;

public class Computer extends Product {

    private static final double DEFAULT_BATTERY_CAPACITY = 0;
    private static final double DEFAULT_MEMORY_ROM = 0;
    private double battery_capacity;
    private double memory_rom;

    public Computer() {
	super();
	battery_capacity = DEFAULT_BATTERY_CAPACITY;
	memory_rom = DEFAULT_MEMORY_ROM;
    }

    public Computer(double battery_capacity, double memory_rom) {
	super();
	this.battery_capacity = battery_capacity;
	this.memory_rom = memory_rom;
    }

    public Computer(Computer computer) {
	this.battery_capacity = computer.battery_capacity;
	this.memory_rom = computer.memory_rom;
    }

    public double getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(double battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public double getMemory_rom() {
        return memory_rom;
    }

    public void setMemory_rom(double memory_rom) {
        this.memory_rom = memory_rom;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(battery_capacity);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(memory_rom);
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
	Computer other = (Computer) obj;
	if (Double.doubleToLongBits(battery_capacity) != Double.doubleToLongBits(other.battery_capacity))
	    return false;
	if (Double.doubleToLongBits(memory_rom) != Double.doubleToLongBits(other.memory_rom))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Computer [battery_capacity=" + battery_capacity + ", memory_rom=" + memory_rom + "]";
    }

}
