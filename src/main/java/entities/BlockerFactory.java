package entities;

import entities.Blocker;

public class BlockerFactory {
    public Blocker create(String messageId, String userId, String message, String reportUserId) {
        return new Blocker(messageId, userId, message, reportUserId);
    }
}
