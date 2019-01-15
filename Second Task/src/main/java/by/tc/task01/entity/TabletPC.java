package by.tc.task01.entity;

public class TabletPC extends Computer {

    private static final double DEFAULT_DISPLAY_INCHES = 0;
    private static final double DEFAULT_FLESH_MEMORY_CAPACITY = 0;
    private static final String DEFAULT_COLOR = "";
    private double displayInches;
    private double fleshMemoryCapacity;
    private String color;

    public TabletPC() {
	super();
	this.displayInches = DEFAULT_DISPLAY_INCHES;
	this.fleshMemoryCapacity = DEFAULT_FLESH_MEMORY_CAPACITY;
	this.color = DEFAULT_COLOR;
    }

    public TabletPC(final double displayInches, final double fleshMemoryCapacity, final String color) {
	super();
	this.displayInches = displayInches;
	this.fleshMemoryCapacity = fleshMemoryCapacity;
	this.color = color;
    }

    public TabletPC(final double displayInches, final double fleshMemoryCapacity, final String color,
	    final double batteryCapacity, final double memoryRom) {
	super(batteryCapacity, memoryRom);
	this.displayInches = displayInches;
	this.fleshMemoryCapacity = fleshMemoryCapacity;
	this.color = color;
    }

    public TabletPC(final TabletPC tablet) {
	super(tablet.getBatteryCapacity(), tablet.getMemoryRom());
	this.displayInches = tablet.displayInches;
	this.fleshMemoryCapacity = tablet.fleshMemoryCapacity;
	this.color = tablet.color;
    }

    public double getDisplayInches() {
	return displayInches;
    }

    public void setDisplayInches(final double displayInches) {
	this.displayInches = displayInches;
    }

    public double getFleshMemoryCapacity() {
	return fleshMemoryCapacity;
    }

    public void setFleshMemoryCapacity(final double fleshMemoryCapacity) {
	this.fleshMemoryCapacity = fleshMemoryCapacity;
    }

    public String getColor() {
	return color;
    }

    public void setColor(final String color) {
	this.color = color;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	long temp;
	temp = Double.doubleToLongBits(displayInches);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(fleshMemoryCapacity);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
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
	TabletPC other = (TabletPC) obj;
	if (color == null) {
	    if (other.color != null) {
		return false;
	    }
	} else if (!color.equals(other.color)) {
	    return false;
	}
	if (Double.doubleToLongBits(displayInches) != Double.doubleToLongBits(other.displayInches)) {
	    return false;
	}
	if (Double.doubleToLongBits(fleshMemoryCapacity) != Double.doubleToLongBits(other.fleshMemoryCapacity)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "TabletPC [display_inches=" + displayInches + ", flesh_memory_capacity=" + fleshMemoryCapacity
		+ ", color=" + color + "]";
    }

}
