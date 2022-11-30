package Database;
import Interface.UserReporterPresenter;
import entities.Blocker;
import entities.UserFactory;

import java.time.LocalDateTime;
import java.util.List;

public class UserReporterInteractor implements InputBoundary {

    final GroupRepoInt userRepoInt;
    final UserReporterPresenter userPresenter;
    final UserFactory userFactory;
    //final ProfileRepoInt PROFILE_REPO_ACCESS;

    public UserReporterInteractor(GroupRepoInt userRepoInterface, UserReporterPresenter userReportPresenter,
                                  UserFactory userFactory) {
        this.userRepoInt = userRepoInterface;
        this.userPresenter = userReportPresenter;
        this.userFactory = userFactory;
        //this.PROFILE_REPO_ACCESS = profileRepoAccess;
    }


    @Override
    public UserMessageResponseModel create(UserMessageModel requestModel) {
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


        RepoMessageModel userDsModel = new RepoMessageModel(user.getMessageId(), user.getUserId(), user.getMessage()
                , user.getReportUserId(), now);
        userRepoInt.adduserModel(userDsModel);

        UserMessageResponseModel accountResponseModel = new UserMessageResponseModel(user.getMessageId(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }

}