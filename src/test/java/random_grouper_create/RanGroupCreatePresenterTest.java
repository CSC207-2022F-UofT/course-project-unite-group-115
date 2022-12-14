package random_grouper_create;

import org.junit.Before;
import org.junit.Test;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateResponseModel;
import use_cases.random_grouper_create.interface_adapters.RanGroupCreatePresenter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RanGroupCreatePresenterTest {
    List<String> interests = new ArrayList<>();

    @Before
    public void setUp() {
        interests.add("blue");
        interests.add("chocolate");
        interests.add("video games");
    }

    @Test
    public void testSuccessView() {
        LocalDateTime time = LocalDateTime.now();
        RanGroupCreateResponseModel responseModel = new RanGroupCreateResponseModel("Test",
                "123", time.toString());
        RanGroupCreatePresenter presenter = new RanGroupCreatePresenter();
        presenter.prepareSuccessView(responseModel);
        assertEquals(time.format(DateTimeFormatter.ofPattern("hh:mm:ss")), responseModel.getCreationTime());
    }
}
