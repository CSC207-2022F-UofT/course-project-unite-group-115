package database_classes;

public interface UserRepoInt {
    boolean existsByName(String identifier);

    void save(UserRepoRequestModel requestModel);
}
