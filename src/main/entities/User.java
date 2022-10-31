public class User {
    private final String userName;
    private String passWord;
    private String email;
    private Profile profile = null;

    public User(String userName, String passWord, String email) {
        this.userName = userName;
        this.passWord  = passWord;
        this.email = email;
    }

}
