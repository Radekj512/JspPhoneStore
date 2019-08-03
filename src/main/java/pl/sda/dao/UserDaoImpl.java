package pl.sda.dao;

import pl.sda.entity.UserEntity;
import pl.sda.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {
    private static ArrayList<UserEntity> users = loadMockData();

    @Override
    public void saveUser(UserEntity user) {
        users.add(user);
    }

    @Override
    public Optional<UserEntity> findUser(String login) {
        return users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
    }

    @Override
    public void changeUserPassword(User user, String password) {

    }

    private static ArrayList<UserEntity> loadMockData() {
        ArrayList<UserEntity> users = new ArrayList<>();
        UserEntity u1 = UserEntity.builder()
                .email("kowalski@gmail.com")
                .login("kowalski")
                .name("Jan")
                .password("kowal1")
                .surname("Kowalski")
                .build();

        users.add(u1);
        return users;
    }

}
