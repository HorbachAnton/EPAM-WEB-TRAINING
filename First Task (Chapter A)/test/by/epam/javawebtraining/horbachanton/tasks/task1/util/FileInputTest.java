package by.epam.javawebtraining.horbachanton.tasks.task1.util;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.ThreeDimensionalPoint;

public class FileInputTest {

    private FileInput input;
    private Ball ball;

    @BeforeTest
    public void createFileInput() {
	input = new FileInput();
	ball = new Ball(new ThreeDimensionalPoint(1, 1, 1), 1);
    }

    @Test
    public void testDefaultFileInput() throws IOException {
	Ball[] balls = input.getBalls();
	assertEquals(balls[0], ball);

    }
}
