package pl.sda.service;

import pl.sda.dao.UserDao;
import pl.sda.dao.UserDaoImpl;
import pl.sda.entity.UserEntity;
import pl.sda.mapper.UserMapper;
import pl.sda.model.User;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(String login) {
        UserEntity userEntity = userDao.findUser(login).orElse(null);
        return UserMapper.mapToUser(userEntity);
    }
}
