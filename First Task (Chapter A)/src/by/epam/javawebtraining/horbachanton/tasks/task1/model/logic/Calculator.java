package by.epam.javawebtraining.horbachanton.tasks.task1.model.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.exception.NegativeCapException;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.exception.NegativeRadiusException;

public class Calculator {

    private static int POWER_BALL_VOLUME = 3;
    private static int MULTIPLIER_BALL_VOLUME = 4;
    private static int DIVISOR_BALL_VOLUME = 3;
    private static int MULTIPLIER_BALL_SURFACE_AREA = 4;
    private static int DIVISOR_VOLUME_RATIO = 3;
    private static int POWER_VOLUME_RATIO = 2;
    private static final Logger LOGGER = LogManager.getLogger();

    public static double calculateBallVolume(Ball ball) throws NegativeRadiusException {
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

    public static double calculateBallSurfaceArea(Ball ball) throws NegativeRadiusException {
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

    public static double calculateVolumeRatio(double heightCap, Ball ball)
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
	return ratio / calculateBallVolume(ball);
    }

}
