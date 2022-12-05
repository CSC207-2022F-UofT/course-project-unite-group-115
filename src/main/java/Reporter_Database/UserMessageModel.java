package Database;

import java.util.UUID;

public class UserMessageModel {



    private String messageId;

    private String userId;

    private String message;

    private String reportUserId;

    public UserMessageModel(String messageId, String userId, String message,String reportUserId) {
        this.reportUserId = reportUserId;
        this.messageId = messageId;
        this.userId = userId;
        this.message = message;
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





}
