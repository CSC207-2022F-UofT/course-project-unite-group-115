package Reporter_Database;

import java.time.LocalDateTime;
public class RepoMessageModel {
    private String messageId;

    private String userId;

    private String message;

    private String reportUserId;
    private final LocalDateTime time;


    public RepoMessageModel(String messageId, String userId, String message,String reportUserId,LocalDateTime time) {
        this.messageId = messageId;
        this.userId = userId;
        this.message = message;
        this.reportUserId = reportUserId;
        this.time = time;
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
    public LocalDateTime getTime() {
        return time;
    }


}