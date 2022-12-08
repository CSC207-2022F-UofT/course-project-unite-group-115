package flManager.application_business_rules;

import entities.FriendList;
import flManager.interface_adapters.flManPresenter;
import database_classes.ProfileRepoInt;
import database_classes.flManRepoRequestModel;
import entities.FriendListFactory;


public class flManUseCaseInteractor  implements flManInputBoundary {

    final flManager.interface_adapters.flManPresenter flManPresenter;
    final FriendListFactory flFactory;
    final ProfileRepoInt PROFILE_REPO_ACCESS;

    public flManUseCaseInteractor(flManPresenter flManPresenter,
                                  FriendListFactory flFactory, ProfileRepoInt profileRepoAccess) {
        this.flManPresenter = flManPresenter;
        this.flFactory = flFactory;
        this.PROFILE_REPO_ACCESS = profileRepoAccess;
    }

    @Override
    public flManResponseModel create(flManRequestModel requestModel) {
        FriendList friendList = FriendListFactory.create(
                requestModel.getOwner(), requestModel.getFriends());

        flManRepoRequestModel repoReqMod = new flManRepoRequestModel(
                friendList.getOwner(), friendList.getFriends());

//        flManRepoInt.save(repoReqMod);

        flManResponseModel friRespMod = new flManResponseModel(
                friendList.getOwner(), friendList.getFriends());
        return flManPresenter.prepareSuccessView(friRespMod);
    }
}
