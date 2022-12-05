package message_sebd.application_business_rule;


public class MessageRequestModel {

    private String content;
    private String sender;
    private String groupID;


    public MessageRequestModel(String content, String sender, String groupID) {
        this.content = content;
        this.sender = sender;
        this.groupID = groupID;
    }


    //TODO: remove unused functions.
    String getContent(){
        return content;
    }

    void setContent(String content) {this.content = content;}

    String getSender(){return sender;}

    void setSender(String sender){this.sender = sender;}

    String getGroupID(){return groupID;}

    void setGroupID(String groupID){this.groupID = groupID;}



}