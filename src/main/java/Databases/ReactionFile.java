package Databases;

import reaction_use_case.ReactionDsGateway;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReactionFile implements ReactionDsGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, ReactionDsRequestModel> reactions = new HashMap<>();

    public ReactionFile(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("reaction", 0);
        headers.put("messageID", 1);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String reaction = String.valueOf(col[headers.get("reaction")]);
                String messageID = String.valueOf(col[headers.get("messageID")]);
                ReactionDsRequestModel reactionDS = new ReactionDsRequestModel(reaction, messageID);
                reactions.put(messageID, reactionDS);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(ReactionDsRequestModel requestModel) {
        reactions.put(requestModel.getMessageID(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (ReactionDsRequestModel reaction : reactions.values()) {
                String line = String.format("%s,%s", reaction.getReaction(), reaction.getMessageID());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addReaction(ReactionDsRequestModel requestModel){
        reactions.put(requestModel.getMessageID(), requestModel);
        this.save();
    }

    @Override
    public void removeReaction(String messageID){
        reactions.remove(messageID);
        this.save();
    }

}
