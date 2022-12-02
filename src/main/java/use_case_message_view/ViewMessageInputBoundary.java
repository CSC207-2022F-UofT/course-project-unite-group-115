package use_case_message_view;

import java.io.IOException;

public interface ViewMessageInputBoundary {
    ViewMessageResponseModel create(ViewMessageRequestModel requestModel) throws IOException;
}
