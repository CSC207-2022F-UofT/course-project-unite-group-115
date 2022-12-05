package entities;

public class User {
    /**
     * A User object that the controller of an account.
     * Each User has a username and a password.
     *      - The User's username is final.
     *      - The User's password is a string greater than 5 letters long
     *      - The username and pssword are the required credentials for a User to be able to login to the system.
     */
    private final String name;
    private String passWord;

    /**
     * Constructor for User Class. It takes username and password arguments and assigns them to the
     * corresponding class variables.
     * @param userName the username of the User's account
     * @param passWord the password for the User's account
     */
    public User(String userName, String passWord) {
        this.name = userName;
        this.passWord  = passWord;
    }
    /**
     * Returns whether inputted username is valid or not. A username id valid if it is not null and has
     * length of 1 or more letters.
     */
    public boolean nameIsValid() {return name != null && name.length() > 0;}

    /**
     * Returns whether inputted password is valid or not. A username is valid if it is not null and has
     * a length of 6 or more letters.
     */
    public boolean passwordIsValid() {return passWord != null && passWord.length() > 5;}

    /**
     * Returns the username of the User.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the password of the User.
     */
    public String getPassword() {
        return this.passWord;
    }
}
