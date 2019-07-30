package pl.sda.service;

import javax.xml.bind.ValidationEvent;

public class RegisterValidationServiceImpl implements RegisterValidationService {

    @Override
    public boolean validateFirstNameAdnLastName(String s) {
        return s.length() > 3;
    }

    @Override
    public boolean validateEmail(String e) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return e.matches(regex);
    }

    @Override
    public boolean validateLogin(String l) {
        return l.length() > 5;
    }

    @Override
    public boolean validatePassword(String p) {
        return p.length() > 8;
    }

    @Override
    public boolean validateNewUser(String name, String lastName, String email, String login, String password) {
        return (validateFirstNameAdnLastName(name) && validateFirstNameAdnLastName(lastName) && validateEmail(email)
        && validateLogin(login) && validatePassword(password));
    }
}
