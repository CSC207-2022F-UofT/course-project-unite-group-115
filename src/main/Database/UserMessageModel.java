package Database;

import java.util.UUID;

public class UserMessageModel {



    private UUID messageId;

    private UUID userId;

    private String message;

    private UUID reportUserId;

    public UserMessageModel(UUID messageId, UUID userId, String message,UUID reportUserId) {
    }
    

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(UUID reportUserId) {
        this.reportUserId = reportUserId;
    }

    public String toString() {
        return "Your report of"+getUserId() +" has been submitted ";}



}
