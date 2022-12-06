package entities;

public class UserFactory{
    /**
     * Create a User object with given username and password attributes
     * @param name the username of the User's account.
     * @param password the password for the User's account
     */
    public User create(String name, String password) {
        return new User(name, password);
    }
}
