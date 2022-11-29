package flManager.application_business_rules;

import Entities.FriendList;
import Entities.FriendListFactory;
import interface_adapters.flManPresenter;

// 最重要的东西，实现add/ del/ view fri functions
// if...报错
public class flManUseCaseInteractor implements flManInputBoundary{

    final flManRepoInt flManRepoInt;
    final flManPresenter flManPresenter;
    final FriendListFactory flFactory;

    public flManUseCaseInteractor(flManRepoInt flManRepoInt, interface_adapters.flManPresenter flManPresenter, FriendListFactory flFactory) {
        this.flManRepoInt = flManRepoInt;
        this.flManPresenter = flManPresenter;
        this.flFactory = flFactory;
    }

    @Override
    public flManResponseModel create(flManRequestModel requestModel) {
        FriendList friendList = FriendListFactory.create(
                requestModel.getOwner(), requestModel.getFriends());

        flManRepoRequestModel repoReqMod = new flManRepoRequestModel(
                friendList.getOwner(), friendList.getFriends());

        flManRepoInt.save(repoReqMod);

        flManResponseModel friRespMod = new flManResponseModel(
                friendList.getOwner(), friendList.getFriends());
        return flManPresenter.prepareSuccessView(friRespMod);
    }

}
