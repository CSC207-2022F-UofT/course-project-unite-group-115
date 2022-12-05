package entities;

import general_group.entities.Group;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GenGroupUnitTest {

    List<String> interests = new ArrayList<>();
    List<String> members = new ArrayList<>();

    @Before
    public void setUp(){
        members.add("James");
        members.add("Chloe");
    }

    @Test(timeout = 50)
    public void testConstructor() {
        Group group = new Group("test", interests, members, false);
        assertEquals("test", group.getName());
        assertEquals(0, group.getInterests().size());
        assertEquals(2, group.getMembers().size());
        assertFalse(group.isRandom());
    }

    @Test(timeout = 50)
    public void testIds() {
        Group group = new Group("test", interests, members, false);
        Group group1 = new Group("test1", interests, members, false);
        Group group2 = new Group("test2", interests, members, false);
        assertNotEquals(group.getId(), group1.getId(), group2.getId());
    }

    @Test(timeout = 50)
    public void testSetName() {
        Group group = new Group("test", interests, members, false);
        group.setName("Happy");
        assertEquals("Happy", group.getName());
    }

    @Test(timeout = 50)
    public void testAddInterests() {
        Group group = new Group("test", interests, members, false);
        List<String> newInterests = new ArrayList<>();
        newInterests.add("heavy metal");
        group.addInterests(newInterests);
        assertEquals(4, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void testAddSameInterests() {
        Group group = new Group("test", interests, members, false);
        List<String> newInterests = new ArrayList<>();
        newInterests.add("chocolate");
        group.addInterests(newInterests);
        assertEquals(3, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void testRemoveInterests() {
        Group group = new Group("test", interests, members, false);
        List<String> interestsRemove = new ArrayList<>();
        interestsRemove.add("chocolate");
        group.removeInterests(interestsRemove);
        assertEquals(2, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void testRemoveNoInterests() {
        Group group = new Group("test", interests, members, false);
        List<String> interestsRemove = new ArrayList<>();
        interestsRemove.add("rain");
        group.removeInterests(interestsRemove);
        assertEquals(3, group.getInterests().size());
    }

    @Test(timeout = 50)
    public void testAddMembers() {
        Group group = new Group("test", interests, members, false);
        List<String> usersAdd = new ArrayList<>();
        usersAdd.add("Joe");
        usersAdd.add("Beatrice");
        group.addMembers(usersAdd);
        assertEquals(4, group.getMembers().size());
    }

    @Test(timeout = 50)
    public void testAddSameMembers() {
        Group group = new Group("test", interests, members, false);
        List<String> usersAdd = new ArrayList<>();
        usersAdd.add("Joe");
        usersAdd.add("Joe");
        group.addMembers(usersAdd);
        assertEquals(3, group.getMembers().size());
    }

    @Test(timeout = 50)
    public void testRemoveMembers() {
        Group group = new Group("test", interests, members, false);
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
        Group group = new Group("test", interests, members, false);
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

