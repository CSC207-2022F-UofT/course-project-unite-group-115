package Databases;

import MessageUserCase.MessageDsRequestModel;
import MessageUserCase.MessageDsGateway;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MessageFile implements MessageDsGateway {

    private File csvFile;

    private final Map<String, String, Stirng> headers = new LinkedHashMap<>();

    private final Map<String, MessageDsRequestModel> messages = new HashMap<>();

    public MessageFile(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("content", 0);
        headers.put("sender", 1);
        headers.put("receiver", 2);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String content = String.valueOf(col[headers.get("content")]);
                String sender = String.valueOf(col[headers.get("sender")]);
                String receiver = String.valueOf(col[headers.get("receiver")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                MessageDsRequestModel user = new MessageDsRequestModel(content, sender, receiver);
                messages.put(content, sender, receiver);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(MessageDsRequestModel requestModel) {
        messages.put(requestModel.getContent, requestModel);
        this.save();
    }
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (MessageDsRequestModel user : messages.values()) {
                String line = "%s,%s,%s".formatted(
                        user.getContent(), user.getsender(), user.getreceiver());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //imcomplete
    @Override
    public void editmessage(EditmessageDsRequestModel requestModel){

        this.save();
    }


    @Override
    public boolean existsByName(String identifier) {
        return messages.containsKey(identifier);
    }

}
