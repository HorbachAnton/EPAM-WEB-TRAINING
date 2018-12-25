package by.tc.task01.entity;

public class Speakers extends Appliance {

    private static final double DEFAULT_NUMBER_OF_SPEKERS = 0;
    private static final double DEFAULT_FREQUENCY_RANGE = 0;
    private static final double DEFAULT_CORD_LENGTH = 0;
    private double number_of_speakers;
    private double frequency_range;
    private double cord_length;

    public Speakers() {
	super();
	this.number_of_speakers = DEFAULT_NUMBER_OF_SPEKERS;
	this.frequency_range = DEFAULT_FREQUENCY_RANGE;
	this.cord_length = DEFAULT_CORD_LENGTH;
    }

    public Speakers(double number_of_speakers, double frequency_range, double cord_length) {
	super();
	this.number_of_speakers = number_of_speakers;
	this.frequency_range = frequency_range;
	this.cord_length = cord_length;
    }

    public Speakers(double number_of_speakers, double frequency_range, double cord_length, double power_consumption) {
	super(power_consumption);
	this.number_of_speakers = number_of_speakers;
	this.frequency_range = frequency_range;
	this.cord_length = cord_length;
    }

    public Speakers(Speakers speakers) {
	super(speakers.getPower_consumption());
	this.number_of_speakers = speakers.number_of_speakers;
	this.frequency_range = speakers.frequency_range;
	this.cord_length = speakers.cord_length;
    }

    public double getNumber_of_speakers() {
	return number_of_speakers;
    }

    public void setNumber_of_speakers(double number_of_speakers) {
	this.number_of_speakers = number_of_speakers;
    }

    public double getFrequency_range() {
	return frequency_range;
    }

    public void setFrequency_range(double frequency_range) {
	this.frequency_range = frequency_range;
    }

    public double getCord_length() {
	return cord_length;
    }

    public void setCord_length(double cord_length) {
	this.cord_length = cord_length;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(cord_length);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(frequency_range);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(number_of_speakers);
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
	Speakers other = (Speakers) obj;
	if (Double.doubleToLongBits(cord_length) != Double.doubleToLongBits(other.cord_length))
	    return false;
	if (Double.doubleToLongBits(frequency_range) != Double.doubleToLongBits(other.frequency_range))
	    return false;
	if (Double.doubleToLongBits(number_of_speakers) != Double.doubleToLongBits(other.number_of_speakers))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Speakers [number_of_speakers=" + number_of_speakers + ", frequency_range=" + frequency_range
		+ ", cord_length=" + cord_length + "]";
    }

}
