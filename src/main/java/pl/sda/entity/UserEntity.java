package pl.sda.entity;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserEntity {

    private String login;

    private String password;

    private String name;

    private String surname;

    private String email;
}

