import java.util.List;

public class Group {
    protected static int numGroups = 0;
    protected String name;
    protected List<String> interests;
    protected final int id;
    protected List<Users> members;
    protected boolean random;

    public Group(String name, List<String> interests, List<Users> members, boolean isRandom) {
        this.name = name;
        this.interests = interests;
        this.members = members;
        this.random = isRandom;
        this.id = numGroups;
        numGroups++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getInterests() {
        return this.interests;
    }

    public void addInterests(List<String> interests) {
        for (String interest : interests) {
            if (!(interests.contains(interest))) {
                this.interests.add(interest);
            }
        }
    }

    public void removeInterests(List<String> interests) {
        for (String interest : interests) {
            this.interests.remove(interest);
        }
    }

    public int getId() {
        return this.id;
    }

    public List<Users> getMembers() {
        return this.members;
    }

    public void addMembers(List<Users> membersToAdd) {
        for (User member : membersToAdd) {
            if (!(this.members.contains(member))) {
                this.members.add(member);
            }
        }
    }

    public void removeMembers(List<Users> membersToRemove) {
        for (User member : membersToRemove) {
            this.members.remove(member);
        }
    }
}
