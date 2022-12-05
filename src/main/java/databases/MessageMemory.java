package databases;

import java.util.*;

public class MessageMemory implements MessageRepoInt{
    final private Map<String, MessageDsRequestModel> messages = new HashMap<>();

    @Override
    public void editMessage(String ID, String content) {
        messages.get(ID).setContent(content);
    }

    @Override
    public void deleteMessage(String message_id) {
        messages.remove(message_id);
    }

    @Override
    public Map<String, Object> getMessageInfo(String MessageID) {
        MessageDsRequestModel requestModel = messages.get(MessageID);
        Map<String, Object> result = new HashMap<>();
        result.put("message content", requestModel.getContent());
        result.put("sender", requestModel.getSender());
        result.put("groupID", requestModel.getGroupID());
        result.put("messageID", requestModel.getMessageID());
        result.put("creation time", requestModel.getCreationTime());
        return result;
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
    public void save(MessageDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.getMessageID());
        messages.put(requestModel.getMessageID(), requestModel);
    }

    @Override
    public List<String> getGroupMessageInfo(String GroupID){
        List<String> allMessages = new ArrayList<>();
        for(String key : messages.keySet()){
            if (Objects.equals(messages.get(key).getGroupID(), GroupID)){
                MessageDsRequestModel model = messages.get(key);
                String messageFormat = model.getSender() + ": " + model.getContent() + " (" +
                        model.getMessageID() + ")" + "Reactions: " + model.getReaction();
                allMessages.add(messageFormat);
            }
        }
        return allMessages;
    }
}
