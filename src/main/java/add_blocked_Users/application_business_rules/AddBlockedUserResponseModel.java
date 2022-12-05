package add_blocked_Users.application_business_rules;

import java.util.List;

public class AddBlockedUserResponseModel {
    private String blockedList;


    public AddBlockedUserResponseModel(String list){
        this.blockedList = list;

    }



    /**
     * Return the user's interests.
     */
    public String getBlockedList() {
        return blockedList;
    }

    /**
     * Change the stored interests to <interests>.
     */
    public void setBlockedList(String list) {
        this.blockedList = list;
    }

}
