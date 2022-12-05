package database_classes;

import general_group.use_case.GroupRepoInt;

import java.io.*;
import java.util.*;

public class GroupDataAccess implements GroupRepoInt {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, GroupRepoDsRequestModel> groups = new LinkedHashMap<>();

    public GroupDataAccess (String csvFilePath) throws IOException {
        this.csvFile = new File(csvFilePath);

        headers.put("group name", 0);
        headers.put("group ID", 1);
        headers.put("members", 2);
        headers.put("interests", 3);
        headers.put("is random group?", 4);

        if (csvFile.length() == 0) {
            save();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String groupName = String.valueOf(col[headers.get("group name")]);
                String groupID = String.valueOf(col[headers.get("group ID")]);
                String members = String.valueOf(col[headers.get("members")]);
                List<String> membersList = Arrays.asList(members.split(";"));
                String interests = String.valueOf(col[headers.get("interests")]);
                List<String> interestsList = Arrays.asList(interests.split(";"));
                String isRandom = String.valueOf(col[headers.get("is random group?")]);
                GroupRepoDsRequestModel group = new GroupRepoDsRequestModel(groupName, interestsList, groupID,
                        membersList, isRandom.equals("true"));
                groups.put(groupID, group);
            }

            reader.close();
        }
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (GroupRepoDsRequestModel group : groups.values()) {
                String line = String.format("%s,%s,%s,%s,%s", group.getName(), group.getID(), String.join(";",
                        group.getMembers()), String.join(";", group.getInterests()), group.isRandom());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void addGroup(GroupRepoDsRequestModel requestModel) {
        groups.put(requestModel.getID(), requestModel);
        this.save();

    }

    @Override
    public void removeGroup(String groupID) {
        groups.remove(groupID);
        this.save();
    }

    @Override
    public Map<String, Object> getGroupData(String groupID) {
        GroupRepoDsRequestModel repoDsRequestModel = groups.get(groupID);
        Map<String, Object> result = new HashMap<>();
        result.put("group name", repoDsRequestModel.getName());
        result.put("group ID", repoDsRequestModel.getID());
        result.put("members",repoDsRequestModel.getMembers());
        result.put("interests", repoDsRequestModel.getInterests());
        result.put("random group?", repoDsRequestModel.isRandom());
        return result;
    }

    @Override
    public void addUserToGroup(String userName, String groupID) {
        List<String> members = new ArrayList<>(groups.get(groupID).getMembers());
        members.add(userName);
        groups.get(groupID).setMembers(members);
        this.save();
    }

    @Override
    public void removeUserFromGroup(String userName, String groupID) {
        List<String> members = new ArrayList<>(groups.get(groupID).getMembers());
        members.remove(userName);
        groups.get(groupID).setMembers(members);
        this.save();
    }


}
