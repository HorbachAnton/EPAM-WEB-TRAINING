package by.tc.task01.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class VacuumCleaner extends Appliance {

    private static final String DEFAULT_FILTER_TYPE = "";
    private static final String DEFAULT_BAG_TYPE = "";
    private static final String DEFAULT_WAND_TYPE = "";
    private static final double DEFAULT_MOTOR_SPEED_REGULATION = 0;
    private static final double DEFAULT_CLEANING_WIDTH = 0;

    private static final int VALUE_FOR_HASH_1 = 1;
    private static final int VALUE_FOR_HASH_2 = 31;

    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleaner() {
	super();
	this.filterType = DEFAULT_FILTER_TYPE;
	this.bagType = DEFAULT_BAG_TYPE;
	this.wandType = DEFAULT_WAND_TYPE;
	this.motorSpeedRegulation = DEFAULT_MOTOR_SPEED_REGULATION;
	this.cleaningWidth = DEFAULT_CLEANING_WIDTH;
    }

    public VacuumCleaner(final String filterType, final String bagType, final String wandType,
	    final double motorSpeedRegulation, final double cleaningWidth) {
	super();
	this.filterType = filterType;
	this.bagType = bagType;
	this.wandType = wandType;
	this.motorSpeedRegulation = motorSpeedRegulation;
	this.cleaningWidth = cleaningWidth;
    }

    public VacuumCleaner(final String filterType, final String bagType, final String wandType,
	    final double motorSpeedRegulation, final double cleaningWidth, final double powerConsumption) {
	super(powerConsumption);
	this.filterType = filterType;
	this.bagType = bagType;
	this.wandType = wandType;
	this.motorSpeedRegulation = motorSpeedRegulation;
	this.cleaningWidth = cleaningWidth;
    }

    public VacuumCleaner(final VacuumCleaner vacCleaner) {
	super(vacCleaner.getPowerConsumption());
	this.filterType = vacCleaner.filterType;
	this.bagType = vacCleaner.bagType;
	this.wandType = vacCleaner.wandType;
	this.motorSpeedRegulation = vacCleaner.motorSpeedRegulation;
	this.cleaningWidth = vacCleaner.cleaningWidth;
    }

    public String getFilterType() {
	return filterType;
    }

    public void setFilterTtype(final String filterType) {
	this.filterType = filterType;
    }

    public String getBagType() {
	return bagType;
    }

    public void setBagType(final String bagType) {
	this.bagType = bagType;
    }

    public String getWandType() {
	return wandType;
    }

    public void setWandType(final String wandType) {
	this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
	return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(final double motorSpeedRegulation) {
	this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
	return cleaningWidth;
    }

    public void setCleaningWidth(final double cleaningWidth) {
	this.cleaningWidth = cleaningWidth;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).appendSuper(super.hashCode()).append(filterType)
		.append(bagType).append(wandType).append(motorSpeedRegulation).append(cleaningWidth).toHashCode();
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

	VacuumCleaner other = (VacuumCleaner) obj;

	return new EqualsBuilder().append(this.filterType, other.filterType).append(this.bagType, other.bagType)
		.append(this.wandType, other.wandType).append(this.motorSpeedRegulation, other.motorSpeedRegulation)
		.append(this.cleaningWidth, other.cleaningWidth).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("filter_type", filterType).append("bag_type", bagType)
		.append("wand_type", wandType).append("motor_speed_regulation", motorSpeedRegulation)
		.append("cleaning_width", cleaningWidth).toString();
    }

}
