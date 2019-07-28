package pl.sda.dao;

import pl.sda.entity.UserEntity;
import pl.sda.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private List<UserEntity> users = loadMockData();

    @Override
    public void saveUser(UserEntity user) {
        users.add(user);
    }

    @Override
    public Optional<UserEntity> findUser(String login) {
        return users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
    }

    private List<UserEntity> loadMockData() {

        UserEntity u1 = UserEntity.builder()
                .email("kowalski@gmail.com")
                .login("kowalski")
                .name("Jan")
                .password("kowal1")
                .surname("Kowalski")
                .build();
        return Arrays.asList(u1);
    }

}
