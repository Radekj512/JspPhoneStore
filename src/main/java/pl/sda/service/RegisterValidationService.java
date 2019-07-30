package pl.sda.service;

public interface RegisterValidationService {
    boolean validateFirstNameAdnLastName(String s);
    boolean validateEmail(String e);
    boolean validateLogin(String l);
    boolean validatePassword(String p);
    boolean validateNewUser(String name, String lastName, String email, String login, String password);
}
