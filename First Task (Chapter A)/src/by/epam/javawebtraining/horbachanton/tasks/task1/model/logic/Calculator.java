package by.epam.javawebtraining.horbachanton.tasks.task1.model.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.javawebtraining.horbachanton.tasks.task1.dao.CalculatableBall;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.exception.NegativeCapException;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.exception.NegativeRadiusException;

public class Calculator implements CalculatableBall {

    public static final int POWER_BALL_VOLUME = 3;
    public static final int MULTIPLIER_BALL_VOLUME = 4;
    public static final int DIVISOR_BALL_VOLUME = 3;
    public static final int MULTIPLIER_BALL_SURFACE_AREA = 4;
    public static final int DIVISOR_VOLUME_RATIO = 3;
    public static final int POWER_VOLUME_RATIO = 2;
    public static final Logger LOGGER = LogManager.getLogger(Calculator.class);

    public double calculateVolume(Ball ball) throws NegativeRadiusException {
	double volume;
	double radius;
	if ((radius = ball.getRadius()) < 0) {
	    LOGGER.error("Negative radius.");
	    throw new NegativeRadiusException(
		    "You try to calculate ball volume with negative radius. Radius shoud not be negative.");
	} else {
	    volume = (MULTIPLIER_BALL_VOLUME * Math.PI * Math.pow(radius, POWER_BALL_VOLUME)) / DIVISOR_BALL_VOLUME;
	}
	return volume;
    }

    public double calculateSurfaceArea(Ball ball) throws NegativeRadiusException {
	double area;
	double radius;
	if ((radius = ball.getRadius()) < 0) {
	    LOGGER.error("Negative radius.");
	    throw new NegativeRadiusException(
		    "You try to calculate ball surface area with negative radius. Radius shoud not be negative.");
	} else {
	    area = MULTIPLIER_BALL_SURFACE_AREA * Math.PI * Math.pow(radius, 2);
	}
	return area;
    }

    public double calculateVolumeRatio(double heightCap, Ball ball)
	    throws NegativeCapException, NegativeRadiusException {
	double radius;
	double ratio;
	if (heightCap < 0) {
	    LOGGER.error("Negative cap height.");
	    throw new NegativeCapException(
		    "You try to calculate volume ratio with negative spherical cap. Spherical cap should not be negative.");
	} else if ((radius = ball.getRadius()) < 0) {
	    LOGGER.error("Negative radius.");
	    throw new NegativeRadiusException(
		    "You try to calculate volume ratio with negative radius. Radius shoud not be negative.");
	} else {
	    ratio = (Math.PI * Math.pow(heightCap, POWER_VOLUME_RATIO)) * (radius - (heightCap / DIVISOR_VOLUME_RATIO));
	}
	return ratio / calculateVolume(ball);
    }

}
