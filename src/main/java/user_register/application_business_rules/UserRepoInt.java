package user_register.application_business_rules;

public interface UserRepoInt {
    boolean existsByName(String identifier);

    void save(UserRepoRequestModel requestModel);
}
