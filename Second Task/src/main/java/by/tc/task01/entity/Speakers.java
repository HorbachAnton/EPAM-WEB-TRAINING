package by.tc.task01.entity;

public class Speakers extends Appliance {

    private static final double DEFAULT_NUMBER_OF_SPEKERS = 0;
    private static final double DEFAULT_FREQUENCY_RANGE = 0;
    private static final double DEFAULT_CORD_LENGTH = 0;
    private double numberOfSpeakers;
    private double frequencyRange;
    private double cordLength;

    public Speakers() {
	super();
	this.numberOfSpeakers = DEFAULT_NUMBER_OF_SPEKERS;
	this.frequencyRange = DEFAULT_FREQUENCY_RANGE;
	this.cordLength = DEFAULT_CORD_LENGTH;
    }

    public Speakers(final double numberOfSpeakers, final double frequencyRange, final double cordLength) {
	super();
	this.numberOfSpeakers = numberOfSpeakers;
	this.frequencyRange = frequencyRange;
	this.cordLength = cordLength;
    }

    public Speakers(final double numberOfSpeakers, final double frequencyRange, final double cordLength,
	    final double powerConsumption) {
	super(powerConsumption);
	this.numberOfSpeakers = numberOfSpeakers;
	this.frequencyRange = frequencyRange;
	this.cordLength = cordLength;
    }

    public Speakers(final Speakers speakers) {
	super(speakers.getPowerConsumption());
	this.numberOfSpeakers = speakers.numberOfSpeakers;
	this.frequencyRange = speakers.frequencyRange;
	this.cordLength = speakers.cordLength;
    }

    public double getNumberOfSpeakers() {
	return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(final double numberOfSpeakers) {
	this.numberOfSpeakers = numberOfSpeakers;
    }

    public double getFrequencyRange() {
	return frequencyRange;
    }

    public void setFrequencyRange(final double frequencyRange) {
	this.frequencyRange = frequencyRange;
    }

    public double getCordLength() {
	return cordLength;
    }

    public void setCordLength(final double cordLength) {
	this.cordLength = cordLength;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(cordLength);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(frequencyRange);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(numberOfSpeakers);
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
	Speakers other = (Speakers) obj;
	if (Double.doubleToLongBits(cordLength) != Double.doubleToLongBits(other.cordLength)) {
	    return false;
	}
	if (Double.doubleToLongBits(frequencyRange) != Double.doubleToLongBits(other.frequencyRange)) {
	    return false;
	}
	if (Double.doubleToLongBits(numberOfSpeakers) != Double.doubleToLongBits(other.numberOfSpeakers)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Speakers [number_of_speakers=" + numberOfSpeakers + ", frequency_range=" + frequencyRange
		+ ", cord_length=" + cordLength + "]";
    }

}
