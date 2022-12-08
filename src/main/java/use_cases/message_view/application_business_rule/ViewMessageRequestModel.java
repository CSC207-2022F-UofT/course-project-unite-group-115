package use_cases.message_view.application_business_rule;

public class ViewMessageRequestModel {

    private String viewer;
    private String groupID;


    public ViewMessageRequestModel(String groupID, String viewer) {
        this.viewer = viewer;
        this.groupID = groupID;
    }

    String getGroupID(){return groupID;}

    void setGroupID(String groupID){this.groupID = groupID;}

    String getViewer(){return viewer;}
}
