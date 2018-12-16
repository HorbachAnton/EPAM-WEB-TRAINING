package by.epam.javawebtraining.horbachanton.tasks.task1.model.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.javawebtraining.horbachanton.tasks.task1.dao.VerifiableBall;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.ThreeDimensionalPoint;

public class Verifier implements VerifiableBall{

    public static final Logger LOGGER = LogManager.getLogger(Verifier.class);

    public boolean isBall(Object object) {
	boolean isBall = true;
	if (object == null) {
	    LOGGER.info("Object is null.");
	    isBall = false;
	} else if (object.getClass() != Ball.class) {
	    isBall = false;
	}
	return isBall;
    }

    public boolean isBallTouchPlane(Ball ball) {
	boolean isTouch;
	ThreeDimensionalPoint center;
	if (ball == null) {
	    LOGGER.info("Ball is null.");
	    isTouch = false;
	} else {
	    double radius = ball.getRadius();
	    if ((center = ball.getCenter()) == null) {
		isTouch = false;
	    } else {
		double x = center.getxCoordinate();
		double y = center.getyCoordinate();
		double z = center.getzCoordinate();
		if (x - radius == 0 || y - radius == 0 || z - radius == 0) {
		    isTouch = true;
		} else {
		    isTouch = false;
		}
	    }
	}
	return isTouch;
    }
}
