package Database;

import java.util.UUID;

public class UserMessageModel {



    private UUID messageId;

    private String userId;

    private String message;

    private String reportUserId;

    public UserMessageModel(UUID messageId, String userId, String message,String reportUserId) {
    }
    

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
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

    public String toString() {
        return "Your report of"+getUserId() +" has been submitted ";}



}
