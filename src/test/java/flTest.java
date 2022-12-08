import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class flTest {
    String name = "aa";
//    flManager.flFrame_Drivers.flManDataAccess a;
    String friList;

    @Before
    public void setUp() {//Before the test start,the blocklist in the profile must be empty
        String name = "tejasraghuvanshi";
//        a = new getSenslistDataAccess(name);
        friList = "[aa1;aa2]";
    }

    @Test(timeout = 50)
    public void TestblockUserwithNoBlockedUser() {//when the blocklist in the profile is empty

        String csv = "fri.csv";
        BufferedReader br = null;
        String line ;
        String username = "";

        List<List<String>> lines = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(csv));
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(","));
                lines.add(values);
            }
            for(List<String> userInfo : lines){
                username = userInfo.get(0);
                if(username.equals(name)){
                    System.out.print(userInfo.get(1));
                    assertEquals(friList,userInfo.get(1));
                }
            }
        } catch (IOException io) {
            System.out.println(io);
        }

    }
}
