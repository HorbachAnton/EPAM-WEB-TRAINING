package by.epam.javawebtraining.horbachanton.tasks.task1.util;

import java.io.IOException;
import java.nio.file.Path;

import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.ThreeDimensionalPoint;

public class FileInput {

    private static int AMOUNT_BALL_PARAMETERS = 4;
    private ReaderFile reader;
    private Validator validator;
    private Parser parser;

    public FileInput() {
	reader = new ReaderFile();
	validator = new Validator();
	parser = new Parser();
    }

    public FileInput(Path path) {
	reader = new ReaderFile(path);
	validator = new Validator();
	parser = new Parser();
    }

    public FileInput(ReaderFile reader, Validator validator, Parser parser) throws IOException {
	this.reader = reader;
	this.validator = validator;
	this.parser = parser;
    }

    public Ball[] getBalls() throws IOException {
	double[][] dates;
	Ball[] balls;
	String date = validator.validateBall(reader.readBall());
	balls = new Ball[validator.getAmountObjects()];
	parser.parseBall(date, balls.length);
	dates = parser.getDates();
	for (int i = 0; i < balls.length; i++) {
	    for (int j = 0; j < AMOUNT_BALL_PARAMETERS; j++) {
		balls[i] = new Ball(new ThreeDimensionalPoint(dates[i][j++], dates[i][j++], dates[i][j++]),
			dates[i][j]);
	    }
	}
	return balls;
    }

    public ReaderFile getReader() {
	return reader;
    }

    public void setReader(ReaderFile reader) {
	this.reader = reader;
    }

    public Validator getValidator() {
	return validator;
    }

    public void setValidator(Validator validator) {
	this.validator = validator;
    }

    public Parser getParser() {
	return parser;
    }

    public void setParser(Parser parser) {
	this.parser = parser;
    }

}
