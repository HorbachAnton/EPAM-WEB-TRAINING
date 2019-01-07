package by.tc.task01.entity;

public class VacuumCleaner extends Appliance {

    private static final String DEFAULT_FILTER_TYPE = "";
    private static final String DEFAULT_BAG_TYPE = "";
    private static final String DEFAULT_WAND_TYPE = "";
    private static final double DEFAULT_MOTOR_SPEED_REGULATION = 0;
    private static final double DEFAULT_CLEANING_WIDTH = 0;
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

    public VacuumCleaner(String filterType, String bagType, String wandType, double motorSpeedRegulation,
	    double cleaningWidth) {
	super();
	this.filterType = filterType;
	this.bagType = bagType;
	this.wandType = wandType;
	this.motorSpeedRegulation = motorSpeedRegulation;
	this.cleaningWidth = cleaningWidth;
    }

    public VacuumCleaner(String filterType, String bagType, String wandType, double motorSpeedRegulation,
	    double cleaningWidth, double powerConsumption) {
	super(powerConsumption);
	this.filterType = filterType;
	this.bagType = bagType;
	this.wandType = wandType;
	this.motorSpeedRegulation = motorSpeedRegulation;
	this.cleaningWidth = cleaningWidth;
    }

    public VacuumCleaner(VacuumCleaner vacCleaner) {
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

    public void setFilterTtype(String filterType) {
	this.filterType = filterType;
    }

    public String getBagType() {
	return bagType;
    }

    public void setBagType(String bagType) {
	this.bagType = bagType;
    }

    public String getWandType() {
	return wandType;
    }

    public void setWandType(String wandType) {
	this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
	return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
	this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
	return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
	this.cleaningWidth = cleaningWidth;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((bagType == null) ? 0 : bagType.hashCode());
	long temp;
	temp = Double.doubleToLongBits(cleaningWidth);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((filterType == null) ? 0 : filterType.hashCode());
	temp = Double.doubleToLongBits(motorSpeedRegulation);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((wandType == null) ? 0 : wandType.hashCode());
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
	VacuumCleaner other = (VacuumCleaner) obj;
	if (bagType == null) {
	    if (other.bagType != null) {
		return false;
	    }
	} else if (!bagType.equals(other.bagType)) {
	    return false;
	}
	if (Double.doubleToLongBits(cleaningWidth) != Double.doubleToLongBits(other.cleaningWidth)) {
	    return false;
	}
	if (filterType == null) {
	    if (other.filterType != null) {
		return false;
	    }
	} else if (!filterType.equals(other.filterType)) {
	    return false;
	}
	if (Double.doubleToLongBits(motorSpeedRegulation) != Double.doubleToLongBits(other.motorSpeedRegulation)) {
	    return false;
	}
	if (wandType == null) {
	    if (other.wandType != null) {
		return false;
	    }
	} else if (!wandType.equals(other.wandType)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "VacuumCleaner [filter_type=" + filterType + ", bag_type=" + bagType + ", wand_type=" + wandType
		+ ", motor_speed_regulation=" + motorSpeedRegulation + ", cleaning_width=" + cleaningWidth + "]";
    }

}
