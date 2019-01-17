package by.tc.task01.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Speakers extends Appliance {

    private static final double DEFAULT_NUMBER_OF_SPEKERS = 0;
    private static final double DEFAULT_FREQUENCY_RANGE = 0;
    private static final double DEFAULT_CORD_LENGTH = 0;

    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

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
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).appendSuper(super.hashCode()).append(cordLength)
		.append(frequencyRange).append(numberOfSpeakers).toHashCode();
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

	return new EqualsBuilder().append(this.cordLength, other.cordLength)
		.append(this.frequencyRange, other.frequencyRange).append(this.numberOfSpeakers, other.numberOfSpeakers)
		.isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("number_of_speakers", numberOfSpeakers)
		.append("frequency_range", frequencyRange).append("cord_length", cordLength).toString();
    }

}
