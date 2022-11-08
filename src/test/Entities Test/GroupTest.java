import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroupTest {
    List<String> interests = new ArrayList<>();
    List<User> users = new ArrayList<>();

    @Before
    public void setUp(){
        interests.add("blue");
        interests.add("chocolate");
        interests.add("video games");
    }

    @Test(timeout = 50)
    public void TestConstructor() {
        Group group = new Group("test", interests, users, true);
        assertEquals("test", group.getName());
        assertEquals(3, group.getInterests().size());
        assertEquals(0, group.getMembers().size());
        assertTrue(group.isRandom());
        assertEquals(0, group.getId());
    }

    @Test(timeout = 50)
    public void TestIds() {
        Group group = new Group("test", interests, users, true);
        Group group2 = new Group("test2", interests, users, false);
        assertEquals(0, group.getId());
        assertEquals(1, group2.getId());
        Group group3 = new Group("test3", interests, users, false);
        assertEquals(2, group3.getId());
    }

    @Test(timeout = 50)
    public void TestSetName() {
        Group group = new Group("test", interests, users, true);
        group.setName("Happy");
        assertEquals("Happy", group.getName());
    }

    @Test(timeout = 50)
    public void TestAddInterests() {
        Group group = new Group("test", interests, users, true);
        List<String> newInterests = new ArrayList<>();
        newInterests.add("heavy metal");
        group.addInterests(newInterests);
        assertEquals(4, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void TestAddSameInterests() {
        Group group = new Group("test", interests, users, true);
        List<String> newInterests = new ArrayList<>();
        newInterests.add("chocolate");
        group.addInterests(newInterests);
        assertEquals(3, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void TestRemoveInterests() {
        Group group = new Group("test", interests, users, true);
        List<String> interestsRemove = new ArrayList<>();
        interestsRemove.add("chocolate");
        group.removeInterests(interestsRemove);
        assertEquals(2, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void TestRemoveNoInterests() {
        Group group = new Group("test", interests, users, true);
        List<String> interestsRemove = new ArrayList<>();
        interestsRemove.add("rain");
        group.removeInterests(interestsRemove);
        assertEquals(3, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void TestAddMembers() {
        Group group = new Group("test", interests, users, true);
        List<User> usersAdd = new ArrayList<>();
        usersAdd.add(new User("Joe"));
        usersAdd.add(new User("Beatrice"));
        group.addMembers(usersAdd);
        assertEquals(2, group.getMembers().size());
    }

    @Test(timeout = 50)
    public void TestRemoveMembers() {
        Group group = new Group("test", interests, users, true);
        List<User> usersAdd = new ArrayList<>();
        User joe = new User("Joe");
        usersAdd.add(joe);
        usersAdd.add(new User("Beatrice"));
        group.addMembers(usersAdd);

        List<User> usersRemove = new ArrayList<>();
        usersRemove.add(joe);
        group.removeMembers(usersRemove);
        assertEquals(1, group.getMembers().size());
    }

    @Test(timeout = 50)
    public void TestRemoveNoMembers() {
        Group group = new Group("test", interests, users, true);
        List<User> usersAdd = new ArrayList<>();
        usersAdd.add(new User("Joe"));
        usersAdd.add(new User("Beatrice"));
        group.addMembers(usersAdd);

        List<User> usersRemove = new ArrayList<>();
        usersRemove.add(new User("Jake"));
        group.removeMembers(usersRemove);
        assertEquals(2, group.getMembers().size());
    }

}
