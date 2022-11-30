package flManager.application_business_rules;

import java.util.List;

public class flManResponseModel {
    private String owner;
    private List<String> friends;
    public flManResponseModel(String owner, List<String> friends) {
        this.owner = owner;
        this.friends = friends;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
