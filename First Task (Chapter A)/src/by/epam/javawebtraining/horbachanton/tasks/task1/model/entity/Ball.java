package by.epam.javawebtraining.horbachanton.tasks.task1.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Ball {

    private static final int VALUE_FOR_HASH_1 = 15;
    private static final int VALUE_FOR_HASH_2 = 27;
    private ThreeDimensionalPoint center;
    private double radius;

    public Ball() {
	center = new ThreeDimensionalPoint(0, 0, 0);
	radius = 0;
    }

    public Ball(ThreeDimensionalPoint center, double radius) {
	this.center = center;
	this.radius = radius;
    }

    public Ball(Ball ball) {
	this.center = ball.center;
	this.radius = ball.radius;
    }

    public ThreeDimensionalPoint getCenter() {
	return center;
    }

    public void setCenter(ThreeDimensionalPoint center) {
	this.center = center;
    }

    public double getRadius() {
	return radius;
    }

    public void setRadius(double radius) {
	this.radius = radius;
    }

    @Override
    public boolean equals(Object object) {

	if (this == object) {
	    return true;
	}

	if (object == null || !(object instanceof Ball)) {
	    return false;
	}

	Ball ball = (Ball) object;

	return new EqualsBuilder().append(this.center, ball.center).append(this.radius, ball.radius).isEquals();
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).append(center).append(radius).toHashCode();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("center", this.center).append("radius", radius).toString();
    }

}
