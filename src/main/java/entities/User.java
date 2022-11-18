package entities;

public class User {
    private final String name;
    private String passWord;
    private Profile profile = null;


    public User(String userName, String passWord) {
        this.name = userName;
        this.passWord  = passWord;
    }

    public boolean nameIsValid() {return name != null && name.length() > 0;}
    public boolean passwordIsValid() {return passWord != null && passWord.length() > 5;}

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.passWord;
    }
}
