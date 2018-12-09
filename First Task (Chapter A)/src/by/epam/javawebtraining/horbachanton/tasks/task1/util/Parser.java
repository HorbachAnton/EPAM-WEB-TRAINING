package by.epam.javawebtraining.horbachanton.tasks.task1.util;

import java.util.Locale;
import java.util.Scanner;

public class Parser {

    private static int AMOUNT_BALL_PARAMETERS = 4;
    private static Scanner scanner;
    private double[][] dates;

    public void parseBall(String data, int amountObjects) {
	scanner = new Scanner(data);
	scanner.useLocale(Locale.US);
	dates = new double[amountObjects][amountObjects * AMOUNT_BALL_PARAMETERS];
	for (int i = 0; i < amountObjects; i++) {
	    for (int j = 0; j < AMOUNT_BALL_PARAMETERS; j++) {
		if (scanner.hasNextDouble()) {
		    dates[i][j] = scanner.nextDouble();
		}
	    }
	}
    }

    public double[][] getDates() {
	return dates;
    }

    public void setDates(double[][] dates) {
	this.dates = dates;
    }

}
