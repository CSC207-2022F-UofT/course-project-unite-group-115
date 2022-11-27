package random_grouper_create;

import databases.*;
import entities.RandomGroupFactory;
import org.junit.Before;
import org.junit.Test;
import random_grouper_create.application_business_rules.RanGroupCreateInputBoundary;
import random_grouper_create.application_business_rules.RanGroupCreateInteractor;
import random_grouper_create.application_business_rules.RanGroupCreateResponseModel;
import random_grouper_create.interface_adapters.RanGroupCreateControl;
import random_grouper_create.interface_adapters.RanGroupCreatePresenter;

import java.time.LocalDate;
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
