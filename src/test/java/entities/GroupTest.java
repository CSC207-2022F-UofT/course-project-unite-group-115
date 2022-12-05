package entities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GroupTest {
    List<String> interests = new ArrayList<>();
    List<String> members = new ArrayList<>();

    @Before
    public void setUp(){
        interests.add("blue");
        interests.add("chocolate");
        interests.add("video games");

        members.add("James");
        members.add("Chloe");
    }

    @Test(timeout = 50)
    public void testConstructor() {
        Group group = new Group("test", interests, members, true);
        assertEquals("test", group.getName());
        assertEquals(3, group.getInterests().size());
        assertEquals(2, group.getMembers().size());
        assertTrue(group.isRandom());
    }

    @Test(timeout = 50)
    public void testIds() {
        Group group = new Group("test", interests, members, true);
        Group group2 = new Group("test2", interests, members, false);
        Group group3 = new Group("test3", interests, members, false);
        assertNotEquals(group.getId(), group2.getId(), group3.getId());
    }

    @Test(timeout = 50)
    public void testSetName() {
        Group group = new Group("test", interests, members, true);
        group.setName("Happy");
        assertEquals("Happy", group.getName());
    }

    @Test(timeout = 50)
    public void testAddInterests() {
        Group group = new Group("test", interests, members, true);
        List<String> newInterests = new ArrayList<>();
        newInterests.add("heavy metal");
        group.addInterests(newInterests);
        assertEquals(4, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void testAddSameInterests() {
        Group group = new Group("test", interests, members, true);
        List<String> newInterests = new ArrayList<>();
        newInterests.add("chocolate");
        group.addInterests(newInterests);
        assertEquals(3, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void testRemoveInterests() {
        Group group = new Group("test", interests, members, true);
        List<String> interestsRemove = new ArrayList<>();
        interestsRemove.add("chocolate");
        group.removeInterests(interestsRemove);
        assertEquals(2, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void testRemoveNoInterests() {
        Group group = new Group("test", interests, members, true);
        List<String> interestsRemove = new ArrayList<>();
        interestsRemove.add("rain");
        group.removeInterests(interestsRemove);
        assertEquals(3, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void testAddMembers() {
        Group group = new Group("test", interests, members, true);
        List<String> usersAdd = new ArrayList<>();
        usersAdd.add("Joe");
        usersAdd.add("Beatrice");
        group.addMembers(usersAdd);
        assertEquals(4, group.getMembers().size());
    }

    @Test(timeout = 50)
    public void testAddSameMembers() {
        Group group = new Group("test", interests, members, true);
        List<String> usersAdd = new ArrayList<>();
        usersAdd.add("Joe");
        usersAdd.add("Joe");
        group.addMembers(usersAdd);
        assertEquals(3, group.getMembers().size());
    }

    @Test(timeout = 50)
    public void testRemoveMembers() {
        Group group = new Group("test", interests, members, true);
        List<String> usersAdd = new ArrayList<>();
        usersAdd.add("Joe");
        usersAdd.add("Beatrice");
        group.addMembers(usersAdd);
        assertEquals(4, group.getMembers().size());

        List<String> usersRemove = new ArrayList<>();
        usersRemove.add("Joe");
        group.removeMembers(usersRemove);
        assertEquals(3, group.getMembers().size());
    }

    @Test(timeout = 50)
    public void testRemoveNoMembers() {
        Group group = new Group("test", interests, members, true);
        List<String> usersAdd = new ArrayList<>();
        usersAdd.add("Joe");
        usersAdd.add("Beatrice");
        group.addMembers(usersAdd);

        List<String> usersRemove = new ArrayList<>();
        usersRemove.add("Jake");
        group.removeMembers(usersRemove);
        assertEquals(4, group.getMembers().size());
    }
}
