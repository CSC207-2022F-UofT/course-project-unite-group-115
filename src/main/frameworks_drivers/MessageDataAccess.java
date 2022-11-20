package frameworks_drivers;

import reaction_use_case.MessageDsGateway;
import reaction_use_case.ReactionDsRequestModel;
import reaction_use_case.MessageDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.lang.String;


public class MessageDataAccess implements MessageDsGateway{
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, MessageDsRequestModel> accounts = new HashMap<>();

    public MessageDataAccess(String csvPath) throws IOException{
        csvFile = new File(csvPath);

        headers.put("groupID", 0);
        headers.put("timestamp", 1);
        headers.put("message", 2);
        headers.put("sender", 3);
        headers.put("reaction", 4);
        headers.put("messageID", 5);

        if (csvFile.length() == 0){
            storeMessage();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String groupID = String.valueOf(Integer.valueOf(col[headers.get("groupID")]));
                Integer groupIDInt = new Integer(groupID);
                String timestamp = String.valueOf(col[headers.get("timestamp")]);
                LocalDateTime ts = LocalDateTime.parse(timestamp);
                String messageText = String.valueOf(col[headers.get("message")]);
                String sender = String.valueOf(col[headers.get("sender")]);
                String reaction = String.valueOf(col[headers.get("reaction")]);
                String messageID = String.valueOf(col[headers.get("messageID")]);
                Integer messageIDInt = new Integer(messageID);
                MessageDsRequestModel message = new MessageDsRequestModel(groupIDInt, ts, messageText, sender,
                        reaction, messageIDInt);
                accounts.put(sender, message);
            }

            reader.close();
        }
    }


    @Override
    public void storeMessage(MessageDsRequestModel requestModel) {
        accounts.put(requestModel.getSender(), requestModel);
        this.storeMessage();
    }


    private void storeMessage() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (MessageDsRequestModel message : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s",
                        message.getGroupID(), message.getTimestamp(), message.getMessage(), message.getSender(),
                        message.getReaction(), message.getMessageID());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addReaction(ReactionDsRequestModel requestModel){
        BufferedWriter writer;
    }

    public void removeReaction(ReactionDsRequestModel requestModel){
        BufferedWriter writer;
    }
}
