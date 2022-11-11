package entities;

import java.util.List;
import java.util.UUID;

/**
 * A Group object that defines groups of members that can message each other.
 * Each Group has a name, a list of interests, a universally unique ID, a list of members that are part of the Group,
 * and a boolean value indicating how members are added to the Group.
 *      - The Group's interests determine what users can be added to the Group. All members must possess the interests defined
 *      by the Group.
 *      - If the <random> boolean is <true> users are only assigned to the Group when they request to be placed in
 *      a random group. The users are placed in the Group that has the most interests in common with them.
 *      - If the <random> boolean is <false>, users are only assigned to the Group by other existing members.
 */
public class Group {
    private String name;
    private List<String> interests;
    private final UUID ID;
    private List<User> members;
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
     * Recreate an existing group by entering its previous information.
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
     *
     * @return Returns a List of interests (Strings)
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

    /**
     * Remove interests that group members no longer need to possess to be part of the group.
     *
     * @param interests interests that should be removed from the group
     */
    public void removeInterests(List<String> interests) {
        for (String interest : interests) {
            this.interests.remove(interest);
        }
    }

    /**
     * Get the group's ID
     *
     * @return Returns the String form of the group's ID
     */
    public String getId() {
        return this.ID.toString();
    }

    public List<User> getMembers() {
        return this.members;
    }

    /**
     * Add Users to be members to the group. If the entities.User is already a member, do nothing.
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
