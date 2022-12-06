package database_classes;

import java.util.*;

public class MessageMemory implements MessageRepoInt{
    final private Map<String, MessageRepoRequestModel> messages = new HashMap<>();

    @Override
    public Map<String, Object> getMessageInfo(String MessageID) {
        MessageRepoRequestModel requestModel = messages.get(MessageID);
        Map<String, Object> result = new HashMap<>();
        result.put("message content", requestModel.getContent());
        result.put("sender", requestModel.getSender());
        result.put("groupID", requestModel.getGroupID());
        result.put("messageID", requestModel.getMessageID());
        result.put("creation time", requestModel.getCreationTime());
        return result;
    }

    @Override
    public void editMessage(String ID, String content) {
        messages.get(ID).setContent(content);
    }

    @Override
    public void deleteMessage(String message_id) {
        messages.remove(message_id);
    }

    @Override
    public String getGroupMessageInfo(String GroupID) {
        List<String> allMessages = new ArrayList<>();
        for (String key : messages.keySet()) {
            if (Objects.equals(messages.get(key).getGroupID(), GroupID)) {
                MessageRepoRequestModel model = messages.get(key);
                String messageFormat = model.getSender() + ": " + model.getContent() +
                        " Reactions: " + model.getReaction() + " (Message ID:" + model.getMessageID() + ")" + "\n";
                allMessages.add(messageFormat);
            }
        }
        return allMessages.toString();
    }

    @Override
    public boolean doesGroupExist(String GroupID) {
        for (String key : messages.keySet()) {
            MessageRepoRequestModel model = messages.get(key);
            String id = model.getGroupID();
            if (id.equals(GroupID)) {
                return true;
            }
        }

        return false;
    }


    public boolean messageNotExist(String messageID){
        return !messages.containsKey(messageID);
    }

    /**
     * @param identifier the message's ID
     * @return whether the reaction exists
     */
    @Override
    public boolean reactionExists(String reaction, String identifier) {
        return messages.get(identifier).checkReactionExists(reaction);
    }
    public void addReaction(String reaction, String messageID){
        messages.get(messageID).addReaction(reaction);
    }

    public void removeReaction(String reaction, String messageID){
        messages.get(messageID).removeReaction(reaction);
    }

    /**
     * @param requestModel the data to save
     */
    @Override
    public void save(MessageRepoRequestModel requestModel) {
        System.out.println("Save " + requestModel.getMessageID());
        messages.put(requestModel.getMessageID(), requestModel);
    }

}
