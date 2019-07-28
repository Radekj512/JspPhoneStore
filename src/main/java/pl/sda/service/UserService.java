package pl.sda.service;

import pl.sda.model.User;

public interface UserService {

    void saveUser(User user);

    User getUser(String login);
}
