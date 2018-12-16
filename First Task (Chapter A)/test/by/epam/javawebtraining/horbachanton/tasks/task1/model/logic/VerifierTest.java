package by.epam.javawebtraining.horbachanton.tasks.task1.model.logic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.ThreeDimensionalPoint;

public class VerifierTest extends Assert {
    
    private static Verifier verifier = new Verifier();

    @DataProvider(name = "IsBallData")
    public static Object[][] IsBallData() {
	return new Object[][] { { new Ball(new ThreeDimensionalPoint(4, 4, 4), 5), true },
		{ new ThreeDimensionalPoint(), false } };
    }

    @DataProvider(name = "isBallTouchPlaneData")
    public static Object[][] isBallTouchPlaneData() {
	return new Object[][] { { new Ball(new ThreeDimensionalPoint(8, 8, 8), 5), false },
		{ new Ball(new ThreeDimensionalPoint(7, 4, 8), 4), true } };
    }

    @Test(dataProvider = "IsBallData")
    public void testIsBall(Object object, boolean expected) {
	boolean actual = verifier.isBall(object);
	assertEquals(actual, expected);
    }

    @Test(dataProvider = "isBallTouchPlaneData")
    public void testisBallTouchPlane(Ball ball, boolean expected) {
	boolean actual = verifier.isBallTouchPlane(ball);
	assertEquals(actual, expected);
    }

}
