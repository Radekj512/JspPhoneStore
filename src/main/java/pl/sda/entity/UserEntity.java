package pl.sda.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserEntity {

    private String login;

    private String password;

    private String name;

    private String surname;

    private String email;
}

