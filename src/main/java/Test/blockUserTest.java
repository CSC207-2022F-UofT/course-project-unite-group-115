package Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import Database.getSenslistDataAccess;
import org.junit.Before;
import org.junit.Test;
public class blockUserTest {
    getSenslistDataAccess a;
    @Before
    public void setUp(){
        String name = "Aurora";
        a= new getSenslistDataAccess(name);
    }

    @Test(timeout = 50)
    public void TestblockUser() {
        assertEquals("****", a.blockUser("busy","Ellen"));

    }






}
