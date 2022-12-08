package random_grouper_request_group;

import org.junit.Before;
import org.junit.Test;
import use_cases.random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;
import use_cases.random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReqRanGroupPresenterTest {
    List<String> interests = new ArrayList<>();

    @Before
    public void setUp() {
        interests.add("blue");
        interests.add("chocolate");
        interests.add("video games");
    }

    @Test
    public void testSuccessView() {
        ReqRanGroupResponseModel responseModel = new ReqRanGroupResponseModel("1", "Test");
        ReqRanGroupPresenter presenter = new ReqRanGroupPresenter();
        presenter.prepareSuccessView(responseModel);
        assertEquals("You were successfully added to Test (ID: 1)!", responseModel.getSuccessMessage());
    }
}
