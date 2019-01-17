package by.tc.task01.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TabletPC extends Computer {

    private static final double DEFAULT_DISPLAY_INCHES = 0;
    private static final double DEFAULT_FLESH_MEMORY_CAPACITY = 0;
    private static final String DEFAULT_COLOR = "";

    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

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
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).appendSuper(super.hashCode())
		.append(displayInches).append(color).append(fleshMemoryCapacity).toHashCode();
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

	return new EqualsBuilder().append(this.displayInches, other.displayInches)
		.append(this.fleshMemoryCapacity, other.fleshMemoryCapacity).append(this.color, other.color).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("display_inches", displayInches)
		.append("flesh_memory_capacity", fleshMemoryCapacity).append("color", color).toString();
    }

}
