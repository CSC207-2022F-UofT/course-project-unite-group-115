package entities;

public class UserFactory{
    public User create(String name, String password) {
        return new User(name, password);
    }
}
