package general_group_create;

import use_cases.general_group.interface_adapters.GeneralGroupCreatePresenter;
import org.junit.Before;
import org.junit.Test;
import use_cases.general_group.use_case.GeneralGroupCreateDsResponseModel;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class GenGroupCreatePresenterUnitTest {
    List<String> members = new ArrayList<>();

    @Before
    public void setUp(){
        members.add("Jason");
        members.add("Tim");
    }

    @Test
    public void testSuccessView() {
        LocalDateTime time = LocalDateTime.now();
        GeneralGroupCreateDsResponseModel responseModel = new GeneralGroupCreateDsResponseModel(time.toString(),
                "123", "testing");
        GeneralGroupCreatePresenter presenter = new GeneralGroupCreatePresenter();
        presenter.prepareSuccessView(responseModel);
        assertEquals(time.format(DateTimeFormatter.ofPattern("hh:mm:ss")), responseModel.getCreationTime());
    }

}
