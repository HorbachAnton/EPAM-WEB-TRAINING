package by.tc.task01.entity;

public class Laptop extends Computer {

    private static final String DEFAULT_OC = "";
    private static final double DEFAULT_SYSTEM_MEMORY = 0;
    private static final double DEFAULT_CPU = 0;
    private static final double DEFAULT_DISPLAY_INCHS = 0;
    private String oc;
    private double system_memory;
    private double cpu;
    private double display_inchs;

    public Laptop() {
	super();
	oc = DEFAULT_OC;
	system_memory = DEFAULT_SYSTEM_MEMORY;
	cpu = DEFAULT_CPU;
	display_inchs = DEFAULT_DISPLAY_INCHS;
    }

    public Laptop(String oc, double system_memory, double cpu, double display_inchs) {
	super();
	this.oc = oc;
	this.system_memory = system_memory;
	this.cpu = cpu;
	this.display_inchs = display_inchs;
    }

    public Laptop(String oc, double system_memory, double cpu, double display_inchs, double battery_capacity,
	    double memory_rom) {
	super(battery_capacity, memory_rom);
	this.oc = oc;
	this.system_memory = system_memory;
	this.cpu = cpu;
	this.display_inchs = display_inchs;
    }

    public Laptop(Laptop laptop) {
	super(laptop.getBattery_capacity(), laptop.getMemory_rom());
	this.oc = laptop.oc;
	this.system_memory = laptop.system_memory;
	this.cpu = laptop.cpu;
	this.display_inchs = laptop.display_inchs;
    }

    public String getOc() {
	return oc;
    }

    public void setOc(String oc) {
	this.oc = oc;
    }

    public double getSystem_memory() {
	return system_memory;
    }

    public void setSystem_memory(double system_memory) {
	this.system_memory = system_memory;
    }

    public double getCpu() {
	return cpu;
    }

    public void setCpu(double cpu) {
	this.cpu = cpu;
    }

    public double getDisplay_inchs() {
	return display_inchs;
    }

    public void setDisplay_inchs(double display_inchs) {
	this.display_inchs = display_inchs;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(cpu);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(display_inchs);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((oc == null) ? 0 : oc.hashCode());
	temp = Double.doubleToLongBits(system_memory);
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
	Laptop other = (Laptop) obj;
	if (Double.doubleToLongBits(cpu) != Double.doubleToLongBits(other.cpu))
	    return false;
	if (Double.doubleToLongBits(display_inchs) != Double.doubleToLongBits(other.display_inchs))
	    return false;
	if (oc == null) {
	    if (other.oc != null)
		return false;
	} else if (!oc.equals(other.oc))
	    return false;
	if (Double.doubleToLongBits(system_memory) != Double.doubleToLongBits(other.system_memory))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Laptop [oc=" + oc + ", system_memory=" + system_memory + ", cpu=" + cpu + ", display_inchs="
		+ display_inchs + "]";
    }

}
