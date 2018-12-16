package by.epam.javawebtraining.horbachanton.tasks.task1.dao;

import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.exception.NegativeCapException;
import by.epam.javawebtraining.horbachanton.tasks.task1.model.exception.NegativeRadiusException;

public interface CalculatableBall {
    
    public double calculateVolume(Ball ball) throws NegativeRadiusException;
    
    public double calculateSurfaceArea(Ball ball) throws NegativeRadiusException;
    
    public double calculateVolumeRatio(double heightCap, Ball ball) throws NegativeCapException, NegativeRadiusException;

}
