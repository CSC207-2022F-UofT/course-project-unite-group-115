package add_blocked_Users.application_business_rules;

import java.util.List;

public class AddBlockedUserResponseModel {
    private List<String> blockedList;


    public AddBlockedUserResponseModel(List<String> list){
        this.blockedList = list;

    }



    /**
     * Return the user's interests.
     */
    public List<String> getBlockedList() {
        return blockedList;
    }

    /**
     * Change the stored interests to <interests>.
     */
    public void setBlockedList(List<String> list) {
        this.blockedList = list;
    }

}
