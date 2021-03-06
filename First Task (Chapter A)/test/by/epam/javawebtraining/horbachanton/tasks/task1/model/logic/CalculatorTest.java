package by.epam.javawebtraining.horbachanton.tasks.task1.model.logic;

import org.testng.annotations.Test;

import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.ThreeDimensionalPoint;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.exception.NegativeCapException;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.exception.NegativeRadiusException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class CalculatorTest extends Assert {
    
    private static Calculator calculator = new Calculator();

    @DataProvider(name = "calculateVolumeData")
    public static Object[][] calculateVolumeData() {
	return new Object[][] { { new Ball(new ThreeDimensionalPoint(4, 4, 4), 5), 524 },
		{ new Ball(new ThreeDimensionalPoint(4, 4, 4), 6.8), 1317 } };
    }

    @DataProvider(name = "calculateVolumeExceptionData")
    public static Object[] calculateVolumeExceptionData() {
	return new Object[][] { { new Ball(new ThreeDimensionalPoint(4, 4, 4), -5), 524 },
		{ new Ball(new ThreeDimensionalPoint(4, 4, 4), -6.8), 1317 } };
    }

    @DataProvider(name = "calculateSurfaceAreaData")
    public static Object[][] calculateBallSurfaceAreaData() {
	return new Object[][] { { new Ball(new ThreeDimensionalPoint(4, 4, 4), 5), 314 },
		{ new Ball(new ThreeDimensionalPoint(4, 4, 4), 6.8), 581 } };
    }

    @DataProvider(name = "calculateSurfaceAreaExceptionData")
    public static Object[][] calculateSurfaceAreaExceptionData() {
	return new Object[][] { { new Ball(new ThreeDimensionalPoint(4, 4, 4), -5), 314 },
		{ new Ball(new ThreeDimensionalPoint(4, 4, 4), -6.8), 581 } };
    }

    @DataProvider(name = "calculateVolumeRatioData")
    public static Object[][] calculateVolumeRatioData() {
	return new Object[][] { { new Ball(new ThreeDimensionalPoint(4, 4, 4), 24), 17, 0.287452980324074 },
		{ new Ball(new ThreeDimensionalPoint(4, 4, 4), 24), 12, 0.15625 } };
    }

    @DataProvider(name = "calculateExceptionVolumeRatioData")
    public static Object[][] calculateExceptionVolumeRatioData() {
	return new Object[][] { { new Ball(new ThreeDimensionalPoint(4, 4, 4), 24), -17, 0.287452980324074 },
		{ new Ball(new ThreeDimensionalPoint(4, 4, 4), 24), -12, 0.15625 } };
    }

    @Test(dataProvider = "calculateVolumeData")
    public void testcalculateVolume(Ball ball, double expected) throws NegativeRadiusException {
	double actual = Math.round(calculator.calculateVolume(ball));
	assertEquals(actual, expected);
    }

    @Test(dataProvider = "calculateVolumeExceptionData", expectedExceptions = NegativeRadiusException.class)
    public void testExceptioncalculateVolume(Ball ball, double expected) throws NegativeRadiusException {
	calculator.calculateVolume(ball);
    }

    @Test(dataProvider = "calculateSurfaceAreaData")
    public void testCalculateBallSurfaceArea(Ball ball, double expected) throws NegativeRadiusException {
	double actual = Math.round(calculator.calculateSurfaceArea(ball));
	assertEquals(actual, expected);
    }

    @Test(dataProvider = "calculateSurfaceAreaExceptionData", expectedExceptions = NegativeRadiusException.class)
    public void testExceptionCalculateBallSurfaceArea(Ball ball, double expected) throws NegativeRadiusException {
	calculator.calculateSurfaceArea(ball);
    }

    @Test(dataProvider = "calculateVolumeRatioData")
    public void testCalculateVolumeRatio(Ball ball, double heightCap, double expected)
	    throws NegativeRadiusException, NegativeCapException {
	double actual = calculator.calculateVolumeRatio(heightCap, ball);
	assertEquals(actual, expected);
    }

    @Test(dataProvider = "calculateExceptionVolumeRatioData", expectedExceptions = NegativeCapException.class)
    public void testExceptionCalculateVolumeRatio(Ball ball, double heightCap, double expected)
	    throws NegativeRadiusException, NegativeCapException {
	calculator.calculateVolumeRatio(heightCap, ball);
    }

}
