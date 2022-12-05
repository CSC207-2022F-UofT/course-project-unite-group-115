package Reporter_Database;

public interface OutputBoundary {
    UserMessageResponseModel prepareSuccessView(UserMessageResponseModel user);

    UserMessageResponseModel prepareFailView(String error);
}

