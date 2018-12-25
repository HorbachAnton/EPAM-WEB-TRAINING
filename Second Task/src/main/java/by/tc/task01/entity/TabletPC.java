package by.tc.task01.entity;

public class TabletPC extends Computer {

    private static final double DEFAULT_DISPLAY_INCHES = 0;
    private static final double DEFAULT_FLESH_MEMORY_CAPACITY = 0;
    private static final String DEFAULT_COLOR = "";
    private double display_inches;
    private double flesh_memory_capacity;
    private String color;

    public TabletPC() {
	super();
	this.display_inches = DEFAULT_DISPLAY_INCHES;
	this.flesh_memory_capacity = DEFAULT_FLESH_MEMORY_CAPACITY;
	this.color = DEFAULT_COLOR;
    }

    public TabletPC(double display_inches, double flesh_memory_capacity, String color) {
	super();
	this.display_inches = display_inches;
	this.flesh_memory_capacity = flesh_memory_capacity;
	this.color = color;
    }

    public TabletPC(double display_inches, double flesh_memory_capacity, String color, double battery_capacity,
	    double memory_rom) {
	super(battery_capacity, memory_rom);
	this.display_inches = display_inches;
	this.flesh_memory_capacity = flesh_memory_capacity;
	this.color = color;
    }

    public TabletPC(TabletPC tablet) {
	super(tablet.getBattery_capacity(), tablet.getMemory_rom());
	this.display_inches = tablet.display_inches;
	this.flesh_memory_capacity = tablet.flesh_memory_capacity;
	this.color = tablet.color;
    }

    public double getDisplay_inches() {
	return display_inches;
    }

    public void setDisplay_inches(double display_inches) {
	this.display_inches = display_inches;
    }

    public double getFlesh_memory_capacity() {
	return flesh_memory_capacity;
    }

    public void setFlesh_memory_capacity(double flesh_memory_capacity) {
	this.flesh_memory_capacity = flesh_memory_capacity;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	long temp;
	temp = Double.doubleToLongBits(display_inches);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(flesh_memory_capacity);
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
	TabletPC other = (TabletPC) obj;
	if (color == null) {
	    if (other.color != null)
		return false;
	} else if (!color.equals(other.color))
	    return false;
	if (Double.doubleToLongBits(display_inches) != Double.doubleToLongBits(other.display_inches))
	    return false;
	if (Double.doubleToLongBits(flesh_memory_capacity) != Double.doubleToLongBits(other.flesh_memory_capacity))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TabletPC [display_inches=" + display_inches + ", flesh_memory_capacity=" + flesh_memory_capacity
		+ ", color=" + color + "]";
    }

}
