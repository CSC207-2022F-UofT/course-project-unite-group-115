package messgae_use_case;

import java.io.IOException;

public interface ViewMessageInputBoundary {
    ViewMessageResponseModel create(ViewMessageRequestModel requestModel) throws IOException;
}
