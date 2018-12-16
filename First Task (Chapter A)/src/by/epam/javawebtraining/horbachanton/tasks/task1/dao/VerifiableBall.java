package by.epam.javawebtraining.horbachanton.tasks.task1.dao;

import by.epam.javawebtraining.horbachanton.tasks.task1.model.entity.Ball;

public interface VerifiableBall {
    
    public boolean isBall(Object object);
    
    public boolean isBallTouchPlane(Ball ball);

}
