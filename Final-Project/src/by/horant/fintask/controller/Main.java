package by.horant.fintask.controller;

import org.mindrot.jbcrypt.BCrypt;

public class Main {
    
    String userPassword = "leo12";
    String hashedPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt(12));
    boolean result1 = BCrypt.checkpw(userPassword, hashedPassword);


}
