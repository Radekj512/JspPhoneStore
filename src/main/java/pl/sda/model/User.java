package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class User {

    private String login;

    private String password;

    private String name;

    private String surname;

    private String email;
}
