package by.epam.javawebtraining.horbachanton.tasks.task1.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ThreeDimensionalPoint {

    private static final int VALUE_FOR_HASH_1 = 17;
    private static final int VALUE_FOR_HASH_2 = 29;
    private static final double DEFAULT_X_COORDINATE = 0;
    private static final double DEFAULT_Y_COORDINATE = 0;
    private static final double DEFAULT_Z_COORDINATE = 0;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public ThreeDimensionalPoint() {
	xCoordinate = DEFAULT_X_COORDINATE;
	yCoordinate = DEFAULT_Y_COORDINATE;
	zCoordinate = DEFAULT_Z_COORDINATE;
    }

    public ThreeDimensionalPoint(double xCoordinate, double yCoordinate, double zCoordinate) {
	this.xCoordinate = xCoordinate;
	this.yCoordinate = yCoordinate;
	this.zCoordinate = zCoordinate;
    }

    public ThreeDimensionalPoint(ThreeDimensionalPoint point) {
	this.xCoordinate = point.xCoordinate;
	this.yCoordinate = point.yCoordinate;
	this.zCoordinate = point.zCoordinate;
    }

    public double getxCoordinate() {
	return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
	this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
	return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
	this.yCoordinate = yCoordinate;
    }

    public double getzCoordinate() {
	return zCoordinate;
    }

    public void setzCoordinate(double zCoordinate) {
	this.zCoordinate = zCoordinate;
    }

    @Override
    public boolean equals(Object object) {

	if (this == object) {
	    return true;
	}

	if (object == null || !(object instanceof ThreeDimensionalPoint)) {
	    return false;
	}

	ThreeDimensionalPoint point = (ThreeDimensionalPoint) object;

	return new EqualsBuilder().append(this.xCoordinate, point.xCoordinate)
		.append(this.yCoordinate, point.yCoordinate).append(this.zCoordinate, point.zCoordinate).isEquals();

    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).append(xCoordinate).append(yCoordinate)
		.append(zCoordinate).toHashCode();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("xCoordinate", this.xCoordinate).append("yCoordinate", this.yCoordinate)
		.append("zCoordinate", this.zCoordinate).toString();
    }
}
