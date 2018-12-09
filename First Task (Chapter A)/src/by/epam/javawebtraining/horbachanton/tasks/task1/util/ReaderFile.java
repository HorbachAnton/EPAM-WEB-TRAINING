package by.epam.javawebtraining.horbachanton.tasks.task1.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderFile {

    public static final String MARKER_BALL = "Ball: «";
    private Path path;

    public ReaderFile() {
	path = Paths.get("file/default.txt");
    }

    public ReaderFile(Path path) {
	this.path = path;
    }

    public String[] readBall() throws IOException {
	String[] date = Files.lines(path).filter((s) -> s.contains(MARKER_BALL)).toArray(String[]::new);
	return date;
    }

    public Path getPath() {
	return path;
    }

    public void setPath(Path path) {
	this.path = path;
    }

}
