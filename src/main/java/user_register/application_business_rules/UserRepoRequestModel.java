package user_register.application_business_rules;

import java.time.LocalDateTime;

// Use case layer

public class UserRepoRequestModel {

    private final String name;
    private String password;
    private final LocalDateTime creationTime;

    public UserRepoRequestModel(String name, String password, LocalDateTime creationTime) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}
