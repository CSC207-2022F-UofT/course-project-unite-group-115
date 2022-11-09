import java.util.List;
import java.util.UUID;

public class Group {
    private String name;
    private final List<String> interests;
    private final UUID ID;
    private final List<User> members;
    private final boolean random;

    /**
     * Generate a new group with a name, interests the members must possess, members of the group, and whether
     * random users can be assigned based on their interests. A universally unique ID will be automatically assigned.
     *
     * @param name the name of the group
     * @param interests the interests each group member must possess
     * @param members the members of the group
     * @param isRandom if the group has random members assigned based on interests
     */
    public Group(String name, List<String> interests, List<User> members, boolean isRandom) {
        this.name = name;
        this.interests = interests;
        this.members = members;
        this.random = isRandom;
        this.ID = UUID.randomUUID();
    }

    /**
     * Recreate an existing group.
     *
     * @param name the name of the group
     * @param interests the interests each group member must possess
     * @param members the members of the group
     * @param isRandom if the group has random members assigned based on interests
     * @param id the group id
     */
    public Group(String name, List<String> interests, List<User> members, boolean isRandom, String id) {
        this.name = name;
        this.interests = interests;
        this.members = members;
        this.random = isRandom;
        this.ID = UUID.fromString(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Return a list of the interests that members must possess to be part of the group.
     */
    public List<String> getInterests() {
        return this.interests;
    }

    /**
     * Add interests that any new group members must possess to be part of the group.
     *
     * @param interests interests to be added to the group
     */
    public void addInterests(List<String> interests) {
        for (String interest : interests) {
            boolean containsInterest = false;
            for (String existingInterest : this.interests) {
                if (existingInterest.equals(interest)) {
                    containsInterest = true;
                    break;
                }
            }
            if (!containsInterest){
                this.interests.add(interest);
            }
        }
    }

    public void removeInterests(List<String> interests) {
        for (String interest : interests) {
            this.interests.remove(interest);
        }
    }

    public String getId() {
        return this.ID.toString();
    }

    public List<User> getMembers() {
        return this.members;
    }

    /**
     * Add Users to be members to the group. If the User is already a member, do nothing.
     *
     * @param membersToAdd Users to be added to the group
     */
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
            this.members.remove(member);
        }
    }

    /**
     * Check if random Users can be added to the group based on their interests.
     */
    public boolean isRandom() {
        return this.random;
    }
}
