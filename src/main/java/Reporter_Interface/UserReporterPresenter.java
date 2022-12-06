package Reporter_Interface;

import Reporter_Database.OutputBoundary;
import Reporter_Database.UserMessageResponseModel;
import Reporter_frameworks_and_drivers.Failed;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserReporterPresenter implements OutputBoundary {
    @Override
    public UserMessageResponseModel prepareSuccessView(UserMessageResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getTime());
        response.setTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    public UserMessageResponseModel prepareFailView(String error){
        throw new Failed(error);
    }

}
