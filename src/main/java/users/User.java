package users;

import lombok.Getter;

import static utils.DataFaker.*;

@Getter
public class User {
    private final String userFirstName;
    private final String userLastName;
    private final String userEmail;
    private final String userPassword;
    private final String userBirthday;

    public User() {
        this.userFirstName = getFirstName();
        this.userLastName = getLastName();
        this.userEmail = getEmail();
        this.userPassword = getPassword();
        this.userBirthday = getBirthdate();
    }
}
