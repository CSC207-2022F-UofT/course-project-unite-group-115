package test;
import org.junit.Before;
import org.junit.Test;
import usecase.Blocker;
import java.io.IOException;
import java.util.UUID;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class entities_test {
    Blocker a;
    
    @Before
    public void setUp() throws Exception {
        String user = "UUID.randomUUID()";
        ArrayList<String> blocklist = new ArrayList<String>();
        blocklist.add("Volvo");
        blocklist.add("BMW");
        blocklist.add("ford");
        blocklist.add("Mazda");
        ArrayList<String> blacklist = new ArrayList<String>();

        a = new Blocker(user,blacklist, blocklist);
    }
    @Test
    public void testCheckWords() throws IOException {



        a.blockUser("UUID.randomUUID()","ford");

        assertEquals(1,a.getBlockedUsers().size());

        assertEquals("****",a.blockUser("UUID.randomUUID()","ford"));

    }

}
