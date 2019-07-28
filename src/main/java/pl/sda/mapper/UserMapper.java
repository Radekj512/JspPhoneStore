package pl.sda.mapper;

import pl.sda.entity.UserEntity;
import pl.sda.model.User;

public class UserMapper {
    public static User mapToUser(UserEntity userEntity) {
        if (userEntity != null) {
            return User.builder()
                    .login(userEntity.getLogin())
                    .name(userEntity.getName())
                    .password(userEntity.getPassword()).build();
        }
        return null;
    }
}
