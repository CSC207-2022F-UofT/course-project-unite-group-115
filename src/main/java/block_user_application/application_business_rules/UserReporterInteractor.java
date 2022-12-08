package block_user_application.application_business_rules;
import block_user_application.interface_adapters.UserReporterPresenter;
import database_classes.UserReporterInt;
import database_classes.UserReporterRepoRequestModel;
import entities.Blocker;
import entities.BlockerFactory;

import java.time.LocalDateTime;

public class UserReporterInteractor implements UserReporterInputBoundary {

    final UserReporterInt userRepoInt;
    final UserReporterPresenter userPresenter;
    final BlockerFactory userFactory;


    public UserReporterInteractor(UserReporterInt userRepoInterface, UserReporterPresenter userReportPresenter,
                                  BlockerFactory userFactory) {
        this.userRepoInt = userRepoInterface;
        this.userPresenter = userReportPresenter;
        this.userFactory = userFactory;
        //this.PROFILE_REPO_ACCESS = profileRepoAccess;
    }


    @Override
    public UserReporterResponseModel create(UserReporterRequestModel requestModel) {
        Blocker user = userFactory.create(requestModel.getMessageId(), requestModel.getUserId(), requestModel.getMessage()
                , requestModel.getReportUserId());
        if (!user.messageIDIsValid()) {
            return userPresenter.prepareFailView("Message Id must not be empty.");
        }

        if (!user.userIdIsValid()) {
            return userPresenter.prepareFailView("User name must not be empty.");
        }
        if (!user.messageIsValid()) {
            return userPresenter.prepareFailView("Message must must not be empty.");
        }
        if (!user.reportUserIDIsValid()) {
            return userPresenter.prepareFailView("Your name must not be empty.");
        }
        LocalDateTime now = LocalDateTime.now();


        UserReporterRepoRequestModel userDsModel = new UserReporterRepoRequestModel(user.getMessageId(), user.getUserId(), user.getMessage()
                , user.getReportUserId(), now);
        userRepoInt.adduserModel(userDsModel);

        UserReporterResponseModel accountResponseModel = new UserReporterResponseModel(user.getMessageId(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }

}