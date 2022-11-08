import java.util.List;

public class Group {
    //ToDo: Remember to think about storing this in database
    private static int numGroups = 0;
    private String name;
    private List<String> interests;
    private final int id;
    private List<User> members;
    private boolean random;

    public Group(String name, List<String> interests, List<User> members, boolean isRandom) {
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

    public List<User> getMembers() {
        return this.members;
    }

    public void addMembers(List<User> membersToAdd) {
        for (User member : membersToAdd) {
            if (!(this.members.contains(member))) {
                this.members.add(member);
            }
        }
    }

    /**
     * Remove the Users in membersToRemove from the group, if they are part of the group.
     * If a User from membersToRemove is not part of the group, do nothing.
     *
     * @param membersToRemove list of Users to be removed from the group
     */
    public void removeMembers(List<User> membersToRemove) {
        for (User member : membersToRemove) {
            if (this.members.contains(member)) {
                this.members.remove(member);
            }
        }
    }

    public boolean isRandom() {
        return this.random;
    }
}
