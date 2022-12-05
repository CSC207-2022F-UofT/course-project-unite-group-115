package user_register.application_business_rules;

import database_classes.UserRepoInt;
import database_classes.UserRepoRequestModel;
import entities.User;
import entities.UserFactory;

import java.time.LocalDateTime;
import user_register.interface_adapters.UserRegisterPresenter;

// Use case layer

public class UserRegisterInteractor implements UserRegisterInputBoundary {

    final UserRepoInt userRepoInt;
    final UserRegisterPresenter userPresenter;
    final UserFactory userFactory;

    /**
     * Constructor for UserRegisterInteractor class.
     * @param userRepoInterface the repository interface the interactor will interact with
     * @param userRegisterPresenter the presenter interactor will interact with
     * @param userFactory the factory interactor will interact with
     */
    public UserRegisterInteractor(UserRepoInt userRepoInterface, UserRegisterPresenter userRegisterPresenter,
                                  UserFactory userFactory) {
        this.userRepoInt = userRepoInterface;
        this.userPresenter = userRegisterPresenter;
        this.userFactory = userFactory;
    }

    /**
     * Create a new User and save it to the User Database.
     * @param requestModel A data structure containing the information required to create a new user.
     * @return Returns a data structure containing the user's username and creation time, if the creation was successful.
     * Or returns a data structure containing a failure message, if the creation was unsuccessful.
     */
    @Override
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) {
        User user = userFactory.create(requestModel.getName(), requestModel.getPassword());
        if (!user.nameIsValid()) {return userPresenter.prepareFailView("User name must not be empty.");}
        if (userRepoInt.existsByName(requestModel.getName())) {
            return userPresenter.prepareFailView("User already exists.");
        }
        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }
        if (!requestModel.getPassword().equals(requestModel.getRepeatPassword())) {
            return userPresenter.prepareFailView("Passwords don't match.");
        }

        LocalDateTime now = LocalDateTime.now();
        UserRepoRequestModel userDsModel = new UserRepoRequestModel(user.getName(), user.getPassword(), now);
        userRepoInt.save(userDsModel);

        UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(user.getName(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }
}
