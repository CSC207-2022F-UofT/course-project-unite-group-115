package entities;

import Database.ProfileManagerDataAccess;
import Database.ProfileRepoInt;
import get_user_sensitiveWordList.application_business_rules.GetUserInteractor;
import get_user_sensitiveWordList.application_business_rules.GetUserListResponseModel;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListController;

import java.util.List;

public class Blocker {
    private String messageId;

    private String userId;

    private String message;

    private String reportUserId;


    public Blocker(String messageId, String userId, String message,String reportUserId) {
        this.messageId = messageId;
        this.userId = userId;
        this.message = message;
        this.reportUserId = reportUserId;

    }


    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(String reportUserId) {
        this.reportUserId = reportUserId;
    }
    public boolean messageIDIsValid() {return messageId != null && messageId.length() > 0;}

    public boolean userIdIsValid() {return userId != null && userId.length() > 0;}

    public boolean messageIsValid() {return message != null && message.length() > 0;}

    public boolean reportUserIDIsValid() {return reportUserId != null && reportUserId.length() > 0;}
    /*public ArrayList<String> getBlockedUsers() {
        return this.blockedUsers;
    }
    public ArrayList<String> getSensitiveWords() {
        return this.sensitiveWords;
    }
    public String getID() {
        return this.ID;
    }

    public void setBlockedUsers(ArrayList<String> blockedUsers){
        this.blockedUsers =blockedUsers;
    }
    public void setSensitiveWords(ArrayList<String> sensitiveWords){
        this.sensitiveWords =sensitiveWords;
    }

    add users to blocked list

    public void addBlockedUsers(String id){
        if(!getBlockedUsers().contains(id)){
            this.blockedUsers.add(id);
        }

    }*/


}
