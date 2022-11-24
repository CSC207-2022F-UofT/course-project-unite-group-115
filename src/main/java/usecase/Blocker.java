package usecase;

import Database.UserDataAccess;
import Database.UserMessageModel;

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

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

    /* check sensitive words list in chatting,add user to blacklist and replace sensitive word

    public  String blockUser(String userid,String text){
        String newText = "";
        for(String word : getSensitiveWords()){
            if(text.toLowerCase().contains(word.toLowerCase())){
                addBlockedUsers(userid);
                newText = text.replace(word.toLowerCase(),"*".repeat(word.length()));
                //delete friend (doesn't finish)
            } /*else if (text.toLowerCase().contains(word)) {
                addBlockedUsers(userid);
                newText = text.replace(word,"*".repeat(word.length()));

            }
        }
        return newText;
    }
    */







}
