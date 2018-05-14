package paquete1.amv.command;

public interface validationRules {
    
    int EMAIL_MIN_SIZE = 10;
    int PASSWORD_MIN_SIZE = 10;
    int FIRST_LAST_NAME_MAX_SIZE = 30;
    String FIRST_LAST_NAME_REGEX = "[a-zA-Z ]([&.'-]?[a-zA-Z ][&.'-]?)*";
    
}