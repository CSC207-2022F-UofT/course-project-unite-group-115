package get_groups;

import get_groups.application_business_rules.GetGroupsResponseModel;
import get_groups.interface_adapters.GetGroupsPresenter;
import org.junit.Before;
import org.junit.Test;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;
import random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetGroupsPresenterTest {
    Map<String, String> groups = new HashMap<>();

    @Before
    public void setUp() {
        groups.put("a", "1");
        groups.put("b", "2");
        groups.put("c", "3");
    }

    @Test
    public void testSuccessView() {
        GetGroupsResponseModel responseModel = new GetGroupsResponseModel(groups);
        GetGroupsPresenter presenter = new GetGroupsPresenter();
        presenter.prepareSuccessView(responseModel);
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        assertEquals(names, responseModel.getGroupNames());
    }
}
