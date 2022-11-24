package usecase;

import java.util.ArrayList;

public class UserFactory {
    public Blocker create(String messageId, String userId, String message,String reportUserId) {
        return new Blocker(messageId, userId, message, reportUserId);
    }
}
