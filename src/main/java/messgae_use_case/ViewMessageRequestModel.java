package messgae_use_case;

public class ViewMessageRequestModel {

    private String sender;
    private String groupID;


    public ViewMessageRequestModel(String groupID) {
        this.groupID = groupID;
    }

    String getGroupID(){return groupID;}

    void setGroupID(String groupID){this.groupID = groupID;}
}
